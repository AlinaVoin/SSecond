package ameno;
import java.io.*;


public class Jesus {

    public void encoder(String[] args) throws IOException {

        if (args.length != 3 && args.length != 5) {
            System.out.println("Неверное число аргументов");
            System.exit(1);
        }

        if (!args[0].equals("-c") || !args[0].equals("-d")) {
            System.out.println("Ожидается флаг");
            System.exit(1);
        }
        String key = args[1];
        String inputName = args[2];
        String outputName = "";
        if (args.length == 5) {
            if (!args[3].equals("-o")) {
                System.out.println("Ожидается -o");
                System.exit(1);
            } else outputName = args[4];
        } else outputName = ("out" + inputName);

        JesusChrist xor = new JesusChrist();
        xor.encodeDecode(inputName, outputName, key);
    }
}