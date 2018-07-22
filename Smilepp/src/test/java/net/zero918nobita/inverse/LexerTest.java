package net.zero918nobita.inverse;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class LexerTest {
  @Test
  public void testLex() {
    assertThat(
      Lexer.lex("let a = 2;\n" +
        "a ++;\n" +
        "console.log(a)\n").toString(),
      is("[[[\"let\", (1, 1)], [\"a\", (1, 5)], [\"=\", (1, 7)], [\"2\", (1, 9)]], " +
        "[[\"a\", (2, 1)], [\"++\", (2, 3)]], " +
        "[[\"console\", (3, 1)], [\".\", (3, 8)], [\"log\", (3, 9)], [\"(\", (3, 12)], [\"a\", (3, 13)], [\")\", (3, 14)]]]"));
  }
}
