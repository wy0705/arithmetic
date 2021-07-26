package ss;

public class Mcs {
    private static int head=1;
    private static int tail=1;
    private Block headb;
    private Block tailb;

    //初始化
    public void init(Thread thread){
        Block block=new Block(1,0,thread,null,1);
        headb=block;
        tailb=block;
    }

    //新进线程 添加block
    public void addt(Thread thread){
        Block block=new Block(0,1,thread,null,1);
        tailb.setTail(0);
        tailb.setNext(block);
        tailb=block;
    }

    //线程执行
    public void runt(){
        headb.runt();
        if (headb.getNext()==null){
            System.out.println("已经是最后一个节点");
            return;
        }
        headb=headb.getNext();
        if (headb!=null){
            runt();
        }
        System.out.println("结束！");
    }

    //

}
