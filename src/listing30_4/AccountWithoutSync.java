package listing30_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountWithoutSync {

    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        // Create and launch 100 threads
//        register task in the pool
        for (int i = 0; i < 1000; i++) {
            executor.execute(new AddAPennyTask());
        }

        executor.shutdown();

        // Wait until all tasks are finished
        while (!executor.isTerminated()) {
        }

        System.out.println("What is balance? " + account.getBalance());
    }

    // A thread for adding a penny to the account
    private static class AddAPennyTask implements Runnable {
        @Override
        public void run() {
            account.deposit(1);
        }
    }

    private static class Account {

        private int balance = 0;

        public int getBalance() {
            return balance;
        }

//        public synchronized void deposit(int amount) {
//            int newBalance = balance + amount;
//            try {
//                Thread.sleep(5);
//            } catch (InterruptedException ex) {
//            }
//            balance = newBalance;
//        }

        public void deposit(int amount) {
            synchronized (this) {
                balance = balance + amount;
            }
            System.out.println("in thread"+Thread.currentThread().getName());
        }
    }

}
