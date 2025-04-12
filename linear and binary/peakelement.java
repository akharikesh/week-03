import java.util.Scanner;

public class peakelement {
	public static int findpeak(int[] arr){
		int left = 0;
		int right = arr.length - 1;
		while (left < right){
			int mid = (left+right)/2;
			boolean lefte = (mid==0) || (arr[mid]>arr[mid-1]);
			boolean righte = (mid==arr.length) || (arr[mid]<arr[mid+1]);
			if (righte && lefte){
				return mid;
			}else if (mid >0 && arr[mid]<arr[mid+1]){
				right = mid-1;
			}else{
				left = mid+1;
			}
		}
		return -1;
	}
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		int[] arr = new int[size];
		for (int i=0;i<size;i++){
			arr[i] = input.nextInt();
		}
		int index = findpeak(arr);
		System.out.println("Peak Element found at index : " + index);
		System.out.println("Peak Element : " + arr[index]);
	}
}