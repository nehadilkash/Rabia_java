public class Saving extends Account {

    public Saving(int id, double balance) {
        super(id, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (super.getBalance() - amount > 0) {
            super.setBalance(super.getBalance() - amount);
        } else {
            System.out.println("you don't have enough balance");
        }
    }

    @Override
    public String toString() {
        return "Saving{} " + super.toString();
    }
}
