package aaa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Timer {
    private static ArrayList<Integer> arrayList=new ArrayList<>();
    private static ArrayList<De> arrayList1=new ArrayList<>();
    public void run(){
        for (int i = 0; i < 3; i++) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            arrayList.add(n);
        }

        list();
        addDe();
    }
    //排序
    public void list(){
        Collections.sort(arrayList);
    }
    public void addDe(){
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList1.add(new De(arrayList.get(i),null));
        }
    }

}
