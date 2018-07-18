package net.zero918nobita.smilepp.frontend;

public class Variable extends Node {
  private String name;

  public Variable() {}

  public Variable(String name) {
    this.name = name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
