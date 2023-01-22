package assignment;

public class PingPong implements Runnable {
    private String printStr;

    public PingPong(String printStr) {
        this.printStr = printStr;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(printStr);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
