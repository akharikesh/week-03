import java.util.Scanner;

public class concatenate{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuffer buffer = new StringBuffer();
		
        String line = input.nextLine(); 
		String[] words = line.split(" ");
		for (String word : words){
            buffer.append(word);
        }

        String result = buffer.toString();
        System.out.println("\nConcatenated String: " + result);
    }
}