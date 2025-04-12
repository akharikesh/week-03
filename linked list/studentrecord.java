import java.util.Scanner;

class StudentNode {
    int rollNumber;
    String name;
    int age;
    String grade;
    StudentNode next;

    StudentNode(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private StudentNode head;

    public void addAtBeginning(int roll, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    public void addAtEnd(int roll, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        StudentNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void addAtPosition(int pos, int roll, String name, int age, String grade) {
        if (pos <= 1 || head == null) {
            addAtBeginning(roll, name, age, grade);
            return;
        }

        StudentNode newNode = new StudentNode(roll, name, age, grade);
        StudentNode current = head;
        for (int i = 1; i < pos - 1 && current.next != null; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void deleteByRollNumber(int roll) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == roll) {
            head = head.next;
            System.out.println("Student with roll number " + roll + " deleted.");
            return;
        }

        StudentNode current = head;
        while (current.next != null && current.next.rollNumber != roll) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Roll Number not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Student with roll number " + roll + " deleted.");
        }
    }

    public void searchByRollNumber(int roll) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNumber == roll) {
                System.out.println("Student Found: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
                return;
            }
            current = current.next;
        }
        System.out.println("Student with Roll Number " + roll + " not found.");
    }

    public void updateGrade(int roll, String newGrade) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNumber == roll) {
                current.grade = newGrade;
                System.out.println("Grade updated for Roll Number " + roll);
                return;
            }
            current = current.next;
        }
        System.out.println("Student with Roll Number " + roll + " not found.");
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No student records.");
            return;
        }
        StudentNode current = head;
        System.out.println("Student Records:");
        while (current != null) {
            System.out.println("Roll: " + current.rollNumber + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }
}

public class studentrecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();

        while (true) {
            System.out.println("\n--- Student Record Menu ---");
            System.out.println("1. Add Student at Beginning");
            System.out.println("2. Add Student at End");
            System.out.println("3. Add Student at Position");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Search Student by Roll Number");
            System.out.println("6. Update Grade by Roll Number");
            System.out.println("7. Display All Students");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            int roll, age, pos;
            String name, grade;

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number: ");
                    roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Grade: ");
                    grade = sc.nextLine();
                    list.addAtBeginning(roll, name, age, grade);
                    break;

                case 2:
                    System.out.print("Enter Roll Number: ");
                    roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Grade: ");
                    grade = sc.nextLine();
                    list.addAtEnd(roll, name, age, grade);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Roll Number: ");
                    roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Grade: ");
                    grade = sc.nextLine();
                    list.addAtPosition(pos, roll, name, age, grade);
                    break;

                case 4:
                    System.out.print("Enter Roll Number to Delete: ");
                    roll = sc.nextInt();
                    list.deleteByRollNumber(roll);
                    break;

                case 5:
                    System.out.print("Enter Roll Number to Search: ");
                    roll = sc.nextInt();
                    list.searchByRollNumber(roll);
                    break;

                case 6:
                    System.out.print("Enter Roll Number to Update Grade: ");
                    roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Grade: ");
                    grade = sc.nextLine();
                    list.updateGrade(roll, grade);
                    break;

                case 7:
                    list.displayAll();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
