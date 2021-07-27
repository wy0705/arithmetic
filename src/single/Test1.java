package single;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


/*class Task{
    long time=0;
    public Task(long time) {
        this.time=time;
    }

    public void run() {
        System.out.println("task begin -- waittime"+time );
    }
}*/
class Tools{
    public int[] stringtoints(String s){
        String[] spilt=s.split(":");
        int[] times=new int[3];
        for (int i = 0; i < spilt.length; i++) {
            times[i]=Integer.valueOf(spilt[i]);
            //System.out.println(times[i]);
        }
        return times;
    }
    public int aaa(String targettime){
        //String targettime="17:22:28";

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        System.out.println(formatter.format(calendar.getTime()));
        String s=formatter.format(calendar.getTime());
        System.out.println(s);
        int[] times=stringtoints(s);

        int[] mytimes=stringtoints(targettime);
        for (int i = 0; i < times.length; i++) {
            if (times[i]>mytimes[i]){
                System.out.println("时间已经过了，不能定时！");
                return -1;
            }
        }
        int time=(times[0]-mytimes[0])*60*60+(times[1]-mytimes[1])*60+times[2]-mytimes[2];
        return time;
    }
}
class Time{
    private Tools tools=new Tools();
    private String times;
    private int time;
    public Time(String times){
        this.times=times;
        time=tools.aaa(times);

    }
    public void run(){
        System.out.println();
    }
}


public class Test1{
    static CopyOnWriteArrayList<Task> arr=new CopyOnWriteArrayList<Task>();
    static CountDownLatch latch=new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        final Scanner sc=new Scanner(System.in);

        new Thread(new Runnable() {//开启一条子线程添加任务

            @Override
            public void run() {

                for(;;) {
                    int time=sc.nextInt();
                    add(new Task(System.currentTimeMillis()+time*1000));
                }

            }
        }).start();


        for(;;) {
            for(int i=0;i<arr.size();  ) {

                Task task=arr.get(i);
                latch.await((task.time-System.currentTimeMillis())/1000, TimeUnit.SECONDS);//设置阻塞时间
                if(!task.equals(arr.get(i))) {//如果集合的第一个线程发生变化，则重新计算
                    break;
                }
                task.run();
                arr.remove(task);//从集合中删除结束的线程
            }
        }

    }
    static void add(Task t) {//根据阻塞时间添加进程

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

    public int[] stringtoints(String s){
        String[] spilt=s.split(":");
        int[] times=new int[3];
        for (int i = 0; i < spilt.length; i++) {
            times[i]=Integer.valueOf(spilt[i]);
            //System.out.println(times[i]);
        }
        return times;
    }
}
