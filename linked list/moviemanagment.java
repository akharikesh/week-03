class MovieNode {
    String title;
    String director;
    int yearOfRelease;
    double rating;
    MovieNode next;
    MovieNode prev;

    MovieNode(String title, String director, int yearOfRelease, double rating) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieLinkedList {
    private MovieNode head;
    private MovieNode tail;

    public MovieLinkedList() {
        head = null;
        tail = null;
    }

    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newMovie = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = newMovie;
            tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newMovie = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = newMovie;
            tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 1 || head == null) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode newMovie = new MovieNode(title, director, year, rating);
        MovieNode current = head;

        for (int i = 1; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }

        newMovie.next = current.next;
        if (current.next != null) {
            current.next.prev = newMovie;
        }
        current.next = newMovie;
        newMovie.prev = current;

        if (newMovie.next == null) {
            tail = newMovie;
        }
    }

    public void removeByTitle(String title) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equals(title)) {
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
                System.out.println("Movie with title \"" + title + "\" has been removed.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie with title \"" + title + "\" not found.");
    }

    public void searchByDirector(String director) {
        MovieNode current = head;
        while (current != null) {
            if (current.director.equals(director)) {
                System.out.println("Movie Found: " + current.title + ", " + current.yearOfRelease + ", Rating: " + current.rating);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie by director \"" + director + "\" not found.");
    }

    public void searchByRating(double rating) {
        MovieNode current = head;
        while (current != null) {
            if (current.rating == rating) {
                System.out.println("Movie Found: " + current.title + ", " + current.director + ", " + current.yearOfRelease);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie with rating \"" + rating + "\" not found.");
    }

    public void displayAllForward() {
        if (head == null) {
            System.out.println("No movies available.");
            return;
        }
        MovieNode current = head;
        System.out.println("Movie Records (Forward):");
        while (current != null) {
            System.out.println(current.title + " | " + current.director + " | " + current.yearOfRelease + " | Rating: " + current.rating);
            current = current.next;
        }
    }

    public void displayAllReverse() {
        if (tail == null) {
            System.out.println("No movies available.");
            return;
        }
        MovieNode current = tail;
        System.out.println("Movie Records (Reverse):");
        while (current != null) {
            System.out.println(current.title + " | " + current.director + " | " + current.yearOfRelease + " | Rating: " + current.rating);
            current = current.prev;
        }
    }

    public void updateRating(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                current.rating = newRating;
                System.out.println("Rating for \"" + title + "\" has been updated to " + newRating);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie with title \"" + title + "\" not found.");
    }
}

public class moviemanagment {
    public static void main(String[] args) {
        MovieLinkedList movieList = new MovieLinkedList();
        java.util.Scanner sc = new java.util.Scanner(System.in);

        while (true) {
            System.out.println("\n--- Movie Management Menu ---");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search Movie by Director");
            System.out.println("6. Search Movie by Rating");
            System.out.println("7. Display All Movies Forward");
            System.out.println("8. Display All Movies Reverse");
            System.out.println("9. Update Movie Rating");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            String title, director;
            int year;
            double rating;
            int position;

            switch (choice) {
                case 1:
                    System.out.print("Enter Movie Title: ");
                    title = sc.nextLine();
                    System.out.print("Enter Director: ");
                    director = sc.nextLine();
                    System.out.print("Enter Year of Release: ");
                    year = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    rating = sc.nextDouble();
                    movieList.addAtBeginning(title, director, year, rating);
                    break;

                case 2:
                    System.out.print("Enter Movie Title: ");
                    title = sc.nextLine();
                    System.out.print("Enter Director: ");
                    director = sc.nextLine();
                    System.out.print("Enter Year of Release: ");
                    year = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    rating = sc.nextDouble();
                    movieList.addAtEnd(title, director, year, rating);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    position = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Movie Title: ");
                    title = sc.nextLine();
                    System.out.print("Enter Director: ");
                    director = sc.nextLine();
                    System.out.print("Enter Year of Release: ");
                    year = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    rating = sc.nextDouble();
                    movieList.addAtPosition(position, title, director, year, rating);
                    break;

                case 4:
                    System.out.print("Enter Movie Title to Remove: ");
                    title = sc.nextLine();
                    movieList.removeByTitle(title);
                    break;

                case 5:
                    System.out.print("Enter Director to Search: ");
                    director = sc.nextLine();
                    movieList.searchByDirector(director);
                    break;

                case 6:
                    System.out.print("Enter Rating to Search: ");
                    rating = sc.nextDouble();
                    movieList.searchByRating(rating);
                    break;

                case 7:
                    movieList.displayAllForward();
                    break;

                case 8:
                    movieList.displayAllReverse();
                    break;

                case 9:
                    System.out.print("Enter Movie Title to Update Rating: ");
                    title = sc.nextLine();
                    System.out.print("Enter New Rating: ");
                    rating = sc.nextDouble();
                    movieList.updateRating(title, rating);
                    break;

                case 10:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
