package net.zero918nobita.smilepp.frontend;

public class Builder {
  private String source;

  public Builder() {
    source = "";
  }

  @Override
  public String toString() {
    return source;
  }

  public void addStm(Stm stm) {
    source += stm;
  }
}
