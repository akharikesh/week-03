import java.io.*;

public class filereaderr {
	public static void main (String[] args) throws IOException {
		
		String filpath = "C:\\full stack web\\exaple.txt";
		
		FileReader fr = new FileReader(filpath);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null){
			System.out.println(line);
		}
		fr.close();
		br.close();
	}
}