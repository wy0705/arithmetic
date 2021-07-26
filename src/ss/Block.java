package ss;

public class Block {
    private int head=0;  //0无头 1有头
    private int state=0;
    private Thread thread;
    private Block next;
    private int tail=0;  //0有尾  1无尾



    public Block(int head, int state, Thread thread, Block next, int tail) {
        this.head = head;
        this.state = state;
        this.thread=thread;
        this.next = next;
        this.tail = tail;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public Block getNext() {
        return next;
    }

    public void setNext(Block next) {
        this.next = next;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public void runt(){
        if (this.state==0) {
            this.thread.start();
            if (this.next!=null)
               this.next.state=0;
        }else {
            System.out.println("当前状态为1,不可执行！");
        }
    }
}
