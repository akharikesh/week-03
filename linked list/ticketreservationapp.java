class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    public TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private TicketNode head;
    private TicketNode tail;

    public TicketReservationSystem() {
        head = null;
        tail = null;
    }

    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            head = newTicket;
            tail = newTicket;
            newTicket.next = head; 
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head; 
        }
    }

    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        TicketNode current = head;
        TicketNode previous = null;

        if (head.ticketId == ticketId) {
            if (head == tail) { 
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head; 
            }
            System.out.println("Ticket with ID " + ticketId + " removed.");
            return;
        }

        do {
            previous = current;
            current = current.next;
            if (current.ticketId == ticketId) {
                previous.next = current.next;
                if (current == tail) {
                    tail = previous; 
                }
                System.out.println("Ticket with ID " + ticketId + " removed.");
                return;
            }
        } while (current != head);

        System.out.println("Ticket with ID " + ticketId + " not found.");
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets to display.");
            return;
        }

        TicketNode current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName +
                               ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                               ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    public void searchTicket(String searchTerm) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        TicketNode current = head;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(searchTerm) || current.movieName.equalsIgnoreCase(searchTerm)) {
                System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName +
                                   ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                                   ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tickets found matching: " + searchTerm);
        }
    }

    public int totalBookedTickets() {
        if (head == null) {
            return 0;
        }

        int count = 0;
        TicketNode current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);

        return count;
    }
}

public class ticketreservationapp {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(101, "John Doe", "Movie A", "A1", "2023-10-10 12:00");
        system.addTicket(102, "Jane Smith", "Movie B", "B2", "2023-10-10 14:00");
        system.addTicket(103, "Emily Davis", "Movie A", "C3", "2023-10-10 16:00");

        System.out.println("Displaying all tickets:");
        system.displayTickets();

        system.removeTicket(102);

        System.out.println("\nDisplaying all tickets after removal:");
        system.displayTickets();

        System.out.println("\nSearching for tickets by customer name 'John Doe':");
        system.searchTicket("John Doe");

        System.out.println("\nSearching for tickets by movie name 'Movie A':");
        system.searchTicket("Movie A");

        System.out.println("\nTotal booked tickets: " + system.totalBookedTickets());
    }
}
