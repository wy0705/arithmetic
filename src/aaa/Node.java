package aaa;

public class Node {
    private int time;
    private Node next;

    public Node(int time, Node next) {
        this.time = time;
        this.next = next;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
