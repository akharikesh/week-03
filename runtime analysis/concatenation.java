import java.util.*;

public class concatenation{
    public static void main(String[] args) {
        int n = 1000000; 
        String data = "a"; 

        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < n; i++) {
            str += data;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken using String: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(data);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken using StringBuilder: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbf.append(data);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken using StringBuffer: " + (endTime - startTime) + " ms");
    }
}
