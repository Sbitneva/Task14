import classic.threads.Task2;
import threads.runnables.Task3;
import future.readwritelock.Task5;
import future.reentrantlock.Task4;
import single.code.Task1;

public class Main {

    public static void main(String...args) {

        System.out.println("single code");
        long startTime = System.nanoTime();
        System.out.println(Task1.calc());
        long endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + "\n");

        System.out.println("synchronized classic code with 4 threads and extends Thread");
        startTime = System.nanoTime();
        Task2.calc();
        endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + "\n");

        System.out.println("with 4 threads and implement Runnable");
        Task3 task3 = new Task3();
        startTime = System.nanoTime();
        task3.calc();
        endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + "\n");


        System.out.println("by FixedThreadPool(4) with Future with ReentrantLock");
        Task4 task4 = new Task4();
        startTime = System.nanoTime();
        task4.calc();
        endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + "\n");

        /*
        System.out.println("by FixedThreadPool(4) with Future with ReadWriteLock");
        startTime = System.nanoTime();
        Task5.calc();
        endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + "\n");
        */

    }
}
