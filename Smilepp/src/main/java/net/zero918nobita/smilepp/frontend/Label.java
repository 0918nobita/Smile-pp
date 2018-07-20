package net.zero918nobita.smilepp.frontend;

public class Label {
  private int n;

  public Label(int n) {
    this.n = n;
  }

  @Override
  public String toString() {
    return "L" + String.valueOf(n);
  }
}
