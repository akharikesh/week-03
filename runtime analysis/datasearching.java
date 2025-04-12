import java.util.*;

public class datasearching {

    public static boolean searchArray(int[] arr, int key) {
        for (int value : arr) {
            if (value == key) return true;
        }
        return false;
    }

    public static boolean searchHashSet(HashSet<Integer> set, int key) {
        return set.contains(key);
    }

    public static boolean searchTreeSet(TreeSet<Integer> tree, int key) {
        return tree.contains(key);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int num = rand.nextInt(n * 10);
            arr[i] = num;
            hashSet.add(num);
            treeSet.add(num);
        }

        System.out.print("Enter key to search: ");
        int key = sc.nextInt();

        long start = System.nanoTime();
        boolean foundInArray = searchArray(arr, key);
        long end = System.nanoTime();
        System.out.println("Array Search: " + foundInArray + ", Time = " + (end - start) + " ns");

        start = System.nanoTime();
        boolean foundInHashSet = searchHashSet(hashSet, key);
        end = System.nanoTime();
        System.out.println("HashSet Search: " + foundInHashSet + ", Time = " + (end - start) + " ns");

        start = System.nanoTime();
        boolean foundInTreeSet = searchTreeSet(treeSet, key);
        end = System.nanoTime();
        System.out.println("TreeSet Search: " + foundInTreeSet + ", Time = " + (end - start) + " ns");

        sc.close();
    }
}
