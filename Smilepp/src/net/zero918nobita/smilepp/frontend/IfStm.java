package net.zero918nobita.smilepp.frontend;

public class IfStm extends Stm {
  private Node cond;
  private Label then;

  public IfStm() {}

  public IfStm(Node cond, Label then) {
    this.cond = cond;
    this.then = then;
  }

  public void setCond(Node cond) {
    this.cond = cond;
  }

  public void setLabel(Label then) {
    this.then = then;
  }

  @Override
  public String toString() {
    return "if " + cond + " goto " + then;
  }
}
