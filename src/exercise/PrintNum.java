package exercise;

// The task class for printing numbers from 1 to n for a given n
class PrintNum implements Runnable {
    private int lastNum;

    /**
     * Construct a task for printing 1, 2, ..., n
     */
    public PrintNum(int n) {
        lastNum = n;
    }

    @Override
    /** Tell the thread how to run */
    public void run() {
        for (int i = 1; i <= lastNum; i++) {
            System.out.print(" " + i);
//            if (i == 5) {
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}