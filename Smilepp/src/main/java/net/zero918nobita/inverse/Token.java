package net.zero918nobita.inverse;

class Token {
  private String name;
  private int line;
  private int letter;

  Token(String name, int line, int letter) {
    this.name = name;
    this.line = line;
    this.letter = letter;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Token)) return false;
    Token token = (Token) o;
    return (token.letter == this.letter) && (token.line == this.line) && (token.name.equals(this.name));
  }

  @Override
  public String toString() {
    return "[\"" + name + "\", (" + line + ", " + letter + ")]";
  }
}
