import java.util.*;

class searchtarget{
	public static boolean linearsearch (int[] arr, int target){
		for (int val  : arr){
			if (val==target)
				return true;
		}
		return false;
	}
	public static boolean binarysearch (int[] arr, int target){
		int left = 0;
		int right = arr.length - 1;
		while (left <= right){
			int mid = (left+right)/2;
			if (arr[mid]==target){
				return true;
			}else if (arr[mid]>target){
				right = mid -1;
			}else{
				left= mid + 1;
			}
		}
		return false;
	}
	public static int[] randomarray (int size, int bound){
		Random rand = new Random();
		int[] arr = new int[size];
		for (int i=0;i<size;i++){
			arr[i] = rand.nextInt(bound);
		}
		return arr;
	}
	public static void main(String[] args){
		int[] sizes = {1000, 10000, 1000000};
		int target = -1;
		for (int size : sizes){
			int[] data = randomarray(size, size*2);
			long start1 = System.nanoTime();
			linearsearch(data, target);
			long end1 = System.nanoTime();
			long time1 = (end1-start1)/1000000;
			
			Arrays.sort(data);
			long start2 = System.nanoTime();
			binarysearch(data, target);
			long end2 = System.nanoTime();
			long time2 = (end2-start2)/1000000;
			
			System.out.println("Dataset Size: " + size);
			System.out.println("Linear search Time : " + time1);
			System.out.println("Binary Search Time : " + time2);
		}
	}
}
		