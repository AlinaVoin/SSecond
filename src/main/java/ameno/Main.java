package ameno;
import java.io.File;

public class Main {
    public static void main(String[] args)  {
        //ciphxor -c 10 out_test.txt -o res.txt
        //ciphxor -c 10 test.txt
        if (args.length != 4 && args.length != 6) {
            System.out.println("Неверное число аргументов");
            return;
        }


        if (!args[1].equals("-c") && !args[1].equals("-d")) {
            System.out.println("Ожидается флаг");
            return;
        }
        String key = args[2];
        String inputName = args[3];
        String outputName = "";
        if(args.length==6){
            if (!args[4].equals("-o")) {
                System.out.println("Ожидается -o");
                return;
            }
            outputName = args[5];
        }else{
            File file = new File(inputName);
            outputName = file.getParent() + "\\out_"+ file.getName();
        }

        Functions xor = new Functions();
        xor.encodeDecode(inputName, outputName, key);
    }
}