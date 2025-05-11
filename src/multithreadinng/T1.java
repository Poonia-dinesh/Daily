package multithreadinng;

public class T1 extends Thread{

    @Override
    public void run(){
        for(;;)
        System.out.println("Running thred t1" + Thread.currentThread().getName());
    }
}
