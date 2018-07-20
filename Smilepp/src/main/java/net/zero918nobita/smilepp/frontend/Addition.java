package net.zero918nobita.smilepp.frontend;

public class Addition extends Stm {
  private Variable variable;
  private Node adder;

  public Addition() {}

  public Addition(Variable variable, Node adder) {
    this.variable = variable;
    this.adder = adder;
  }

  public void setVariable(Variable variable) {
    this.variable = variable;
  }

  public void setAdder(Node node) {
    adder = node;
  }

  @Override
  public String toString() {
    return variable + " += " + adder;
  }
}
