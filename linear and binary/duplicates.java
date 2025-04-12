import java.util.HashSet;
import java.util.Scanner;

public class duplicates {
	public static String removeduplicates(String word){
		StringBuilder result = new StringBuilder();
		HashSet<Character> seen = new HashSet<>();
		
		for (char ch  : word.toCharArray()){
			if (!seen.contains(ch)){
				seen.add(ch);
				result.append(ch);
			}
		}
		return result.toString();
	}
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		String word = input.nextLine();
		String noduplicates = removeduplicates(word);
		System.out.println("String without duplicates : " + noduplicates);
	}
}