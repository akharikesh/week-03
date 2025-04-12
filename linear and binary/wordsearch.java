import java.util.Scanner;

public class wordsearch {
	public static String searchsentence(String[] sentences, String word){
		for (String sentence : sentences){
			if (sentence.contains(word)){
				return sentence;
			}
		}
		return "Not Found";
	}
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		input.nextLine();
		String[] sentences = new String[size];
		for (int i=0;i<size;i++){
			sentences[i] = input.nextLine();
		}
		String targetword = input.nextLine();
		String result = searchsentence(sentences, targetword);
		System.out.println("Result : " + result);
	}
}