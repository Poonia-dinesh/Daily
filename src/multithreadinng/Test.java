package multithreadinng;

public class Test {

    public static void main(String[] args){
        Count count = new Count();
        MyThread t1 = new MyThread("Count1", count);
        MyThread t2 = new MyThread("Count2",count);
        t1.start();
        t2.start();
        System.out.println(t1.getName());
        System.out.println(t2.getName());

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(count.getCounter());

    }
}
