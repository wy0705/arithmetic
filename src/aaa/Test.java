package aaa;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

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
}
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Tools tools=new Tools();

        String targettime="17:22:28";

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        System.out.println(formatter.format(calendar.getTime()));
        String s=formatter.format(calendar.getTime());
        System.out.println(s);
        int[] times=tools.stringtoints(s);
    }
}
