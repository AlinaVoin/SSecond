package ameno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsTest {
    private Functions xor = new Functions();
    private String text = "hello world";
    private String key = "10";
    @Test
    void encodeDecode_encode() {
        String res = "YU]\\^\u0010F_C\\U";
        assertEquals(res, xor.encodeDecode("test.txt", "out.txt", key));
    }
    @Test
    void encodeDecode_decode() {
        assertEquals(text, xor.encodeDecode("out.txt", "res.txt", key));
    }

}