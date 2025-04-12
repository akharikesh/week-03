public class insertionsort {

    public static void insertionSort(int[] employeeIds) {
        int n = employeeIds.length;

        for (int i = 1; i < n; i++) {
            int key = employeeIds[i];
            int j = i - 1;

            while (j >= 0 && employeeIds[j] > key) {
                employeeIds[j + 1] = employeeIds[j];
                j = j - 1;
            }
            employeeIds[j + 1] = key; 
        }
    }

    public static void printArray(int[] employeeIds) {
        for (int id : employeeIds) {
            System.out.print(id + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] employeeIds = { 105, 102, 109, 101, 104, 103 };

        System.out.println("Original Employee IDs:");
        printArray(employeeIds);

        insertionSort(employeeIds);

        System.out.println("Sorted Employee IDs:");
        printArray(employeeIds);
    }
}
