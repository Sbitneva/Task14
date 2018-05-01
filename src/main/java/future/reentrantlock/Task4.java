package future.reentrantlock;

import future.IncrementValue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * by FixedThreadPool(4) with Future with ReentrantLock;
 */

public class Task4 {

    private List<Future<Long>> futuresList = new ArrayList<>();
    private ExecutorService executorService = Executors.newFixedThreadPool(4);
    private Lock reentrantLock = new ReentrantLock();
    private IncrementValue incrementValue = new IncrementValue();

    public void calc() {
        fillFeatures();
        int futureIndex;

        for (Future<Long> future : futuresList) {
            try {
                if (reentrantLock.tryLock()) {
                    reentrantLock.lock();
                    future.get();
                }
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e.getClass() + " : " + e.getMessage());
            } finally {
                reentrantLock.unlock();
            }
        }

        System.out.println("value: " + incrementValue.getValue());
        executorService.shutdown();
    }

    private void fillFeatures() {
        for (int i = 0; i < 1_000_000; i++) {
            futuresList.add(executorService.submit(incrementValue));
        }
    }
}

