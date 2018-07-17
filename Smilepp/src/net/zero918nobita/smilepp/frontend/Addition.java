package net.zero918nobita.smilepp.frontend;

public class Addition extends Stm {
  private Variable variable;
  private Expression expr1;
  private Expression expr2;

  public Addition() {}

  public Addition(Variable variable, Expression expr1, Expression expr2) {
    this.variable = variable;
    this.expr1 = expr1;
    this.expr2 = expr2;
  }

  public void setVariable(Variable variable) {
    this.variable = variable;
  }

  public void setExpr1(Expression expr) {
    expr1 = expr;
  }

  public void setExpr2(Expression expr) {
    expr2 = expr;
  }

  public String toString() {
    return variable + " = " + expr1 + " + " + expr2;
  }
}
