package ttt;


import java.util.HashMap;

class Shuzi implements Runnable{

    private static int num=1;
    private static char zimu='a';
    @Override
    public void run() {
        while (num<52){
            if (num%2==0) {
                System.out.println(num);
                System.out.println(zimu);
                zimu= (char) (zimu+1);
            }else {
                System.out.println(num);

            }
            num++;
        }

    }
}

class ABC implements Runnable{

    private static char zimu='A';
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            abc();
        }
    }
    private synchronized void abc(){
            System.out.println(zimu);
            zimu= (char) (zimu+1);
            if (zimu=='D'){
                zimu='A';
            }
    }
}

class Sum implements Runnable{

    private static volatile int sum=0;
    private static volatile int num=0;
    @Override
    public void run() {
        while (num<10){
            try {
                // 休眠50秒
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            sum(num);
            num++;
        }
        if (num==10){
            System.out.println(sum);
        }

    }
    private synchronized void sum(int i){

            System.out.println(Thread.currentThread().getName()+"在执行");
            sum=sum+i;
        System.out.println(i);
        System.out.println(sum);
    }
}

public class Test {
    private static int sum=0;
    public static void main(String[] args) throws InterruptedException {


        Sum sum=new Sum();
        Thread thread1=new Thread(sum);
        thread1.setName("111");
        Thread thread2=new Thread(sum);
        thread2.setName("222");
        Thread thread3=new Thread(sum);
        thread3.setName("333");
        thread1.start();
        thread2.start();
        thread3.start();
       /* ABC abc=new ABC();
       Thread thread1=new Thread(abc);
       Thread thread2=new Thread(abc);
       Thread thread3=new Thread(abc);
       thread1.start();
       thread2.start();
       thread3.start();*/
       /* Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    sum=sum+i;
                }
                System.out.println(sum);
                System.out.println("----------------");
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(sum);
                for (int i = 10; i < 20; i++) {
                    sum=sum+i;
                }
                System.out.println(sum);
            }
        });
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        System.out.println(sum);*/
        HashMap hashMap=new HashMap();

    }
}
