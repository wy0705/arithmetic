package single;

import java.util.concurrent.atomic.AtomicInteger;

public class Single{
    private Single(){
    }

    private static Single instance;

    public static Single getInstance(AtomicInteger n){

        while (true){
        if(n.compareAndSet(0,1)){
            if (instance==null) {

                instance = new Single();
                System.out.println("得到Single");
                System.out.println(instance.hashCode());
                n.compareAndSet(1,0);
                return instance;
            }else
                System.out.println(instance.hashCode());
            n.compareAndSet(1,0);
                return instance;
        }

        }
        //return instance;
    }

}
