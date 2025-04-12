class ItemNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    ItemNode next;

    ItemNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryLinkedList {
    private ItemNode head;

    public InventoryLinkedList() {
        head = null;
    }

    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        ItemNode newItem = new ItemNode(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        ItemNode newItem = new ItemNode(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            ItemNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newItem;
        }
    }

    public void addAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        if (position <= 1 || head == null) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }

        ItemNode newItem = new ItemNode(itemName, itemId, quantity, price);
        ItemNode current = head;
        for (int i = 1; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }

        newItem.next = current.next;
        current.next = newItem;
    }

    public void removeByItemId(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        ItemNode current = head;
        ItemNode previous = null;

        while (current != null) {
            if (current.itemId == itemId) {
                if (previous == null) {
                    head = current.next; 
                } else {
                    previous.next = current.next; 
                }
                System.out.println("Item with ID " + itemId + " has been removed.");
                return;
            }
            previous = current;
            current = current.next;
        }

        System.out.println("Item with ID " + itemId + " not found.");
    }

    public void updateQuantityByItemId(int itemId, int newQuantity) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                System.out.println("Quantity of item with ID " + itemId + " has been updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    public void searchByItemId(int itemId) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                System.out.println("Item Found: " + current.itemName + ", ID: " + current.itemId + 
                    ", Quantity: " + current.quantity + ", Price: " + current.price);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    public void searchByItemName(String itemName) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found: " + current.itemName + ", ID: " + current.itemId + 
                    ", Quantity: " + current.quantity + ", Price: " + current.price);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with name " + itemName + " not found.");
    }

    public void calculateTotalValue() {
        double totalValue = 0;
        ItemNode current = head;
        while (current != null) {
            totalValue += current.quantity * current.price;
            current = current.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    public void sortInventory(String sortBy, boolean ascending) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        ItemNode[] itemArray = toArray();

        if (sortBy.equalsIgnoreCase("name")) {
            sortByName(itemArray, ascending);
        } else if (sortBy.equalsIgnoreCase("price")) {
            sortByPrice(itemArray, ascending);
        }

        head = null;
        for (ItemNode item : itemArray) {
            addAtEnd(item.itemName, item.itemId, item.quantity, item.price);
        }
    }

    private ItemNode[] toArray() {
        int size = getSize();
        ItemNode[] itemArray = new ItemNode[size];
        ItemNode current = head;
        int index = 0;
        while (current != null) {
            itemArray[index++] = current;
            current = current.next;
        }
        return itemArray;
    }

    private int getSize() {
        int size = 0;
        ItemNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    private void sortByName(ItemNode[] itemArray, boolean ascending) {
        for (int i = 0; i < itemArray.length - 1; i++) {
            for (int j = i + 1; j < itemArray.length; j++) {
                if ((ascending && itemArray[i].itemName.compareTo(itemArray[j].itemName) > 0) || 
                    (!ascending && itemArray[i].itemName.compareTo(itemArray[j].itemName) < 0)) {
                    // Swap items
                    ItemNode temp = itemArray[i];
                    itemArray[i] = itemArray[j];
                    itemArray[j] = temp;
                }
            }
        }
    }

    private void sortByPrice(ItemNode[] itemArray, boolean ascending) {
        for (int i = 0; i < itemArray.length - 1; i++) {
            for (int j = i + 1; j < itemArray.length; j++) {
                if ((ascending && itemArray[i].price > itemArray[j].price) || 
                    (!ascending && itemArray[i].price < itemArray[j].price)) {
                    // Swap items
                    ItemNode temp = itemArray[i];
                    itemArray[i] = itemArray[j];
                    itemArray[j] = temp;
                }
            }
        }
    }

    public void displayAllItems() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        ItemNode current = head;
        System.out.println("Inventory:");
        while (current != null) {
            System.out.println("Item ID: " + current.itemId + ", Item Name: " + current.itemName + 
                ", Quantity: " + current.quantity + ", Price: " + current.price);
            current = current.next;
        }
    }
}

public class inventorymanage {
    public static void main(String[] args) {
        InventoryLinkedList inventoryList = new InventoryLinkedList();
        java.util.Scanner sc = new java.util.Scanner(System.in);

        while (true) {
            System.out.println("\n--- Inventory Management Menu ---");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by Item ID");
            System.out.println("5. Update Item Quantity by Item ID");
            System.out.println("6. Search Item by Item ID");
            System.out.println("7. Search Item by Item Name");
            System.out.println("8. Calculate Total Inventory Value");
            System.out.println("9. Sort Inventory by Name or Price");
            System.out.println("10. Display All Items");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            String itemName;
            int itemId, quantity;
            double price;
            int position;
            String sortBy;
            boolean ascending;

            switch (choice) {
                case 1:
                    System.out.print("Enter Item Name: ");
                    itemName = sc.nextLine();
                    System.out.print("Enter Item ID: ");
                    itemId = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    quantity = sc.nextInt();
                    System.out.print("Enter Price: ");
                    price = sc.nextDouble();
                    inventoryList.addAtBeginning(itemName, itemId, quantity, price);
                    break;

                case 2:
                    System.out.print("Enter Item Name: ");
                    itemName = sc.nextLine();
                    System.out.print("Enter Item ID: ");
                    itemId = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    quantity = sc.nextInt();
                    System.out.print("Enter Price: ");
                    price = sc.nextDouble();
                    inventoryList.addAtEnd(itemName, itemId, quantity, price);
                    break;

                case 3:
                    System.out.print("Enter position: ");
                    position = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Item Name: ");
                    itemName = sc.nextLine();
                    System.out.print("Enter Item ID: ");
                    itemId = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    quantity = sc.nextInt();
                    System.out.print("Enter Price: ");
                    price = sc.nextDouble();
                    inventoryList.addAtPosition(position, itemName, itemId, quantity, price);
                    break;

                case 4:
                    System.out.print("Enter Item ID to Remove: ");
                    itemId = sc.nextInt();
                    inventoryList.removeByItemId(itemId);
                    break;

                case 5:
                    System.out.print("Enter Item ID to Update Quantity: ");
                    itemId = sc.nextInt();
                    System.out.print("Enter New Quantity: ");
                    quantity = sc.nextInt();
                    inventoryList.updateQuantityByItemId(itemId, quantity);
                    break;

                case 6:
                    System.out.print("Enter Item ID to Search: ");
                    itemId = sc.nextInt();
                    inventoryList.searchByItemId(itemId);
                    break;

                case 7:
                    System.out.print("Enter Item Name to Search: ");
                    itemName = sc.nextLine();
                    inventoryList.searchByItemName(itemName);
                    break;

                case 8:
                    inventoryList.calculateTotalValue();
                    break;

                case 9:
                    System.out.print("Enter 'name' to sort by Name or 'price' to sort by Price: ");
                    sortBy = sc.nextLine();
                    System.out.print("Enter 'true' for ascending or 'false' for descending: ");
                    ascending = sc.nextBoolean();
                    inventoryList.sortInventory(sortBy, ascending);
                    break;

                case 10:
                    inventoryList.displayAllItems();
                    break;

                case 11:
                    System.out.println("Exiting the program.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
