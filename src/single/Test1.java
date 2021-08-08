package single;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;



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
        /*for (int i = 0; i < times.length; i++) {
            if (times[i]>mytimes[i]){
                System.out.println("时间已经过了，不能定时！");
                return -1;
            }
        }*/
        int time=(mytimes[0]-times[0])*60*60+(mytimes[1]-times[1])*60+mytimes[2]-times[2];
        System.out.println(time);
        return time;
    }
}
class Task{
    private Tools tools=new Tools();
    private String times;
    private int time;
    public Task(String times){
        this.times=times;
        time=tools.aaa(times);

    }
    public void run(){
        System.out.println(times+"到时间了");
    }

    public Tools getTools() {
        return tools;
    }

    public void setTools(Tools tools) {
        this.tools = tools;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
class Time{
    private static CopyOnWriteArrayList<Task> arr=new CopyOnWriteArrayList<Task>();
    private static CountDownLatch latch=new CountDownLatch(1);

    public void timging() throws InterruptedException {
        Tools tools=new Tools();
        final Scanner sc=new Scanner(System.in);

        new Thread(new Runnable() {//开启一条子线程添加任务

            @Override
            public void run() {

                for(;;) {
                    String time=sc.next();
                    add(new Task(time));
                }

            }
        }).start();


        for(;;) {
            for(int i=0;i<arr.size();  ) {

                Task task=arr.get(i);
                //latch.await((task.getTime()-System.currentTimeMillis())/1000, TimeUnit.SECONDS);//设置阻塞时间
                latch.await(tools.aaa(task.getTimes()), TimeUnit.SECONDS);
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
                if(t.getTime()<arr.get(i).getTime()) {
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


public class Test1{


    public static void main(String[] args) throws Exception {

        Time time=new Time();
        time.timging();

    }



}
