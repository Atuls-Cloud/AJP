package com.banking;

import com.banking.model.Account;
import com.banking.model.Customer;
import com.banking.model.Transaction;
import com.banking.service.AccountService;
import com.banking.service.CustomerService;
import com.banking.service.TransactionService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerService customerService = new CustomerService();
        AccountService accountService = new AccountService();
        TransactionService transactionService = new TransactionService();

        boolean running = true;

        while (running) {
            System.out.println("Welcome to the Banking Management System!");
            System.out.println("1. Create a new customer");
            System.out.println("2. Create a new account");
            System.out.println("3. Check account balance");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Transfer");
            System.out.println("7. View Transaction History");
            System.out.println("8. Update customer details");
            System.out.println("9. Delete customer");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createCustomer(scanner, customerService);
                    break;

                case 2:
                    createAccount(scanner, customerService, accountService);
                    break;
                    
                case 3:
                    checkBalance(scanner, accountService);
                    break;

                case 4:
                    deposit(scanner, accountService, transactionService);
                    break;

                case 5:
                    withdraw(scanner, accountService, transactionService);
                    break;

                case 6:
                    transfer(scanner, accountService, transactionService);
                    break;

                case 7:
                    viewTransactionHistory(scanner, transactionService);
                    break;
                    
                case 8:
                    updateCustomer(scanner, customerService);
                    break;

                case 9:
                    deleteCustomer(scanner, customerService);
                    break;

                case 0:
                    running = false;
                    System.out.println("Thank you for using the Banking Management System!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void createCustomer(Scanner scanner, CustomerService customerService) {
        System.out.println("Enter customer name:");
        String name = scanner.nextLine();
        System.out.println("Enter customer address:");
        String address = scanner.nextLine();
        System.out.println("Enter customer phone:");
        String phone = scanner.nextLine();

        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        customer.setPhone(phone);

        customerService.saveCustomer(customer);
        System.out.println("Customer created successfully!");
    }

    private static void createAccount(Scanner scanner, CustomerService customerService, AccountService accountService) {
        System.out.println("Enter customer ID for account creation:");
        int customerId = scanner.nextInt();
        Customer customer = customerService.findCustomerById(customerId);

        if (customer != null) {
            System.out.println("Enter account type (savings/checking):");
            String accountType = scanner.next();
            System.out.println("Enter initial deposit:");
            double initialDeposit = scanner.nextDouble();

            accountService.createAccount(customer, accountType, initialDeposit);
            System.out.println("Account created successfully!");
        } else {
            System.out.println("Customer not found.");
        }
    }
    
    private static void checkBalance(Scanner scanner, AccountService accountService) {
        System.out.println("Enter account number to check balance:");
        int accountId = scanner.nextInt();
        Account account = accountService.findAccountById(accountId);

        if (account != null) {
            System.out.println("The current balance for account number " + accountId + " is: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void deposit(Scanner scanner, AccountService accountService, TransactionService transactionService) {
        System.out.println("Enter account number for deposit:");
        int accountId = scanner.nextInt();
        Account account = accountService.findAccountById(accountId);

        if (account != null) {
            System.out.println("Enter amount to deposit:");
            double amount = scanner.nextDouble();

            accountService.deposit(account, amount);
            transactionService.recordTransaction("Deposit", amount, account);
            System.out.println("Deposit successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdraw(Scanner scanner, AccountService accountService, TransactionService transactionService) {
        System.out.println("Enter account number for withdrawal:");
        int accountId = scanner.nextInt();
        Account account = accountService.findAccountById(accountId);

        if (account != null) {
            System.out.println("Enter amount to withdraw:");
            double amount = scanner.nextDouble();

            if (account.getBalance() >= amount) {
                accountService.withdraw(account, amount);
                transactionService.recordTransaction("Withdrawal", amount, account);
                System.out.println("Withdrawal successful. New balance: " + account.getBalance());
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void transfer(Scanner scanner, AccountService accountService, TransactionService transactionService) {
        System.out.println("Enter source account number:");
        int sourceAccountId = scanner.nextInt();
        Account sourceAccount = accountService.findAccountById(sourceAccountId);

        System.out.println("Enter destination account number:");
        int destinationAccountId = scanner.nextInt();
        Account destinationAccount = accountService.findAccountById(destinationAccountId);

        if (sourceAccount != null && destinationAccount != null) {
            System.out.println("Enter amount to transfer:");
            double amount = scanner.nextDouble();

            if (sourceAccount.getBalance() >= amount) {
                accountService.transfer(sourceAccount, destinationAccount, amount);
                transactionService.recordTransaction("Transfer Out", amount, sourceAccount);
                transactionService.recordTransaction("Transfer In", amount, destinationAccount);
                System.out.println("Transfer successful.");
            } else {
                System.out.println("Insufficient balance in source account.");
            }
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    private static void viewTransactionHistory(Scanner scanner, TransactionService transactionService) {
        System.out.println("Enter account number to view transaction history:");
        int accountId = scanner.nextInt();
        List<Transaction> transactions = transactionService.getTransactionHistory(accountId);

        if (transactions != null && !transactions.isEmpty()) {
            System.out.println("Transaction History:");
            for (Transaction transaction : transactions) {
                System.out.println("Transaction ID: " + transaction.getId());
                System.out.println("Type: " + transaction.getTransactionType());
                System.out.println("Amount: " + transaction.getAmount());
                System.out.println("Date: " + transaction.getDate());
                System.out.println("-----------------------------------");
            }
        } else {
            System.out.println("No transactions found for this account.");
        }
    }
    
    private static void updateCustomer(Scanner scanner, CustomerService customerService) {
        System.out.println("Enter customer ID to update:");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Customer customer = customerService.findCustomerById(customerId);

        if (customer != null) {
            System.out.println("Enter new name (current: " + customer.getName() + "):");
            String name = scanner.nextLine();
            System.out.println("Enter new address (current: " + customer.getAddress() + "):");
            String address = scanner.nextLine();
            System.out.println("Enter new phone (current: " + customer.getPhone() + "):");
            String phone = scanner.nextLine();

            customer.setName(name.isEmpty() ? customer.getName() : name);
            customer.setAddress(address.isEmpty() ? customer.getAddress() : address);
            customer.setPhone(phone.isEmpty() ? customer.getPhone() : phone);

            customerService.updateCustomer(customer);
            System.out.println("Customer details updated successfully!");
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void deleteCustomer(Scanner scanner, CustomerService customerService) {
        System.out.println("Enter customer ID to delete:");
        int customerId = scanner.nextInt();

        Customer customer = customerService.findCustomerById(customerId);
        if (customer != null) {
            customerService.deleteCustomer(customerId);
            System.out.println("Customer deleted successfully!");
        } else {
            System.out.println("Customer not found.");
        }
    }
}
