package single;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    private static AtomicInteger n= new AtomicInteger(0);
    public static void main(String[] args) {

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                Single.getInstance(n);
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                Single.getInstance(n);
            }
        });
        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                Single.getInstance(n);
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
