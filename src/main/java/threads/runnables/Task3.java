package threads.runnables;

/**
 * with 4 threads and implement Runnable;
 */

class SharedLong {

    private static final Object sync = new Object();
    public static long value = 0;

    public static void increment() {
        synchronized (sync) {
            value++;
        }
    }
}

class IncRunnable implements Runnable {

    public void run() {
        SharedLong.increment();
    }
}

public class Task3 {

    public void calc() {

        Thread[] incThreads = new Thread[4];
        for (int i = 0; i < 4; i++) {
            incThreads[i] = new Thread(new IncRunnable());
        }
        try {
            while (SharedLong.value < 1_000_000) {
                for (int i = 0; i < 4; i++) {
                    incThreads[i].run();
                }
            }
            for (int i = 0; i < 4; i++) {
                incThreads[i].join();
            }


        } catch (Exception e) {
            System.out.println(e.getClass() + " : " + e.getMessage());
        }

        System.out.println(SharedLong.value);

    }
}
