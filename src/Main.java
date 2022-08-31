public class Main {

    public static void main(String[] args) {

        Account account = new Account(1122, 20000.0);
        account.setAnnualInterestRate(4.5);

        account.withdraw(2500);
        account.deposit(3000);

        System.out.println(account.toString());

        Saving savingAccount = new Saving(1122, 20000.0);
        savingAccount.setAnnualInterestRate(4.5);

        savingAccount.withdraw(30000);
        savingAccount.deposit(3000);

        System.out.println(savingAccount.toString());

        Checking checkingAccount = new Checking(1122, 20000.0, 500);
        checkingAccount.setAnnualInterestRate(4.5);

        checkingAccount.withdraw(20499);
        checkingAccount.deposit(3000);

        System.out.println(checkingAccount.toString());

    }
}
