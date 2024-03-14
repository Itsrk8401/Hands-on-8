public interface LinkedListInterface {
    void insert(int data);
    void remove(int data);
    void display();
}

class Node {
    int data;
    Node next;

    public Node(int val) {
        data = val;
        next = null;
    }
}

public class SinglyLinkedList implements LinkedListInterface {
    private Node head;

    public SinglyLinkedList() {
        head = null;
    }

    @Override
    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    @Override
    public void remove(int data) {
        Node current = head;
        Node prev = null;

        while (current != null && current.data != data) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            if (prev != null) {
                prev.next = current.next;
            } else {
                head = current.next;
            }
        }
    }

    @Override
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
