public class StandardAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private double creditLimit;

    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;
        // Set credit limit to the provided value if it's negative, otherwise set it to zero
        this.creditLimit = creditLimit < 0 ? creditLimit : 0;
        this.balance = 0; // assuming the initial balance is zero
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public double withdraw(double amount) {
        // Calculate the maximum amount that can be withdrawn based on the credit limit
        double maxAllowedWithdrawal = balance - creditLimit;

        // Limit the withdrawal amount to the lesser of the requested amount and the max allowed
        double amountToWithdraw = Math.min(amount, maxAllowedWithdrawal);

        // Ensure the withdrawal does not result in a balance lower than the credit limit
        if (balance - amountToWithdraw < creditLimit) {
            amountToWithdraw = balance - creditLimit;
        }

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


