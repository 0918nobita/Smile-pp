package net.zero918nobita.smilepp.frontend;

import java.util.ArrayList;

public class Builder {
  private ArrayList<ArrayList<Stm>> source;

  public Builder() {
    source = new ArrayList<>();
    addLabel();
  }

  @Override
  public String toString() {
    return source.toString();
  }

  public void addStm(Stm stm) {
    source.get(source.size() - 1).add(stm);
  }

  public void addLabel() {
    source.add(new ArrayList<>());
  }
}
