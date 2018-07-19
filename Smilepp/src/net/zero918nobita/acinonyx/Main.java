package net.zero918nobita.acinonyx;

import net.zero918nobita.smilepp.frontend.Addition;
import net.zero918nobita.smilepp.frontend.AssignStm;
import net.zero918nobita.smilepp.frontend.Builder;
import net.zero918nobita.smilepp.frontend.IfStm;
import net.zero918nobita.smilepp.frontend.IntLiteral;
import net.zero918nobita.smilepp.frontend.Label;
import net.zero918nobita.smilepp.frontend.Variable;

import java.util.ArrayList;

public class Main {
  public static void main(String... args) {
    String src = "let a = 2;\na ++;\nconsole.log(a)\n";
    System.out.println(src);

    ArrayList<ArrayList<Token>> result = Lexer.lex(src);

    for (int i_r = 0; i_r < result.size(); i_r++) {
      System.out.print(i_r + 1 + ": ");

      for (int i_t = 0; i_t < result.get(i_r).size(); i_t++) {
        System.out.print(result.get(i_r).get(i_t));
        if (i_t != result.get(i_r).size() - 1) System.out.print(", ");
      }

      System.out.println();
    }

    System.out.println();
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
