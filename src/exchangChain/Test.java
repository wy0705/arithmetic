package exchangChain;

public class Test {
    public static void main(String[] args) {
        Link link=new Link();
        link.add(1);
        link.add(2);
        link.add(3);
        link.add(4);
        link.add(5);
        link.add(6);
        //link.ergodic();
        link.pair();
        link.ergodic();
    }
}
