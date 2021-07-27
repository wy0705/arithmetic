package aaa;

public class Node {
    private De time;
    private Node next;

    public Node(De time, Node next) {
        this.time = time;
        this.next = next;
    }

    public De getTime() {
        return time;
    }

    public void setTime(De time) {
        this.time = time;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
