import java.util.Scanner;

public class fibonaccicomputation {

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Fibonacci position (n): ");
        int n = sc.nextInt();

        long startTime = System.currentTimeMillis();
        int fibRecursive = fibonacciRecursive(n);
        long endTime = System.currentTimeMillis();
        System.out.println("Recursive Fibonacci (" + n + ") = " + fibRecursive);
        System.out.println("Time taken (Recursive): " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        int fibIterative = fibonacciIterative(n);
        endTime = System.currentTimeMillis();
        System.out.println("Iterative Fibonacci (" + n + ") = " + fibIterative);
        System.out.println("Time taken (Iterative): " + (endTime - startTime) + " ms");

        sc.close();
    }
}
