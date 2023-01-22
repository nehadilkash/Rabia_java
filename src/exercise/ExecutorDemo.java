package exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {

    public static void main(String[] args) {
        // Create tasks
        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable print100 = new PrintNum(100);


//        create thread pool with no of threads instead of creting threads manullay
        ExecutorService executorService = Executors.newFixedThreadPool(2);


//        now tasks should be loaded inside pool to run
        executorService.execute(printA);
        executorService.execute(printB);
        executorService.execute(print100);

        executorService.shutdown();

    }
}
