public class Checking extends Account {

    private double overdraftLimit;

    public Checking(int id, double balance, double overdraftLimit) {
        super(id, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (super.getBalance() - amount >= -overdraftLimit) {
            super.setBalance(super.getBalance() - amount);
        } else {
            System.out.println("you don't have enough balance");
        }
    }

    @Override
    public String toString() {
        return "Checking{" +
                "overdraftLimit=" + overdraftLimit +
                "} " + super.toString();
    }
}
