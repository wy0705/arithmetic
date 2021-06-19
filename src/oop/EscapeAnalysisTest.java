package oop;

public class EscapeAnalysisTest {
    static class User{

    }
    private static void alloc(){
        User user=new User();
    }
    public static void main(String[] args) {
        long a1=System.currentTimeMillis();
        System.out.println();
        for (int i = 0; i < 1000000; i++) {
            alloc();
        }
        //查看执行时间
        long a2=System.currentTimeMillis();
        System.out.println("cost"+(a2-a1)+"ms");
        //为了方便查看堆内存中内存个数，线程sleep
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
/*
可以看到经过分配的存活区与eden比率=2：8
        1）eden区：775M
        2）两个存活区大小：都为127M（存活区=space）
        3）年轻代大小：1G
        4）老年代大小：2G
        5）最大堆内存大小：年轻代大小+老年代大小=3G
        7）java应用程序占用内存大小：最大堆内存大小=3G

        NewRatio = 2 表示年轻代（e+2s）：老年代=1：2，指新生代占整个堆的1/3
        SurvivorRatio = 8 表示2个S：eden=2：8，一个S占年轻代的1/10
        年轻代=eden+2s
*/

