package threadFile;

import java.io.*;

class Work implements Runnable {

    private String string = "我爱中国!";
    private char[] data = string.toCharArray();
    private int size=data.length;
    private int index=0;
    public synchronized void mywrite() throws IOException {

        System.out.println("Working...");
        File file = new File("src/write.txt");    //1、建立连接
        OutputStream os = null;
        try {
            //2、选择输出流,以追加形式(在原有内容上追加) 写出文件 必须为true 否则为覆盖
            os = new FileOutputStream(file,true);
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os,"UTF-8")));
//            //和上一句功能一样，BufferedInputStream是增强流，加上之后能提高输出效率，建议
//            os = new BufferedOutputStream(new FileOutputStream(file,true));


            if (data[index]!=' ')
               out.write(data,index,index+1);
            System.out.println(data[index]);
            //os.write(data, index, index+1);
            //index++;
            os.flush();    //将存储在管道中的数据强制刷新出去
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件没有找到！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("写入文件失败！");
        }finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭输出流失败！");
                }
            }
        }
    }
    @Override
    public void run() {
        while (index<=size){
            try {
                // 休眠50秒
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                mywrite();
                index++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadFile {
    public static void main(String[] args) {
        Work work=new Work();
        Thread thread1=new Thread(work);
        Thread thread2=new Thread(work);
        thread1.start();
        thread2.start();
    }


}
