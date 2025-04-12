import java.util.Scanner;

public class firstndlast {
	public static int findfirst(int[] arr, int target){
		int left = 0;
		int right = arr.length - 1;
		int result = -1;
		while (left <= right){
			int mid = (left+right)/2;
			if (arr[mid]==target){
				result = mid;
				right = mid -1;
			}else if (arr[mid]>target){
				right = mid -1;
			}else{
				left= mid + 1;
			}
		}
		return result;
	}
	public static int findlast(int[] arr, int target){
		int left = 0;
		int right = arr.length - 1;
		int result = -1;
		while (left <= right){
			int mid = (left+right)/2;
			if (arr[mid]==target){
				result = mid;
				left = mid + 1;
			}else if (arr[mid]>target){
				right = mid -1;
			}else{
				left= mid + 1;
			}
		}
		return result;
	}
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		int[] arr = new int[size];
		for (int i=0;i<size;i++){
			arr[i] = input.nextInt();
		}
		int target = input.nextInt();
		int first = findfirst(arr, target);
		int last = findlast(arr, target);
		if (first==-1){
			System.out.println("Element Not Found");
		}else{
			System.out.println("First Occurance : " + first);
			System.out.println("Last Occurance: " + last);
		}
	}
}