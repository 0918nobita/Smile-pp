package net.zero918nobita.acinonyx;

import net.zero918nobita.smilepp.frontend.Addition;
import net.zero918nobita.smilepp.frontend.AssignStm;
import net.zero918nobita.smilepp.frontend.Builder;
import net.zero918nobita.smilepp.frontend.IfStm;
import net.zero918nobita.smilepp.frontend.IntLiteral;
import net.zero918nobita.smilepp.frontend.Label;
import net.zero918nobita.smilepp.frontend.Variable;

public class Main {
  public static void main(String... args) {
    Builder builder = new Builder();
    Variable a = new Variable("a");
    Variable b = new Variable("b");

    builder.addStm(new AssignStm(a, new IntLiteral(2)));
    builder.addStm(new Addition(a, new IntLiteral(3)));
    builder.addStm(new IfStm(b, new Label(1)));

    builder.addLabel();

    System.out.println(builder);
  }
}
