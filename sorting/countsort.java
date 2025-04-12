public class countsort {

    public static void countingSort(int[] ages) {
        int n = ages.length;

        int maxAge = 18;
        int minAge = 10;

        int[] count = new int[maxAge - minAge + 1];

        for (int i = 0; i < n; i++) {
            count[ages[i] - minAge]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }

        System.arraycopy(output, 0, ages, 0, n);
    }

    public static void printArray(int[] ages) {
        for (int age : ages) {
            System.out.print(age + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] studentAges = {15, 12, 10, 18, 14, 13, 17, 11, 16, 15};

        System.out.println("Original Student Ages:");
        printArray(studentAges);

        countingSort(studentAges);

        System.out.println("Sorted Student Ages:");
        printArray(studentAges);
    }
}
