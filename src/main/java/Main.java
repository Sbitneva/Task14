import classic.threads.Task2;
import future.atomiclong.Task6;
import future.readwritelock.Task5;
import future.reentrantlock.Task4;
import single.code.Task1;
import threads.runnables.Task3;

public class Main {

    public static void main(String... args) {

        System.out.println("single code");
        long startTime = System.nanoTime();
        System.out.println(Task1.calc());
        long endTime = System.nanoTime();
        long time1 = endTime - startTime;
        System.out.println("Execution time: " + time1 + "\n");

        System.out.println("synchronized classic code with 4 threads and extends Thread");
        startTime = System.nanoTime();
        Task2.calc();
        endTime = System.nanoTime();
        long time2 = endTime - startTime;
        System.out.println("Execution time: " + time2 + "\n");

        System.out.println("with 4 threads and implement Runnable");
        Task3 task3 = new Task3();
        startTime = System.nanoTime();
        task3.calc();
        endTime = System.nanoTime();
        long time3 = endTime - startTime;
        System.out.println("Execution time: " + time3 + "\n");


        System.out.println("by FixedThreadPool(4) with Future with ReentrantLock");
        Task4 task4 = new Task4();
        startTime = System.nanoTime();
        task4.calc();
        endTime = System.nanoTime();
        long time4 = endTime - startTime;
        System.out.println("Execution time: " + time4 + "\n");


        System.out.println("by FixedThreadPool(4) with Future with ReadWriteLock");
        Task5 task5 = new Task5();
        startTime = System.nanoTime();
        task5.calc();
        endTime = System.nanoTime();
        long time5 = endTime - startTime;
        System.out.println("Execution time: " + time5 + "\n");


        System.out.println("by FixedThreadPool(4) with Future with AtomicLong");
        Task6 task6 = new Task6();
        startTime = System.nanoTime();
        task6.calc();
        endTime = System.nanoTime();
        long time6 = endTime - startTime;
        System.out.println("Execution time: " + time6 + "\n");


        System.out.println("TOTAL RESULTS");
        System.out.println("single code" + "\t\t\t\t\t\t\t\t" + time1);
        System.out.println("4 threads extends Thread" + "\t\t\t\t" + time2);
        System.out.println("4 threads implement Runnable" + "\t\t\t" + time3);
        System.out.println("FixedThreadPool(4) & ReentrantLock" + "\t\t" + time4);
        System.out.println("FixedThreadPool(4) & ReadWriteLock" + "\t\t" + time5);
        System.out.println("FixedThreadPool(4) & AtomicLong code" + "\t" + time6);
    }
}
