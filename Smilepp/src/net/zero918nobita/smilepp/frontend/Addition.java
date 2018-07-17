package net.zero918nobita.smilepp.frontend;

public class Addition extends Stm {
  private Variable variable;
  private Node node1;
  private Node node2;

  public Addition() {}

  public Addition(Variable variable, Node node1, Node node2) {
    this.variable = variable;
    this.node1 = node1;
    this.node2 = node2;
  }

  public void setVariable(Variable variable) {
    this.variable = variable;
  }

  public void setExpr1(Node node) {
    node1 = node;
  }

  public void setExpr2(Node node) {
    node2 = node;
  }

  public String toString() {
    return variable + " = " + node1 + " + " + node2;
  }
}
