package net.zero918nobita.inverse;

import java.util.ArrayList;

class Lexer {
  static ArrayList<ArrayList<Token>> lex(String src) {
    if (src.charAt(src.length() - 1) == '\n')
      src = src.substring(0, src.length() - 1);

    ArrayList<ArrayList<Token>> tokens = new ArrayList<>();
    tokens.add(new ArrayList<>());

    StringBuilder stock = new StringBuilder();

    int line = 1;
    int letter = 1;

    for (int i = 0; i < src.length(); i++) {
      char c = src.charAt(i);

      if (c == '\n') {
        line++;
        letter = 1;
      } else {
        letter++;
      }

      if ((c == ' ' || c == '\n') && stock.length() != 0) {
        tokens.get(tokens.size() - 1).add(new Token(stock.toString(), line, letter - (1 + stock.length())));
        stock.delete(0, stock.length());
        continue;
      }

      if ((c == ' ' || c == '\n') && stock.length() == 0) continue;

      if (c == '(' || c == ')' || c == '.') {
        tokens.get(tokens.size() - 1).add(new Token(stock.toString(), line, letter - (1 + stock.length())));
        stock.delete(0, stock.length());

        tokens.get(tokens.size() - 1).add(new Token(String.valueOf(c), line, letter - 1));
        continue;
      }

      if (c == ';') {
        if (stock.length() != 0) {
          tokens.get(tokens.size() - 1).add(new Token(stock.toString(), line, letter - (1 + stock.length())));
          stock.delete(0, stock.length());
        }
        tokens.add(new ArrayList<>());
        continue;
      }

      stock.append(c);
    }

    if (stock.length() != 0)
      tokens.get(tokens.size() - 1).add(new Token(stock.toString(), line, letter - stock.length()));

    return tokens;
  }
}
