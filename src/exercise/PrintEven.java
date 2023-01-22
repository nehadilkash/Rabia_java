package exercise;

public class PrintEven extends Thread {
    int limit;

    public PrintEven(int limit) {
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 1; i <= limit; i++) {
            if (i % 2 == 0) {
                System.out.println("I am in thread class  " + i);
            }
        }
    }
}
