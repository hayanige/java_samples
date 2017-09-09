/*
 * Copyright 2017 hayanige
 *
 * Use of this source code is governed by the MIT license.
 */
package com.hayanige.sample.command;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExecCommandFromJava {
  public static void main(String args[]) throws Exception {
    ProcessBuilder pb = new ProcessBuilder("tail", "-f", "/var/log/system.log");
    Process process = pb.start();

    // 下記のメソッドでコマンドの終了待ちと実行結果のエラーコードを取得できる
    // int errCode = process.waitFor();

    // コマンドの標準出力はInputStreamで取得可
    InputStream is = process.getInputStream();
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    try {
      for (;;) {
        String line = br.readLine();
        if (line == null) break;
        System.out.println(line);
      }
    } finally {
      br.close();
    }
  }
}
