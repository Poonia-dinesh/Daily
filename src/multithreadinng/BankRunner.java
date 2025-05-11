package multithreadinng;

public class BankRunner {

    public static void main(String[] args){
        BankAccount ba = new BankAccount();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                ba.withdraw(100);
            }
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        t1.start();
        t2.start();
    }
}
