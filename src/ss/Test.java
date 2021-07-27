package ss;

import java.util.concurrent.locks.ReentrantLock;

public class Test {
    private static int a=0;
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock=new ReentrantLock();
        lock.lock();
        //dasfsdfads
        lock.unlock();
        Mcs mcs=new Mcs();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1111");
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2222");
            }
        });
        mcs.init(thread1);
        mcs.addt(thread2);
        thread1.start();
        thread2.start();

        mcs.runt();
       /* Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    a++;
                }
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    a++;
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread1.join();
        System.out.println(a);*/
        /*Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1111");
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2222");
            }
        });
        ReentrantLock lock=new ReentrantLock();
        lock.lock();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        //dasfsdfads
        lock.unlock();*/
    }
}
