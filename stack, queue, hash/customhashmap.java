class customhashmap {
    private static final int SIZE = 10;  // Size of the array
    private LinkedList<Entry>[] table;

    // Inner class to represent key-value pairs
    static class Entry {
        String key;
        int value;
        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor to initialize the hash table
    public CustomHashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function to get the index for a given key
    private int getHash(String key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    // Put method to insert key-value pair
    public void put(String key, int value) {
        int index = getHash(key);
        LinkedList<Entry> list = table[index];
        
        // Check if key exists in the list and update value
        for (Entry entry : list) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        
        // If key does not exist, add a new entry
        list.add(new Entry(key, value));
    }

    // Get method to retrieve value by key
    public Integer get(String key) {
        int index = getHash(key);
        LinkedList<Entry> list = table[index];
        
        for (Entry entry : list) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        
        return null;  // Key not found
    }

    // Remove method to delete key-value pair by key
    public void remove(String key) {
        int index = getHash(key);
        LinkedList<Entry> list = table[index];
        
        for (Entry entry : list) {
            if (entry.key.equals(key)) {
                list.remove(entry);
                return;
            }
        }
    }

    // Display all key-value pairs in the hash map
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            if (!table[i].isEmpty()) {
                System.out.print("Index " + i + ": ");
                for (Entry entry : table[i]) {
                    System.out.print("{" + entry.key + "=" + entry.value + "} ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();

        // Inserting elements
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("grape", 30);

        // Retrieving elements
        System.out.println("Value for apple: " + map.get("apple"));
        System.out.println("Value for banana: " + map.get("banana"));

        // Display the entire hash map
        map.display();

        // Removing an element
        map.remove("banana");

        // Display the hash map after removal
        System.out.println("After removing banana:");
        map.display();
    }
}
