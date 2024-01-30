public class PremiumAccount implements IAccount {
    private int accountNumber;
    private double balance;

    public PremiumAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0; // assuming the initial balance is zero
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public double withdraw(double amount) {
        // The withdrawal is only limited by the current balance, no credit limit
        double amountToWithdraw = Math.min(amount, balance);
        balance -= amountToWithdraw;
        return amountToWithdraw;
    }

    @Override
    public double getCurrentBalance() {
        return balance;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }
}


