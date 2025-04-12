class customhashmaps {
    private static final int SIZE = 10; 
    private LinkedList<Entry>[] table;

    static class Entry {
        String key;
        int value;
        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public CustomHashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int getHash(String key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void put(String key, int value) {
        int index = getHash(key);
        LinkedList<Entry> list = table[index];
        
        for (Entry entry : list) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        
        list.add(new Entry(key, value));
    }

    public Integer get(String key) {
        int index = getHash(key);
        LinkedList<Entry> list = table[index];
        
        for (Entry entry : list) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        
        return null;  
    }

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

        map.put("apple", 10);
        map.put("banana", 20);
        map.put("grape", 30);

        System.out.println("Value for apple: " + map.get("apple"));
        System.out.println("Value for banana: " + map.get("banana"));

        map.display();

        map.remove("banana");

        System.out.println("After removing banana:");
        map.display();
    }
}
