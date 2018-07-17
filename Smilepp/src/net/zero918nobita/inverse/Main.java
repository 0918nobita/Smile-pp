package net.zero918nobita.inverse;

import net.zero918nobita.smilepp.frontend.Addition;
import net.zero918nobita.smilepp.frontend.AssignStm;
import net.zero918nobita.smilepp.frontend.Builder;
import net.zero918nobita.smilepp.frontend.Variable;

public class Main {
  public static void main(String... args) {
    Builder builder = new Builder();
    builder.addStm(new AssignStm(new Variable("a"), new Addition()));
    System.out.println(builder.toString());
  }
}
