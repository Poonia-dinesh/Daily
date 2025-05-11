package multithreadinng;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {
    private int count =0;
    private final ReadWriteLock readwriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readwriteLock.readLock();
    private final Lock writeLock = readwriteLock.writeLock();

    public void increment () {
        writeLock.lock();
        try{
            count++;
            Thread.sleep(50);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        finally {
            writeLock.unlock();
        }
    }

    public int getCount() {
        readLock.lock();
        try{
        return count;
    } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args ) throws InterruptedException {
        ReadWriteCounter readWriteCounter = new ReadWriteCounter();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for(int i =0; i<5; i++){
                    System.out.println(Thread.currentThread().getName() + " read count : " + readWriteCounter.getCount());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for(int i =0; i<5 ; i++){
                    readWriteCounter.increment();
                    System.out.println(Thread.currentThread().getName() + "incremented");
                }
            }
        };

        Thread wt = new Thread(writeTask, "WriterThred");
        Thread rt1 = new Thread(readTask, "ReaderThread 1");
        Thread rt2 = new Thread(readTask, "ReaderThread 2");

        wt.start();
        rt1.start();
        rt2.start();

        wt.join();
        rt1.join();
        rt2.join();

        System.out.println("Final counter :"  + readWriteCounter.getCount());
    }

}
