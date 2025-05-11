package multithreadinng;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int finalBalance = 200;
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() +" Trying to withdraw amount ....");
        try{
            if(lock.tryLock(3000, TimeUnit.MILLISECONDS)) {
                if (finalBalance >= amount) {
                    try {
                        Thread.sleep(4000);
                        finalBalance = finalBalance - amount;
                        System.out.println(Thread.currentThread().getName() + " Amount Withdrawn");
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println("insufficient balance");
                }
            }
                else{
                System.out.println(Thread.currentThread().getName() + " Can't acquire the lock");
                }
        }catch (Exception e){
            Thread.currentThread().interrupt();
        }
    }
}
