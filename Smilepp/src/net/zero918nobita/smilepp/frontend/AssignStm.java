package net.zero918nobita.smilepp.frontend;

public class AssignStm extends Stm {
  private Variable variable;
  private Node value;

  public AssignStm() {}

  public AssignStm(Variable variable, Node node) {
    this.variable = variable;
    this.value = node;
  }

  public void setVariable(Variable variable) {
    this.variable = variable;
  }

  public void setValue(Node node) {
    this.value = node;
  }

  public String toString() {
    return variable + " = " + value;
  }
}
