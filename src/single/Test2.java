package single;


import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


class Tool{
    long time=0;
    public Tool(long time) {
        this.time=time;
    }

    public void run() {
        System.out.println("task begin -- waittime"+time );
    }
}

class Timer{
    static CopyOnWriteArrayList<Tool> arr=new CopyOnWriteArrayList<Tool>();
    static CountDownLatch latch=new CountDownLatch(1);
    public void timing() throws InterruptedException {
        final Scanner sc=new Scanner(System.in);

        new Thread(new Runnable() {//开启一条子线程添加任务

            @Override
            public void run() {

                for(;;) {
                    int time=sc.nextInt();
                    add(new Tool(System.currentTimeMillis()+time*1000));
                }

            }
        }).start();


        for(;;) {
            for(int i=0;i<arr.size();  ) {

                Tool task=arr.get(i);
                latch.await((task.time-System.currentTimeMillis())/1000, TimeUnit.SECONDS);//设置阻塞时间
                if(!task.equals(arr.get(i))) {//如果集合的第一个线程发生变化，则重新计算
                    break;
                }
                task.run();
                arr.remove(task);//从集合中删除结束的线程
            }
        }
    }
    static void add(Tool t) {//根据阻塞时间添加进程

        if(arr.size()==0) {
            arr.add(t);
        }
        else {
            for (int i = 0; i < arr.size(); i++) {
                if(t.time<arr.get(i).time) {
                    arr.add(i, t);
                    if(arr.get(0).equals(t)) {//如果进程添加到了集合首位，则countdown，主线程停止阻塞，重新开始计算时间
                        latch.countDown();
                    }
                    latch=new CountDownLatch(1);
                    return;
                }
            }
            arr.add(t);
        }


    }
}
public class Test2{
    public static void main(String[] args) throws Exception {
       Timer timer=new Timer();
       timer.timing();
    }

}
