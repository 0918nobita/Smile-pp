package net.zero918nobita.smilepp.frontend;

public class AssignStm extends Stm {
  private Variable variable;
  private Expression expression;

  public AssignStm(Variable variable, Expression expression) {
    this.variable = variable;
    this.expression = expression;
  }

  public String toString() {
    return variable + " = " + expression;
  }
}
