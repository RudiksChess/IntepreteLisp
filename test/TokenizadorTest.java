import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TokenizadorTest {

    @org.junit.jupiter.api.Test
    void tokensbebe() {
        Tokenizador toks = new Tokenizador();
        String original = "(())";
        String[] prueba = {"(", "(",")",")"};
    assertEquals(original,toks.Tokensbebe(original).toString());
    }

    @org.junit.jupiter.api.Test
    void tokenpapa() {
        Tokenizador toks = new Tokenizador();
        String original = "((quote))";
        String[] prueba = {"(", "(","quote",")",")"};
        assertEquals(original,toks.Tokensbebe(original).toString());
    }
}