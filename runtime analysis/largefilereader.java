import java.io.*;

public class largefilereader {
    public static void main(String[] args) {
        String filePath = "C:\\full stack web\\exaple.txt";

        try {
            long start = System.currentTimeMillis();
            FileReader fr = new FileReader(filePath);
            while (fr.read() != -1) {
            }
            fr.close();
            long end = System.currentTimeMillis();
            System.out.println("Time taken using FileReader: " + (end - start) + " ms");

            start = System.currentTimeMillis();
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis);
            while (isr.read() != -1) {
            }
            isr.close();
            end = System.currentTimeMillis();
            System.out.println("Time taken using InputStreamReader: " + (end - start) + " ms");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
