public class BasicAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private double withdrawalLimit;

    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.accountNumber = accountNumber;
        // Set the withdrawal limit to the provided value if it's positive, otherwise set it to zero
        this.withdrawalLimit = withdrawalLimit > 0 ? withdrawalLimit : 0;
        this.balance = 0; // assuming the initial balance is zero
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public double withdraw(double amount) {
        double amountToWithdraw = Math.min(amount, Math.min(withdrawalLimit, balance));
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



