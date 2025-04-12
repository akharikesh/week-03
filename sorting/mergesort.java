public class mergesort {

    public static void merge(int[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; 
            merge(prices, left, mid); 
            merge(prices, mid + 1, right);

            mergeHalves(prices, left, mid, right);
        }
    }

    public static void mergeHalves(int[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(prices, left, leftArr, 0, n1);
        System.arraycopy(prices, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                prices[k] = leftArr[i];
                i++;
            } else {
                prices[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            prices[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            prices[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] prices) {
        for (int price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] bookPrices = {300, 150, 450, 200, 350, 400, 100};

        System.out.println("Original Book Prices:");
        printArray(bookPrices);

        merge(bookPrices, 0, bookPrices.length - 1);

        System.out.println("Sorted Book Prices:");
        printArray(bookPrices);
    }
}
