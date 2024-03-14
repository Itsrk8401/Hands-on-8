public interface QueueInterface {
    void enqueue(int data);
    void dequeue();
    int peek();
    boolean isEmpty();
}

public class Queue implements QueueInterface {
    private static final int MAX_SIZE = 100;
    private int[] arr;
    private int front, rear;

    public Queue() {
        arr = new int[MAX_SIZE];
        front = rear = -1;
    }

    @Override
    public void enqueue(int data) {
        if (rear < MAX_SIZE - 1) {
            arr[++rear] = data;
            if (front == -1) {
                front = 0;
            }
        } else {
            System.out.println("Queue Overflow!");
        }
    }

    @Override
    public void dequeue() {
        if (front <= rear) {
            front++;
            if (front > rear) {
                front = rear = -1; // Reset when queue becomes empty
            }
        } else {
            System.out.println("Queue Underflow!");
        }
    }

    @Override
    public int peek() {
        if (front <= rear) {
            return arr[front];
        } else {
            System.out.println("Queue is empty!");
            return -1; // or throw an exception
        }
    }

    @Override
    public boolean isEmpty() {
        return front > rear;
    }
}
