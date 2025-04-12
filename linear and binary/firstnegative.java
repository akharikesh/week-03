import java.util.Scanner;

public class firstnegative {
	public static int findnegative(int[] arr){
		for (int i=0;i<arr.length;i++){
			if (arr[i]<0){
				return i;
			}
		}
		return -1;
	}
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		int[] num = new int[size];
		for (int i=0;i<size;i++){
			num[i] = input.nextInt();
		}
		int index = findnegative(num);
		
		if (index!=-1){
			System.out.println("First negative number found at index : " + index);
		}else{
			System.out.println("No negative numbers found in the array");
		}
	}
}
		