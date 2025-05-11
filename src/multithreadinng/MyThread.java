package multithreadinng;

public class MyThread extends Thread{


    private Count counter;
    public MyThread(String name, Count counter){
        super(name);
        this.counter = counter;
    }

    @Override
    public void run(){
        for (int i =0; i<1000; i++){
            counter.incremet();        }
    }
}
