package exercise;

public class TaskThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        // Create tasks
        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable print100 = new PrintNum(100);

        // Create threads
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);

        //this thread is created using custoimized thread calss where task and thread is packaged in opne class
//        so no need to create Objct of task and then wrap it to thread
//        directly create thread type object using customized Thread class
        Thread thread4 = new PrintEven(100);

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}