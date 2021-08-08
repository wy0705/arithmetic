package eee;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Myrun implements Runnable{
    private Socket s=null;
    public Myrun(Socket s){
        this.s=s;
    }
    @Override
    public void run() {
        try {
            InputStream in = s.getInputStream();
            byte[] b = new byte[1024];
            int len = in.read(b);//block
            String str=new String(b);
            System.out.println(str);
            OutputStream out = s.getOutputStream();
            out.write(("hello"+str+"\n").getBytes(StandardCharsets.UTF_8));
            out.flush();
            s.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
public class Test {
    public static void main(String[] args) throws Exception {
        ServerSocket ss=new ServerSocket(9000,10);
        ExecutorService pool1 = Executors.newCachedThreadPool();
        while(true) {
            System.out.println("waiting");
            Socket s = ss.accept();
            System.out.println("收到");
            pool1.submit(new Myrun(s));
        }
    }
}
