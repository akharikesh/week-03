import java.util.*;

public class zerosum {

    public static List<List<Integer>> findZeroSumSubarrays(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int cumulativeSum = 0;
        
        sumMap.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i]; 

            if (sumMap.containsKey(cumulativeSum)) {
                List<Integer> indices = sumMap.get(cumulativeSum);
                for (int index : indices) {
                    List<Integer> subarray = new ArrayList<>();
                    for (int j = index + 1; j <= i; j++) {
                        subarray.add(arr[j]);
                    }
                    result.add(subarray); 
                }
            }

            sumMap.putIfAbsent(cumulativeSum, new ArrayList<>());
            sumMap.get(cumulativeSum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {6, -1, -3, 4, -2, 2, 5, -3};

        List<List<Integer>> subarrays = findZeroSumSubarrays(arr);
        
        if (subarrays.isEmpty()) {
            System.out.println("No subarray with zero sum found.");
        } else {
            for (List<Integer> subarray : subarrays) {
                System.out.println(subarray);
            }
        }
    }
}
