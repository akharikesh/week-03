class BookNode {
    String bookTitle;
    String author;
    String genre;
    int bookId;
    boolean availabilityStatus;
    BookNode next;
    BookNode prev;

    public BookNode(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.availabilityStatus = availabilityStatus;
        this.next = null;
        this.prev = null;
    }
}

class LibraryLinkedList {
    private BookNode head;
    private BookNode tail;
    private int count;

    public LibraryLinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    public void addAtBeginning(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
        BookNode newBook = new BookNode(bookTitle, author, genre, bookId, availabilityStatus);
        if (head == null) {
            head = newBook;
            tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        count++;
    }

    public void addAtEnd(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
        BookNode newBook = new BookNode(bookTitle, author, genre, bookId, availabilityStatus);
        if (head == null) {
            head = newBook;
            tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        count++;
    }

    public void addAtPosition(int position, String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
        if (position <= 1) {
            addAtBeginning(bookTitle, author, genre, bookId, availabilityStatus);
            return;
        }
        if (position > count) {
            addAtEnd(bookTitle, author, genre, bookId, availabilityStatus);
            return;
        }

        BookNode newBook = new BookNode(bookTitle, author, genre, bookId, availabilityStatus);
        BookNode current = head;

        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }

        newBook.next = current.next;
        newBook.prev = current;
        if (current.next != null) {
            current.next.prev = newBook;
        }
        current.next = newBook;

        count++;
    }

    public void removeByBookId(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        BookNode current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next; 
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev; 
                }
                System.out.println("Book with ID " + bookId + " has been removed.");
                count--;
                return;
            }
            current = current.next;
        }

        System.out.println("Book with ID " + bookId + " not found.");
    }

    public void searchByBookTitle(String bookTitle) {
        BookNode current = head;
        while (current != null) {
            if (current.bookTitle.equalsIgnoreCase(bookTitle)) {
                System.out.println("Book Found: " + current.bookTitle + " by " + current.author + 
                    ", Genre: " + current.genre + ", ID: " + current.bookId + ", Availability: " + (current.availabilityStatus ? "Available" : "Not Available"));
                return;
            }
            current = current.next;
        }
        System.out.println("Book with title " + bookTitle + " not found.");
    }

    public void searchByAuthor(String author) {
        BookNode current = head;
        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                System.out.println("Book Found: " + current.bookTitle + " by " + current.author + 
                    ", Genre: " + current.genre + ", ID: " + current.bookId + ", Availability: " + (current.availabilityStatus ? "Available" : "Not Available"));
                return;
            }
            current = current.next;
        }
        System.out.println("No books found by author " + author);
    }

    public void updateAvailabilityStatus(int bookId, boolean newStatus) {
        BookNode current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.availabilityStatus = newStatus;
                System.out.println("Availability status of book with ID " + bookId + " has been updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    public void displayAllBooksForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        BookNode current = head;
        System.out.println("Books in the Library (Forward Order):");
        while (current != null) {
            System.out.println("Book ID: " + current.bookId + ", Title: " + current.bookTitle + ", Author: " + current.author + 
                ", Genre: " + current.genre + ", Availability: " + (current.availabilityStatus ? "Available" : "Not Available"));
            current = current.next;
        }
    }

    public void displayAllBooksReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }

        BookNode current = tail;
        System.out.println("Books in the Library (Reverse Order):");
        while (current != null) {
            System.out.println("Book ID: " + current.bookId + ", Title: " + current.bookTitle + ", Author: " + current.author + 
                ", Genre: " + current.genre + ", Availability: " + (current.availabilityStatus ? "Available" : "Not Available"));
            current = current.prev;
        }
    }

    public void countBooks() {
        System.out.println("Total number of books in the library: " + count);
    }
}

public class librarymanage {
    public static void main(String[] args) {
        LibraryLinkedList library = new LibraryLinkedList();
        java.util.Scanner sc = new java.util.Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Management Menu ---");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by Book ID");
            System.out.println("5. Search Book by Book Title");
            System.out.println("6. Search Book by Author");
            System.out.println("7. Update Book Availability Status");
            System.out.println("8. Display All Books (Forward)");
            System.out.println("9. Display All Books (Reverse)");
            System.out.println("10. Count Total Books");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();  

            String bookTitle, author, genre;
            int bookId;
            boolean availabilityStatus;
            int position;

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    bookTitle = sc.nextLine();
                    System.out.print("Enter Author: ");
                    author = sc.nextLine();
                    System.out.print("Enter Genre: ");
                    genre = sc.nextLine();
                    System.out.print("Enter Book ID: ");
                    bookId = sc.nextInt();
                    System.out.print("Enter Availability Status (true for available, false for not): ");
                    availabilityStatus = sc.nextBoolean();
                    library.addAtBeginning(bookTitle, author, genre, bookId, availabilityStatus);
                    break;

                case 2:
                    System.out.print("Enter Book Title: ");
                    bookTitle = sc.nextLine();
                    System.out.print("Enter Author: ");
                    author = sc.nextLine();
                    System.out.print("Enter Genre: ");
                    genre = sc.nextLine();
                    System.out.print("Enter Book ID: ");
                    bookId = sc.nextInt();
                    System.out.print("Enter Availability Status (true for available, false for not): ");
                    availabilityStatus = sc.nextBoolean();
                    library.addAtEnd(bookTitle, author, genre, bookId, availabilityStatus);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    position = sc.nextInt();
                    sc.nextLine();  
                    System.out.print("Enter Book Title: ");
                    bookTitle = sc.nextLine();
                    System.out.print("Enter Author: ");
                    author = sc.nextLine();
                    System.out.print("Enter Genre: ");
                    genre = sc.nextLine();
                    System.out.print("Enter Book ID: ");
                    bookId = sc.nextInt();
                    System.out.print("Enter Availability Status (true for available, false for not): ");
                    availabilityStatus = sc.nextBoolean();
                    library.addAtPosition(position, bookTitle, author, genre, bookId, availabilityStatus);
                    break;

                case 4:
                    System.out.print("Enter Book ID to Remove: ");
                    bookId = sc.nextInt();
                    library.removeByBookId(bookId);
                    break;

                case 5:
                    System.out.print("Enter Book Title to Search: ");
                    bookTitle = sc.nextLine();
                    library.searchByBookTitle(bookTitle);
                    break;

                case 6:
                    System.out.print("Enter Author Name to Search: ");
                    author = sc.nextLine();
                    library.searchByAuthor(author);
                    break;

                case 7:
                    System.out.print("Enter Book ID to Update Availability Status: ");
                    bookId = sc.nextInt();
                    System.out.print("Enter New Availability Status (true for available, false for not): ");
                    availabilityStatus = sc.nextBoolean();
                    library.updateAvailabilityStatus(bookId, availabilityStatus);
                    break;

                case 8:
                    library.displayAllBooksForward();
                    break;

                case 9:
                    library.displayAllBooksReverse();
                    break;

                case 10:
                    library.countBooks();
                    break;

                case 11:
                    System.out.println("Exiting the system.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
