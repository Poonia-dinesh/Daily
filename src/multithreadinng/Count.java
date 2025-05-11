package multithreadinng;

public class Count extends Thread{

    public int counter = 0;

    public void incremet(){
        synchronized (Count.class){
            counter++;
        }
    }

    public int getCounter(){
        return counter;
    }

}
