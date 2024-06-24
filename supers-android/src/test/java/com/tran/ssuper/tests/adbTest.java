package com.tran.ssuper.tests;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class adbTest extends TestBase {
  @Test
  public void adb() throws IOException {
    ProcessBuilder pb = new ProcessBuilder();
    pb.command("cmd.exe", "adb devices");
    Process process = pb.start();
    BufferedReader reader =
            new BufferedReader(new InputStreamReader(process.getInputStream()));

    String line;
    while ((line = reader.readLine()) != null) {
      System.out.println(line);
    }
  }
}
