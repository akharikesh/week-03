import java.util.HashSet;

public class PairWithGivenSum {

    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> seenNumbers = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;

            if (seenNumbers.contains(complement)) {
                return true; 
            }

            seenNumbers.add(num);
        }

        return false; 
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 3, 6, 5, 8};
        int target = 10;

        if (hasPairWithSum(arr, target)) {
            System.out.println("Pair with given sum exists.");
        } else {
            System.out.println("No pair with given sum exists.");
        }
    }
}
