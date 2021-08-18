package exchangChain;

import java.util.ArrayList;

public class Link {
    private LinkNode head=new LinkNode();
    private LinkNode tail=head;

    public void init(int value){
        LinkNode linkNode=new LinkNode(value);
        head.setNext(linkNode);
        tail=linkNode;
    }

    public void add(int value){
        if (head==null){
            init(value);
            return;
        }else{
            LinkNode linkNode=new LinkNode(value);
            tail.setNext(linkNode);
            tail=linkNode;
        }
    }
//遍历
    public void ergodic(){
        LinkNode temp=head.getNext();
        while (temp!=null){
            System.out.println(temp.getValue());
            if (temp.getNext()!=null) {
                temp = temp.getNext();
            }else {
                return;
            }
        }
    }
    //交换
    public void exchang(LinkNode preNode,LinkNode node1,LinkNode node2){
        LinkNode temp=node1.getNext();
        node1.setNext(temp.getNext());
        temp.setNext(preNode.getNext());
        preNode.setNext(temp);
    }
    //两两交换
    public void pair(){
        LinkNode temp=head;
        while (temp.getNext()!=null&&temp.getNext().getNext()!=null) {
            exchang(temp, temp.getNext(),temp.getNext().getNext());
            temp=temp.getNext().getNext();

        }
    }



}
