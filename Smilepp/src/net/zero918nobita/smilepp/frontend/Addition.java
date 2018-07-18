package net.zero918nobita.smilepp.frontend;

public class Addition extends Stm {
  private Variable variable;
  private Node left;
  private Node right;

  public Addition() {}

  public Addition(Variable variable, Node left, Node right) {
    this.variable = variable;
    this.left = left;
    this.right = right;
  }

  public void setVariable(Variable variable) {
    this.variable = variable;
  }

  public void setLeft(Node node) {
    left = node;
  }

  public void setRight(Node node) {
    right = node;
  }

  @Override
  public String toString() {
    return variable + " = " + left + " + " + right;
  }
}
