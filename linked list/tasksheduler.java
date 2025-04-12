
class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;
    TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}


class CircularLinkedList {
    private TaskNode head;
    private TaskNode tail;
    public CircularLinkedList() {
        head = null;
        tail = null;
    }

    
    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            tail = newTask;
            newTask.next = head; 
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head; 
        }
    }
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            tail = newTask;
            newTask.next = head; 
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head; 
        }
    }

    public void addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position <= 1 || head == null) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        TaskNode current = head;

        for (int i = 1; i < position - 1 && current.next != head; i++) {
            current = current.next;
        }

        newTask.next = current.next;
        current.next = newTask;

        if (current == tail) {
            tail = newTask; 
        }
    }

    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode current = head;
        TaskNode previous = null;

        do {
            if (current.taskId == taskId) {
                if (previous != null) {
                    previous.next = current.next;
                } else {
                    head = current.next;
                    tail.next = head; 
                }

                if (current == tail) {
                    tail = previous; 
                }

                System.out.println("Task with ID " + taskId + " has been removed.");
                return;
            }

            previous = current;
            current = current.next;

        } while (current != head); 

        System.out.println("Task with ID " + taskId + " not found.");
    }

    public void viewCurrentTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode current = head;
        System.out.println("Current Task: " + current.taskName + " (Priority: " + current.priority + ")");

        head = current.next;
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode current = head;
        System.out.println("Task List:");

        do {
            System.out.println("Task ID: " + current.taskId + ", Task Name: " + current.taskName +
                    ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head); // Loop back to the head if circular list
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode current = head;
        boolean found = false;
        System.out.println("Tasks with Priority " + priority + ":");

        do {
            if (current.priority == priority) {
                System.out.println("Task ID: " + current.taskId + ", Task Name: " + current.taskName +
                        ", Due Date: " + current.dueDate);
                found = true;
            }
            current = current.next;
        } while (current != head); // Loop back to the head if circular list

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }
}

public class tasksheduler {
    public static void main(String[] args) {
        CircularLinkedList taskList = new CircularLinkedList();
        java.util.Scanner sc = new java.util.Scanner(System.in);

        while (true) {
            System.out.println("\n--- Task Scheduler Menu ---");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by Task ID");
            System.out.println("5. View Current Task");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Task by Priority");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            int taskId, priority;
            String taskName, dueDate;
            int position;

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    taskId = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Task Name: ");
                    taskName = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    priority = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Due Date: ");
                    dueDate = sc.nextLine();
                    taskList.addAtBeginning(taskId, taskName, priority, dueDate);
                    break;

                case 2:
                    System.out.print("Enter Task ID: ");
                    taskId = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Task Name: ");
                    taskName = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    priority = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Due Date: ");
                    dueDate = sc.nextLine();
                    taskList.addAtEnd(taskId, taskName, priority, dueDate);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    position = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Task ID: ");
                    taskId = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Task Name: ");
                    taskName = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    priority = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Due Date: ");
                    dueDate = sc.nextLine();
                    taskList.addAtPosition(position, taskId, taskName, priority, dueDate);
                    break;

                case 4:
                    System.out.print("Enter Task ID to Remove: ");
                    taskId = sc.nextInt();
                    taskList.removeByTaskId(taskId);
                    break;

                case 5:
                    taskList.viewCurrentTask();
                    break;

                case 6:
                    taskList.displayAllTasks();
                    break;

                case 7:
                    System.out.print("Enter Priority to Search: ");
                    priority = sc.nextInt();
                    taskList.searchByPriority(priority);
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
