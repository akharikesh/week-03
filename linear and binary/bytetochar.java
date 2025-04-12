import java.io.*;

public class bytetochar {
	public static void main (String[] args) throws IOException {
		
		String filpath = "C:\\full stack web\\exaple.txt";
		
		FileInputStream finput = new FileInputStream(filpath);
		InputStreamReader input = new InputStreamReader(finput, "UTF-8");
		BufferedReader br = new BufferedReader(input);
		String line;
		while ((line = br.readLine()) != null){
			System.out.println(line);
		}
		br.close();
	}
}