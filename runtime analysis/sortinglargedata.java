import java.util.*;

class sortinglargedata{
	public static void bubblesort (int[] arr){
		int n= arr.length;
		for (int i=0;i<n-1;i++){
			for (int j=0;j<n-i-1;j++){
				if (arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	public static void mergesort(int[] arr){
		if (arr.length<2) return;
		int mid = arr.length/2;
		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);
		mergesort(left);
		mergesort(right);
		merge(arr, left, right);
	}
	public static void merge(int[] arr, int[] left, int[] right){
		int i=0, j=0, k=0;
		while(i < left.length && j < right.length) {
            if(left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }
        while(i < left.length) arr[k++] = left[i++];
        while(j < right.length) arr[k++] = right[j++];		
	}
	public static void quicksort(int[] arr, int low, int high){
		if (low < high){
			int pi = partition(arr, low, high);
			quicksort(arr, low, pi-1);
			quicksort(arr, pi+1, high);
		}
	}
	public static int partition(int[] arr, int low, int high){
		int pivot = arr[high];
		int i = low-1;
		for (int j=low;j<high;j++){
			if (arr[j]<=pivot){
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		return i+1;
	}
				
	public static int[] randomarray (int size){
		Random rand = new Random();
		int[] arr = new int[size];
		for (int i=0;i<size;i++){
			arr[i] = rand.nextInt(100000);
		}
		return arr;
	}
	public static void main(String[] args){
		int[] sizes = {1000, 10000, 1000000};
		for (int size : sizes){
			System.out.println("Dataset Size: " + size);
			int[] data = randomarray(size);
			if (size<=10000){
				int[] arr1 = Arrays.copyOf(data, data.length);
				long start1 = System.currentTimeMillis();
				bubblesort(arr1);
				long end1 = System.currentTimeMillis();
				System.out.println("Bubble Sort : " + (end1-start1));
			}else{
				System.out.println("Bubble Sort : Skipped");
			}
			int[] arr2 = Arrays.copyOf(data, data.length);
			long start2 = System.currentTimeMillis();
			mergesort(arr2);
			long end2 = System.currentTimeMillis();
			System.out.println("Merge Sort : " +(end2-start2));
			
			int[] arr3 = Arrays.copyOf(data, data.length);
			long start3 = System.currentTimeMillis();
			quicksort(arr3, 0, arr3.length-1);
			long end3 = System.currentTimeMillis();
			System.out.println("Quick Sort : " +(end3-start3));
		}
	}
}
		