package ccc;

public class MonitorUtil {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();

    public static  void  start(){

        System.out.println("开始调用" +System.currentTimeMillis());

        threadLocal.set(System.currentTimeMillis());

    }
    public static void finish(String methodName){

        System.out.println("调用结束" +System.currentTimeMillis());

        System.out.println(methodName + "方法耗时" + (System.currentTimeMillis() - threadLocal.get()) + "ms");

    }

}
