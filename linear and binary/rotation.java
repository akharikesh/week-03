import java.util.Scanner;

public class rotation {
	public static int findrotation(int[] arr){
		int left = 0;
		int right = arr.length - 1;
		while (left < right){
			int mid = (left+right)/2;
			if (arr[mid]>arr[right]){
				left = mid - 1;
			}else {
			right  = mid;
			}
		}
		return left;
	}
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		int[] rotatedarray = new int[size];
		for (int i=0;i<size;i++){
			rotatedarray[i] = input.nextInt();
		}
		int index = findrotation(rotatedarray);
		System.out.println("Rotation point index : " + index);
		System.out.println("Smallest Element : " + rotatedarray[index]);
	}
}