package com.banking.service;


import com.banking.dao.AccountDAO;
import com.banking.model.Account;
import com.banking.model.Customer;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService() {
        accountDAO = new AccountDAO();
    }

    public void createAccount(Customer customer, String accountType, double initialDeposit) {
        Account account = new Account();
        account.setCustomer(customer);
        account.setAccountType(accountType);
        account.setBalance(initialDeposit);

        accountDAO.saveAccount(account);
        System.out.println("Account created successfully!");
    }

    public Account findAccountById(int accountId) {
        return accountDAO.findAccountById(accountId);
    }

    public void deposit(Account account, double amount) {
        double newBalance = account.getBalance() + amount;
        accountDAO.updateBalance(account, newBalance);
        System.out.println("Deposit successful. New balance: " + newBalance);
    }

    public void withdraw(Account account, double amount) {
        if (account.getBalance() >= amount) {
            double newBalance = account.getBalance() - amount;
            accountDAO.updateBalance(account, newBalance);
            System.out.println("Withdrawal successful. New balance: " + newBalance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void transfer(Account fromAccount, Account toAccount, double amount) {
        if (fromAccount.getBalance() >= amount) {
            double newBalanceFrom = fromAccount.getBalance() - amount;
            double newBalanceTo = toAccount.getBalance() + amount;
            accountDAO.updateBalance(fromAccount, newBalanceFrom);
            accountDAO.updateBalance(toAccount, newBalanceTo);
            System.out.println("Transfer successful. New balance in source account: " + newBalanceFrom);
        } else {
            System.out.println("Insufficient balance for transfer.");
        }
    }
}
