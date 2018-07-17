package net.zero918nobita.smilepp.frontend;

public class AssignStm extends Stm {
  private Variable variable;
  private Node node;

  public AssignStm() {}

  public AssignStm(Variable variable, Node node) {
    this.variable = variable;
    this.node = node;
  }

  public void setVariable(Variable variable) {
    this.variable = variable;
  }

  public void setExpression(Node node) {
    this.node = node;
  }

  public String toString() {
    return variable + " = " + node;
  }
}
