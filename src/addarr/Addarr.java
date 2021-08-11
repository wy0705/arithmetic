package addarr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Addarr {
    private ArrayList<Integer> a=new ArrayList<>();
    private ArrayList<Integer> b=new ArrayList<>();
    private ArrayList<Integer> t=new ArrayList<>();

    public void addarr(){
        Scanner scanner=new Scanner(System.in);
        String sa=scanner.next();
        String sb=scanner.next();
        a=stringtoarr(sa);
        b=stringtoarr(sb);
        sum(a,b);
        if (t!=null){
            System.out.println(t);
        }
    }

    public ArrayList<Integer> stringtoarr(String s){
        ArrayList<Integer> arrayList=new ArrayList<>();
        String[] arr=s.split(",");
        for (int i = 0; i < arr.length; i++) {
            arrayList.add(Integer.parseInt(arr[i]));
        }
        return arrayList;
    }

    public void sum(ArrayList<Integer> a,ArrayList<Integer> b){
        for (int i:a) {
            t.add(i);
        }
        for (int i:b) {
            t.add(i);
        }
        Collections.sort(t);
    }
}
