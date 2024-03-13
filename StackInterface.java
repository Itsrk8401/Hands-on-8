public interface StackInterface {
    void push(int data);
    void pop();
    int peek();
    boolean isEmpty();
}

public class Stack implements StackInterface {
    private static final int MAX_SIZE = 100;
    private int[] arr;
    private int top;

    public Stack() {
        arr = new int[MAX_SIZE];
        top = -1;
    }

    @Override
    public void push(int data) {
        if (top < MAX_SIZE - 1) {
            arr[++top] = data;
        } else {
            System.out.println("Stack Overflow!");
        }
    }

    @Override
    public void pop() {
        if (top >= 0) {
            top--;
        } else {
            System.out.println("Stack Underflow!");
        }
    }

    @Override
    public int peek() {
        if (top >= 0) {
            return arr[top];
        } else {
            System.out.println("Stack is empty!");
            return -1; // or throw an exception
        }
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }
}
