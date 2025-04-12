public class quicksort {

    public static int partition(int[] prices, int low, int high) {
        int pivot = prices[high];
        int i = low - 1; 

        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++; 
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);

            quickSort(prices, low, pivotIndex - 1); 
            quickSort(prices, pivotIndex + 1, high); 
        }
    }

    public static void printArray(int[] prices) {
        for (int price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] productPrices = {450, 300, 150, 500, 350, 200, 100};

        System.out.println("Original Product Prices:");
        printArray(productPrices);

        quickSort(productPrices, 0, productPrices.length - 1);

        System.out.println("Sorted Product Prices:");
        printArray(productPrices);
    }
}
