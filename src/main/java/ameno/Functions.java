package ameno;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Functions {
    private byte[] bytes;


    public String encodeDecode(String inputFile, String outputFile, String key) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        StringBuilder sb = new StringBuilder();
        try {
            fis = new FileInputStream(inputFile);
            fos = new FileOutputStream(outputFile);

            int availible = fis.available();
            initBytes(availible, key);
            while (availible != 0) {
                fis.read(bytes);
                byte[] keys = key.getBytes();
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] = (byte) (bytes[i] ^ keys[i]);
                }
                fos.write(bytes);
                sb.append(new String(bytes));
                availible = fis.available();
                initBytes(availible, key);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    private void initBytes(int availible, String key){
        if(availible >= key.length()){
            bytes = new byte[key.length()];
        }else{
            bytes = new byte[availible];
        }
    }


}