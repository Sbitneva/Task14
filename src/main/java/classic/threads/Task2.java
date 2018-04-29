package classic.threads;

import single.code.Task1;

/**
 * synchronized classic code with 4 threads and extends Thread;
 */

class IncThread extends Thread {
    @Override
    public void run() {
        Task2.printNumbers();
        super.run();
    }

}

public class Task2 {

    static public synchronized void printNumbers() {
        long i;
        for(i = 0; i < 1_000_000; i++);
        System.out.println(i);
    }

    public static void calc(){
        try {
            IncThread[] incThreads = new IncThread[4];
            for(int i = 0; i < 4; i++){
                incThreads[i] = new IncThread();
                incThreads[i].setName("Thread" + i);
                incThreads[i].start();
            }
            for(int i = 0; i < 4; i++) {
                incThreads[i].join();
            }

        } catch (Exception e) {
            System.out.println(e.getClass() + " : " + e.getMessage());
        }

    }
}
