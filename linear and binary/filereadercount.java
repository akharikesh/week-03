import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class filereadercount {
	public static void main (String[] args) throws IOException {
		
		String filepath = "C:\\full stack web\\exaple.txt";
        String targetword = "line";
		int count =0;
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		String line;
		while ((line = br.readLine()) != null){
			String[] words = line.split("\\s+");
			for (String word : words){
				if (word.equalsIgnoreCase(targetword)){
				count++;
				}
			}
		}
		br.close();
		System.out.println("The word " + targetword + " appears " + count + " times.");
	}
}