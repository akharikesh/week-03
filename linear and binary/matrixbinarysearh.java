import java.util.Scanner;

public class matrixbinarysearh {
	public static boolean searchvalue(int[][] matrix, int target){
		int rows = matrix.length;
		int cols = matrix[0].length;
		int left = 0;
		int right = rows*cols - 1;
		while (left <= right){
			int mid = (left+right)/2;
			int row = mid/cols;
			int col = mid%cols;
			int midelement = matrix[row][col];
			if (midelement==target){
				return true;
			}else if (midelement>target) {
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
		return false;
	}
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		int rows = input.nextInt();
		int cols = input.nextInt();
		int[][] matrix = new int[rows][cols];
		for (int i=0;i<rows;i++){
			for (int j=0;j<cols;j++){
				matrix[i][j] = input.nextInt();
			}
		}
		int target = input.nextInt();
		boolean  found = searchvalue(matrix, target);
		System.out.println("Target Found? " + found);
		}
}