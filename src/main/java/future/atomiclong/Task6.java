package future.atomiclong;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * by FixedThreadPool(4) with Future with AtomicLong
 */

class IncAtomic implements Callable<AtomicLong> {
    private AtomicLong value = new AtomicLong(0);

    public AtomicLong call() {
        value.incrementAndGet();
        return value;
    }

    public AtomicLong getValue() {
        return value;
    }
}

public class Task6 {
    private List<Future<AtomicLong>> futuresList = new ArrayList<>();
    private ExecutorService executorService = Executors.newFixedThreadPool(4);
    private IncAtomic incAtomic = new IncAtomic();

    public void calc() {
        fillFeatures();
        for (int i = 0; i < 1_000_000; i++) {
            try {
                futuresList.get(i).get();
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e.getClass() + " : " + e.getMessage());
            }
        }

        System.out.println(incAtomic.getValue());
        executorService.shutdown();
    }

    private void fillFeatures() {
        for (int i = 0; i < 1_000_000; i++) {
            futuresList.add(executorService.submit(incAtomic));
        }
    }

}
