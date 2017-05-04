package com.hayanige.sample.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
  public static final int ECHO_PORT = 10007;

  public static void main(String args[]) {
    ServerSocket serverSocket = null;
    Socket socket = null;
    try {
      serverSocket = new ServerSocket(ECHO_PORT);
      System.out.println("EchoServer started("
        + serverSocket.getLocalPort() + ")");
      socket = serverSocket.accept();
      BufferedReader in = new BufferedReader(
          new InputStreamReader(socket.getInputStream()));
      PrintWriter out = new PrintWriter(
          socket.getOutputStream(), true);
      String line;
      while ((line = in.readLine()) != null) {
        System.out.println("receive: " + line);
        out.println(line);
        System.out.println("send: " + line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (socket != null) {
          socket.close();
        }
      } catch (IOException e) {}
      try {
        if(serverSocket != null) {
          serverSocket.close();
        }
      } catch (IOException e) {}
    }
  }
}
