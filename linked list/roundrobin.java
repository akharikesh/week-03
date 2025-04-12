class ProcessNode {
    int processId;
    int burstTime;
    int priority;
    ProcessNode next;

    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private ProcessNode head;
    private ProcessNode tail;
    private int totalProcesses;
    private int totalWaitingTime;
    private int totalTurnaroundTime;

    public RoundRobinScheduler() {
        head = null;
        tail = null;
        totalProcesses = 0;
        totalWaitingTime = 0;
        totalTurnaroundTime = 0;
    }

    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode newProcess = new ProcessNode(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            tail = newProcess;
            newProcess.next = head; 
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head; 
        }
        totalProcesses++;
    }

    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes to remove.");
            return;
        }

        ProcessNode current = head;
        ProcessNode prev = null;
        do {
            if (current.processId == processId) {
                if (prev == null) { 
                    head = current.next;
                    tail.next = head; 
                } else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev; 
                    }
                }
                totalProcesses--;
                System.out.println("Process " + processId + " has been removed.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        System.out.println("Process with ID " + processId + " not found.");
    }

    
    public void roundRobinScheduling(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        ProcessNode current = head;
        int totalBurstTime = 0;

        ProcessNode temp = head;
        do {
            totalBurstTime += temp.burstTime;
            temp = temp.next;
        } while (temp != head);

        while (totalProcesses > 0) {
            if (current.burstTime > 0) {
                int execTime = Math.min(current.burstTime, timeQuantum);
                current.burstTime -= execTime;
                totalTurnaroundTime += execTime;

                if (current.burstTime == 0) {
                    removeProcess(current.processId);
                    current = current.next;
                    continue;
                }
            }
            current = current.next;
            displayQueue();
        }
        calculateAverageTimes(totalBurstTime);
    }

    public void displayQueue() {
        if (head == null) {
            System.out.println("No processes to display.");
            return;
        }

        ProcessNode current = head;
        System.out.println("Current Queue of Processes:");
        do {
            System.out.println("Process ID: " + current.processId + ", Burst Time: " + current.burstTime + ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }

    private void calculateAverageTimes(int totalBurstTime) {
        int averageWaitingTime = (totalTurnaroundTime - totalBurstTime) / totalProcesses;
        int averageTurnaroundTime = totalTurnaroundTime / totalProcesses;

        System.out.println("\nAverage Waiting Time: " + averageWaitingTime);
        System.out.println("Average Turnaround Time: " + averageTurnaroundTime);
    }
}

public class roundrobin {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        scheduler.addProcess(1, 5, 3);
        scheduler.addProcess(2, 8, 2);
        scheduler.addProcess(3, 3, 1);
        scheduler.addProcess(4, 6, 4);

        scheduler.displayQueue();

        int timeQuantum = 2;
        System.out.println("\nSimulating Round-Robin Scheduling with Time Quantum = " + timeQuantum);
        scheduler.roundRobinScheduling(timeQuantum);
    }
}
