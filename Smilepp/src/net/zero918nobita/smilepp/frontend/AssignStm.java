package net.zero918nobita.smilepp.frontend;

public class AssignStm extends Stm {
  private Variable variable;
  private Expression expression;

  public AssignStm() {}

  public AssignStm(Variable variable, Expression expression) {
    this.variable = variable;
    this.expression = expression;
  }

  public void setVariable(Variable variable) {
    this.variable = variable;
  }

  public void setExpression(Expression expression) {
    this.expression = expression;
  }

  public String toString() {
    return variable + " = " + expression;
  }
}
