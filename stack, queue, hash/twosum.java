import java.util.HashMap;
import java.util.Scanner;

public class twosum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            map.put(nums[i], i);
        }
        
        return new int[] {};
    }

    public static void main(String[] args) {
		Scanner input  = new Scanner(System.in);
        int[] nums = new int[10];
        int target = input.nextInt();
        
        int[] result = twoSum(nums, target);
        
        if (result.length == 0) {
            System.out.println("No solution found");
        } else {
            System.out.println("Indices: " + result[0] + " and " + result[1]);
        }
    }
}
