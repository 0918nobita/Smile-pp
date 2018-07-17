package net.zero918nobita.inverse;

import net.zero918nobita.smilepp.frontend.Addition;
import net.zero918nobita.smilepp.frontend.AssignStm;
import net.zero918nobita.smilepp.frontend.Builder;
import net.zero918nobita.smilepp.frontend.IntLiteral;
import net.zero918nobita.smilepp.frontend.Variable;

public class Main {
  public static void main(String... args) {
    Builder builder = new Builder();
    Variable a = new Variable("a");
    Variable b = new Variable("b");
    builder.addStm(new AssignStm(a, new IntLiteral(2)));
    builder.addLabel();
    builder.addStm(new Addition(b, a, new IntLiteral(3)));
    System.out.println(builder);
  }
}
