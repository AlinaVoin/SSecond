package ameno;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JesusChrist {

    String XOR(String exampleText, String exampleKey) {
        char[] sentence = new char[exampleText.length()];
        for (int i = 0; i < exampleText.length(); i++) {
            sentence[i] = (char) (exampleText.charAt(i) ^ exampleKey.charAt(i % exampleKey.length()));
        }
        return new String(sentence);
    }

    private String read(String in) {
        try {
            StringBuilder sb = new StringBuilder();
            List<String> lines = Files.readAllLines(Paths.get(in), StandardCharsets.UTF_16);
            for (int i = 0; i < lines.size(); i++) {
                sb.append(lines.get(i));
                if (i < lines.size() - 1) {
                    sb.append('\n');
                }
            }
            return sb.toString();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return null;
    }

    private void write(String in, String out) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(in), StandardCharsets.UTF_16);
            writer.write(out);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public void encodeDecode(String inputFile, String outputFile, String key) {
        String text = read(inputFile);
        if (text != null) {
            text = XOR(text, key);
            write(outputFile, text);
        }
    }
}