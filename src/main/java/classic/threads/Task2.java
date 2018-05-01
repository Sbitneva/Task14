package classic.threads;

/**
 * synchronized classic code with 4 threads and extends Thread;
 */

class SharedLong {
    private static final Object sync = new Object();
    public static long value = 0;

    public static void increment() {
        synchronized (sync) {
            SharedLong.value++;
        }
    }
}

class IncThread extends Thread {
    @Override
    public void run() {
        //System.out.println(this.getName() + " execution started");
        SharedLong.increment();
        //System.out.println("value = " + SharedLong.value);
        //System.out.println(this.getName() + " execution ended");
    }

}

public class Task2 {
    public static void calc() {
        IncThread[] incThreads = new IncThread[4];
        for (int i = 0; i < 4; i++) {
            incThreads[i] = new IncThread();
            incThreads[i].setName("Thread " + (i + 1));
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
