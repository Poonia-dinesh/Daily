package multithreadinng;

public class Simple {

    public static void main(String[] args){
        T1 t = new T1();
        t.start();
        for (;;)
            System.out.println("Running main thread" + Thread.currentThread().getName());
    }
}
