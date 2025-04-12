import java.util.Scanner;

public class reversestring {
	public static String reversestringbuilder(String word){
		StringBuilder sb = new StringBuilder(word);
		sb.reverse();
		return sb.toString();
	}
	public static  void  main(String[] args){
		Scanner input = new Scanner(System.in);
		String word = input.nextLine();
		String reversed =  reversestringbuilder(word);
		System.out.println("Reversed String : " + reversed);
	}
}