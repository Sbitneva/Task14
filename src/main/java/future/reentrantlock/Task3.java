package future.reentrantlock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * by FixedThreadPool(4) with Future with ReentrantLock;
 */

public class Task3 {
    public static long primitiveValue = 0;

    public static void calc() {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Lock lock = new ReentrantLock();

        Collection<Callable<Long>> tasks = new ArrayList<>();

        long i;
        for ( i = 0; i < 1_000_000; i++) {
            tasks.add(() -> {
                lock.lock();
                try {
                    primitiveValue = primitiveValue + 1;
                    return primitiveValue;
                } finally {
                    lock.unlock();
                }
            });
        }
        try {

            List<Future<Long>> futureList = executorService.invokeAll(tasks);

            for (Future<Long> future : futureList) {
                Long value = future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        }
        executorService.shutdown();
        System.out.println(primitiveValue);

    }

}
