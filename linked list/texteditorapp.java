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

class TextEditor {
    private TextNode currentState;
    private int historyLimit;
    private int historySize;
    
    public TextEditor(int historyLimit) {
        this.historyLimit = historyLimit;
        this.historySize = 0;
        this.currentState = null;
    }

    public void addState(String text) {
        TextNode newNode = new TextNode(text);
        
        if (currentState != null) {
            currentState.next = newNode;
            newNode.prev = currentState;
        }

        currentState = newNode;
        historySize++;

        if (historySize > historyLimit) {
            currentState.prev = null;
            historySize--;
        }
    }

    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
        } else {
            System.out.println("No more states to undo.");
        }
    }

    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
        } else {
            System.out.println("No more states to redo.");
        }
    }

    public void displayState() {
        if (currentState != null) {
            System.out.println("Current Text: " + currentState.text);
        } else {
            System.out.println("No text state available.");
        }
    }
    
    public String getCurrentState() {
        return currentState != null ? currentState.text : "";
    }
}

public class texteditorapp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(5); 

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

        editor.redo();

        editor.undo();
        editor.displayState();

        editor.undo();
        editor.displayState();

        editor.redo();
        editor.displayState();

        editor.undo();
        editor.displayState();

        editor.undo();
        editor.displayState();

        editor.undo();
        editor.displayState();
        
        editor.undo();
        editor.displayState();
    }
}
