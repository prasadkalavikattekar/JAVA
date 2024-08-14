import java.util.Scanner;

interface Stack {
    void push(int ele);
    void pop();
    void display();
}

interface Queue {
    void enqueue(int ele);
    void dequeue();
    void display();
}

class QueueNStack implements Stack, Queue {
    int size;
    int top;
    int front;
    int rear;
    int arr[];

    QueueNStack(int s) {
        size = s;
        arr = new int[size];
        top = -1;
        front = 0;
        rear = 0;
    }

    // Stack methods
    public void push(int ele) {
        if (top >= size - 1) {
            System.out.println("=== Stack is full ===");
        } else {
            arr[++top] = ele;
            System.out.println("=== Element " + ele + " pushed to stack ===");
        }
    }

    public void pop() {
        if (top < 0) {
            System.out.println("=== Stack is empty ===");
        } else {
            System.out.println("=== Element " + arr[top--] + " popped from stack ===");
        }
    }

    public void display() {
        if (top < 0) {
            System.out.println("=== Stack is empty ===");
            return;
        }
        System.out.println("Current Stack:");
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    // Queue methods
    public void enqueue(int ele) {
        if (rear >= size) {
            System.out.println("=== Queue is full ===");
        } else {
            arr[rear++] = ele;
            System.out.println("=== Element " + ele + " enqueued to queue ===");
        }
    }

    public void dequeue() {
        if (front >= rear) {
            System.out.println("=== Queue is empty ===");
        } else {
            System.out.println("=== Element " + arr[front++] + " dequeued from queue ===");
        }
    }

    public void displayQueue() {
        if (front >= rear) {
            System.out.println("=== Queue is empty ===");
            return;
        }
        System.out.println("Current Queue:");
        for (int i = front; i < rear; i++) {
            System.out.println(arr[i]);
        }
    }
}

public class InterfaceStackNQueue {
    public static void main(String[] args) {
        int element;
        int size;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Size: ");
        size = sc.nextInt();
        QueueNStack qns = new QueueNStack(size);

        int choice;
        do {
            System.out.println("Enter your Choice: \n" + "1.Stack\n" + "2.Queue\n" + "3.Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    int stackChoice;
                    do {
                        System.out.println("\nStack Operations\n" + "1.Push\n" + "2.Pop\n" + "3.Display\n" + "4.Exit");
                        stackChoice = sc.nextInt();
                        switch (stackChoice) {
                            case 1:
                                System.out.println("Enter the element to push:");
                                element = sc.nextInt();
                                qns.push(element);
                                break;
                            case 2:
                                qns.pop();
                                break;
                            case 3:
                                qns.display();
                                break;
                            case 4:
                                System.out.println("Exiting Stack Operations");
                                break;
                            default:
                                System.out.println("Invalid choice");
                        }
                    } while (stackChoice != 4);
                    break;

                case 2:
                    int queueChoice;
                    do {
                        System.out.println("Queue Operations\n" + "1.Enqueue\n" + "2.Dequeue\n" + "3.Display\n" + "4.Exit");
                        queueChoice = sc.nextInt();
                        switch (queueChoice) {
                            case 1:
                                System.out.println("Enter the element to Enqueue:");
                                element = sc.nextInt();
                                qns.enqueue(element);
                                break;
                            case 2:
                                qns.dequeue();
                                break;
                            case 3:
                                qns.displayQueue();
                                break;
                            case 4:
                                System.out.println("Exiting Queue Operations");
                                break;
                            default:
                                System.out.println("Invalid choice");
                        }
                    } while (queueChoice != 4);
                    break;

                case 3:
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 3);

        sc.close();
    }
}
