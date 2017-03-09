package com.hayanige.sample.pattern.reactor;

import java.io.IOException;

public class Server {
  public static void main(String[] args) throws IOException {
    Reactor reactor = new Reactor(9900, true);
    new Thread(reactor).start();
  }
}
