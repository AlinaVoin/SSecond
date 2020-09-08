package ameno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JesusChristTest {

    @Test
    void encodeDecode_1() {
        JesusChrist xor = new JesusChrist();
        String text = "1973468205";
        String key = "keyToDecode";
        assertEquals(text, xor.XOR(xor.XOR(text, key), key));
    }

    @Test
    void encodeDecode_2() {
        JesusChrist xor = new JesusChrist();
        String text = "He sits in an armchair, 987";
        String key = "why 827";
        assertEquals(text, xor.XOR(xor.XOR(text, key), key));
    }

    @Test
    void encodeDecode_3() {
        JesusChrist xor = new JesusChrist();
        String text = "ему нравится так сидеть\n не спрашивай \n";
        String key = "ладно";
        assertEquals(text, xor.XOR(xor.XOR(text, key), key));
    }
}