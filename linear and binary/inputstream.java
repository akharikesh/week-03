import java.io.*;

public class inputstream {
	public static void main (String[] args) throws IOException {
				
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(input);
		FileWriter fr = new FileWriter("C:\\full stack web\\exaple.txt");
		System.out.println("Enter text ('exit' to stop):");
		String line;
		while ((line = br.readLine()).equalsIgnoreCase("exit")){
			fr.write(line + "\n");
		}
		br.close();
		fr.close();
	}
}