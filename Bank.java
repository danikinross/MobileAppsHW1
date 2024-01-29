import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Bank implements IBank {
    private List<IAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    @Override
    public void openAccount(IAccount account) {
        if (account != null && !accountExists(account.getAccountNumber())) {
            accounts.add(account);
            System.out.println("Account " + account.getAccountNumber() + " opened successfully.");
        } else {
            System.out.println("Invalid account or account already exists.");
        }
    }

    @Override
    public void closeAccount(int accountNumber) {
        Optional<IAccount> accountOpt = findAccount(accountNumber);

        if (accountOpt.isPresent()) {
            IAccount account = accountOpt.get();
            if (account.getCurrentBalance() >= 0) {
                accounts.remove(account);
                System.out.println("Account " + accountNumber + " closed successfully.");
            } else {
                System.out.println("Account " + accountNumber + " cannot be closed due to debt.");
            }
        } else {
            System.out.println("Account " + accountNumber + " not found.");
        }
    }

    @Override
    public List<IAccount> getAllAccounts() {
        return new ArrayList<>(accounts);
    }

    @Override
    public List<IAccount> getAllAccountsInDebt() {
        List<IAccount> inDebtAccounts = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.getCurrentBalance() < 0) {
                inDebtAccounts.add(account);
            }
        }
        return inDebtAccounts;
    }

    @Override
    public List<IAccount> getAllAccountsWithBalance(double balance) {
        List<IAccount> accountsWithBalance = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.getCurrentBalance() > balance) {
                accountsWithBalance.add(account);
            }
        }
        return accountsWithBalance;
    }

    private boolean accountExists(int accountNumber) {
        return findAccount(accountNumber).isPresent();
    }

    private Optional<IAccount> findAccount(int accountNumber) {
        return accounts.stream()
                .filter(a -> a.getAccountNumber() == accountNumber)
                .findFirst();
    }
}

