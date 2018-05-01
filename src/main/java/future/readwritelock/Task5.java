package future.readwritelock;

import future.IncrementValue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * by FixedThreadPool(4) with Future with ReadWriteLock
 */

public class Task5 {
    private List<Future<Long>> futuresList = new ArrayList<>();
    private ExecutorService executor = Executors.newFixedThreadPool(4);
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private IncrementValue incrementValue = new IncrementValue();

    public void calc() {
        fillFeatures();
        for (Future<Long> future : futuresList) {
            lock.writeLock().lock();
            try {
                future.get();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                lock.writeLock().unlock();
            }
        }

        System.out.println(incrementValue.getValue());
        executor.shutdown();
    }

    private void fillFeatures() {
        for (int j = 0; j < 1_000_000; j++) {
            futuresList.add(executor.submit(incrementValue));
        }
    }

}
