import java.util.Stack;

public class stockspan {

    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            span[i] = (stack.isEmpty()) ? i + 1 : i - stack.peek();

            stack.push(i);
        }

        return span;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        System.out.println("Stock Prices:");
        printArray(prices);

        int[] span = calculateSpan(prices);

        System.out.println("Stock Span:");
        printArray(span);
    }
}
