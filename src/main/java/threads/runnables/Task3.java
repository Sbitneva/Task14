package threads.runnables;

/**
 * with 4 threads and implement Runnable;
 */

class SharedLong{

    public static long value = 0;
    private static final Object sync = new Object();
    public static void increment(){
        synchronized (sync) {
            value++;
        }
    }
}

class IncRunnable implements Runnable {
    IncRunnable(){
        new Thread(this).start();
    }
    public void run(){
        SharedLong.increment();
    }
}

public class Task3 {

    public void calc() {

        IncRunnable[] incThreads = new IncRunnable[4];
        for(int i = 0 ; i < 4; i++){
            incThreads[i] = new IncRunnable();
        }
        try {
            while (SharedLong.value < 1_000_000){
                for (int i = 0; i < 4; i++) {
                    incThreads[i].run();
                }
            }

        } catch (Exception e) {
            System.out.println(e.getClass() + " : " + e.getMessage());
        }

        System.out.println(SharedLong.value);

    }
}
