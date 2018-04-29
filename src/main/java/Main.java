import classic.threads.Task2;
import future.readwritelock.Task4;
import future.reentrantlock.Task3;
import single.code.Task1;

public class Main {

    public static void main(String...args) {
        System.out.println("single code");
        long startTime = System.nanoTime();
        System.out.println(Task1.calc() + "\n");
        long endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + "\n");

        System.out.println("synchronized classic code with 4 threads and extends Thread");
        startTime = System.nanoTime();
        Task2.calc();
        endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + "\n");

        System.out.println("by FixedThreadPool(4) with Future with ReentrantLock;");
        startTime = System.nanoTime();
        Task3.calc();
        endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + "\n");


        System.out.println("by FixedThreadPool(4) with Future with ReadWriteLock");
        startTime = System.nanoTime();
        Task4.calc();
        endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + "\n");
    }
}
