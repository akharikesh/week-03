// Node class representing a state of the text content
class TextNode {
    String text;
    TextNode prev;
    TextNode next;

    public TextNode(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}

// Class representing the Undo/Redo functionality using a Doubly Linked List
class TextEditor {
    private TextNode currentState;
    private int historyLimit;
    private int historySize;
    
    public TextEditor(int historyLimit) {
        this.historyLimit = historyLimit;
        this.historySize = 0;
        this.currentState = null;
    }

    // Add a new text state (after an action like typing)
    public void addState(String text) {
        TextNode newNode = new TextNode(text);
        
        // If there's already a current state, link it to the new state
        if (currentState != null) {
            currentState.next = newNode;
            newNode.prev = currentState;
        }

        // Move the current state to the new node
        currentState = newNode;
        historySize++;

        // If history exceeds the limit, remove the oldest state (i.e., the head of the list)
        if (historySize > historyLimit) {
            currentState.prev = null;
            historySize--;
        }
    }

    // Undo functionality (revert to the previous state)
    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
        } else {
            System.out.println("No more states to undo.");
        }
    }

    // Redo functionality (revert to the next state after undo)
    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
        } else {
            System.out.println("No more states to redo.");
        }
    }

    // Display the current state of the text
    public void displayState() {
        if (currentState != null) {
            System.out.println("Current Text: " + currentState.text);
        } else {
            System.out.println("No text state available.");
        }
    }
    
    // Get the current state (useful for testing purposes)
    public String getCurrentState() {
        return currentState != null ? currentState.text : "";
    }
}

// Main class to test the Undo/Redo functionality
public class texteditor {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(5); // History limit set to 5 states

        // Simulate typing actions
        editor.addState("Hello");
        editor.displayState();

        editor.addState("Hello, world!");
        editor.displayState();

        editor.addState("Hello, world! How are you?");
        editor.displayState();

        editor.addState("Hello, world! How are you? I'm fine.");
        editor.displayState();

        editor.addState("Hello, world! How are you? I'm fine. What about you?");
        editor.displayState();

        // Trying to redo without undo (no action)
        editor.redo();

        // Undo actions
        editor.undo();
        editor.displayState();

        editor.undo();
        editor.displayState();

        // Redo actions
        editor.redo();
        editor.displayState();

        // Undo more
        editor.undo();
        editor.displayState();

        // Undo to the first state
        editor.undo();
        editor.displayState();

        // Trying to undo beyond history limit
        editor.undo();
        editor.displayState();
        
        // Undo after history limit reached
        editor.undo();
        editor.displayState();
    }
}
