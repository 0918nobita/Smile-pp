package net.zero918nobita.smilepp.frontend;

public class IntLiteral extends Node {
  private int n;

  public IntLiteral(int n) {
    this.n = n;
  }

  public String toString() {
    return String.valueOf(n);
  }
}
