import java.util.Stack;

class sortstack {
    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        
        int top = stack.pop();
        
        sortStack(stack);
        
        insertSorted(stack, top);
    }
    
    public static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element >= stack.peek()) {
            stack.push(element);
            return;
        }
        
        int top = stack.pop();
        
        insertSorted(stack, element);
        
        stack.push(top);
    }
    
    public static void printStack(Stack<Integer> stack) {
        for (int i : stack) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);
        
        System.out.println("Original Stack:");
        printStack(stack);
        
        sortStack(stack);
        
        System.out.println("Sorted Stack:");
        printStack(stack);
    }
}
