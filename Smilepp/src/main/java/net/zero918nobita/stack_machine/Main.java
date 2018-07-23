package net.zero918nobita.stack_machine;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Stack;

class Main {
  private static byte[] code = new byte[256];
  private static int codeLength = 0;
  private Stack<Byte> operandStack = new Stack<>();
  private int pc;

  public static void main(String[] args) {

  }

  private static void load(String name) {
    FileInputStream fis;
    try {
      fis = new FileInputStream(new File(name));
      int len = 0;
      while ((len = fis.read(code, len, 8)) != -1) codeLength += len;
      fis.close();
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}
