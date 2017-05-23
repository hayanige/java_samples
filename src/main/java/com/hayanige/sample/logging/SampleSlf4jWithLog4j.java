package com.hayanige.sample.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleSlf4jWithLog4j {
  public static void main(String[] args) throws Exception {
    Logger logger = LoggerFactory.getLogger(SampleSlf4jWithLog4j.class);
    logger.info("Hello World!!");
  }
}

