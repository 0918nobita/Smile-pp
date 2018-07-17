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
    StringBuilder result = new StringBuilder();

    for (int il = 0; il < source.size(); il++) {
      result.append("L");
      result.append(il);
      result.append(":\n");

      for (int is = 0; is < source.get(il).size(); is++) {
        result.append("  ");
        result.append(source.get(il).get(is));
        result.append("\n");
      }
    }

    return result.toString();
  }

  public void addStm(Stm stm) {
    source.get(source.size() - 1).add(stm);
  }

  public void addLabel() {
    source.add(new ArrayList<>());
  }
}
