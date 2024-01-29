public class Main {
    public static void main(String[] args) {
        // Create accounts
        StandardAccount standardAccount = new StandardAccount(101, -200.0);
        BasicAccount basicAccount = new BasicAccount(102, 100.0);
        PremiumAccount premiumAccount = new PremiumAccount(103);

        // Test deposits
        standardAccount.deposit(300.0);
        basicAccount.deposit(200.0);
        premiumAccount.deposit(500.0);

        // Test withdrawals
        System.out.println("Standard Account Withdrawal: " + standardAccount.withdraw(400.0));
        System.out.println("Basic Account Withdrawal: " + basicAccount.withdraw(150.0));
        System.out.println("Premium Account Withdrawal: " + premiumAccount.withdraw(600.0));

        // Test getting current balances
        System.out.println("Standard Account Balance: " + standardAccount.getCurrentBalance());
        System.out.println("Basic Account Balance: " + basicAccount.getCurrentBalance());
        System.out.println("Premium Account Balance: " + premiumAccount.getCurrentBalance());

        // Create a Bank and test bank operations
        Bank bank = new Bank();
        bank.openAccount(standardAccount);
        bank.openAccount(basicAccount);
        bank.openAccount(premiumAccount);

        // List all accounts
        System.out.println("All accounts in the bank: " + bank.getAllAccounts());

        // List accounts in debt
        System.out.println("Accounts in debt: " + bank.getAllAccountsInDebt());

        // List accounts with a balance greater than a certain amount
        System.out.println("Accounts with balance greater than 100: " + bank.getAllAccountsWithBalance(100));

        // Close an account and try to close an account in debt
        bank.closeAccount(103); // Assuming this account has a positive balance
        bank.closeAccount(101); // This account might be in debt

        // List all accounts after closure
        System.out.println("All accounts in the bank after closure: " + bank.getAllAccounts());
    }
}