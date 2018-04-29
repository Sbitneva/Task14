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

public class Task4 {
    public static long primitiveValue = 0;

    public static void calc(){
        ExecutorService executor = Executors.newFixedThreadPool(4);
        ReadWriteLock lock = new ReentrantReadWriteLock();

        long i;
        for ( i = 0; i < 1_000_000; i++) {
            executor.submit(() -> {
                lock.writeLock().lock();
                try {
                    primitiveValue = primitiveValue + 1;
                    TimeUnit.MILLISECONDS.sleep(5);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                } finally {
                    lock.writeLock().unlock();
                }
            });
        }




        System.out.println(primitiveValue);

        executor.shutdown();
    }
}
