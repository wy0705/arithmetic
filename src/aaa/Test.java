package aaa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        Link link=new Link();
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(3);
        arrayList.add(6);
        arrayList.add(9);
        arrayList.add(4);
        link.init(arrayList);
        link.ergodic();
    }
}
