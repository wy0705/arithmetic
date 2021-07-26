package aaa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Link {
    private static Node head;
    private static Node tail;
    private static int size=0;

    //构造链表
    public void init(ArrayList<Integer> arrayList){
        if (arrayList==null){
            System.out.println("链表为空");
            return;
        }
        Collections.sort(arrayList);
        /*for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }*/
        Node node=new Node(arrayList.get(0),null);
        size++;
        head=node;
        tail=node;
        if (arrayList.size()>1){
            for (int i = 1; i < arrayList.size(); i++) {
                //System.out.println(arrayList.get(i));
                add(arrayList.get(i));
            }
        }
    }

    public void add(int time){
        Node node=new Node(time,null);
        size++;
        head.setNext(node);
        tail=node;
    }

    public void ergodic() throws InterruptedException {
        System.out.println("1111");
        if (head!=null) {
            while (true) {
                System.out.println(head.getTime());
                if (head.getNext() != null) {
                    head = head.getNext();
                } else {
                    break;
                }
            }
        }
        CountDownLatch latch = new CountDownLatch(size);
        if (head!=null){
            while (true){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + " 运行");
                        System.out.println(head.getTime()+"时间到！");
                        try {
                            Thread.sleep(1000*head.getTime());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            latch.countDown();
                        }
                    }
                }).start();
                if (head.getNext()!=null){
                    head=head.getNext();
                }else {
                    break;
                }
            }
            System.out.println("计时器已经启动");
            latch.await(10, TimeUnit.SECONDS);
            System.out.println("子线程运行结束");

        }
    }
}
