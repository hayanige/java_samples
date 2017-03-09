package com.hayanige.sample.pattern.dynamic.proxy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLoggingProxy {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void cleanUpStreams() {
    System.setOut(null);
  }

  @Test
  public void checkOutput() {
    Set s = LoggingProxyFactory.getProxy(Set.class, new HashSet());
    s.add("three");
    if (!s.contains("four")) {
      s.add("four");
    }
    System.out.println(s);
    s.remove("three");

    assertTrue(outContent.toString().contains("add(three) -> true"));
    assertTrue(outContent.toString().contains("contains(four) -> false"));
    assertTrue(outContent.toString().contains("add(four) -> true"));
    assertTrue(outContent.toString().contains("toString() -> [four, three]"));
    assertTrue(outContent.toString().contains("remove(three) -> true"));
    assertFalse(outContent.toString().contains("remove(four) -> true"));
  }
}
