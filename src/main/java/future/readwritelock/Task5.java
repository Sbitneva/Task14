package future.readwritelock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * by FixedThreadPool(4) with Future with ReadWriteLock
 */

public class Task5 {
    /*

    public static void calc(){
        ExecutorService executor = Executors.newFixedThreadPool(4);
        ReadWriteLock lock = new ReentrantReadWriteLock();
        int i;
        for(i = 0; i < 1_000_000; i++) {
            executor.submit(() -> {
                lock.writeLock().lock();
                try {
                    primitiveValue = primitiveValue + 1;
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                } finally{
                    lock.writeLock().unlock();
                }
                //System.out.println(primitiveValue);
            });

        }
            /*Runnable readTask = () -> {
                lock.readLock();
                try {
                    //System.out.println(primitiveValue);
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                } finally {
                    lock.readLock().unlock();
                }
            };

            executor.submit(readTask);
            executor.submit(readTask);
            executor.submit(readTask);
            executor.submit(readTask);



        System.out.println(primitiveValue);

        executor.shutdown();
        */

}
