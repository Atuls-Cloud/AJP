package com.banking.service;


import com.banking.dao.TransactionDAO;
import com.banking.model.Transaction;
import com.banking.model.Account;

import java.util.Date;
import java.util.List;

public class TransactionService {
    private TransactionDAO transactionDAO;

    public TransactionService() {
        transactionDAO = new TransactionDAO();
    }

    public void recordTransaction(String type, double amount, Account account) {
        Transaction transaction = new Transaction();
        transaction.setTransactionType(type);
        transaction.setAmount(amount);
        transaction.setDate(new Date());
        transaction.setAccount(account);

        transactionDAO.saveTransaction(transaction);
    }

    public List<Transaction> getTransactionHistory(int accountId) {
        return transactionDAO.findTransactionsByAccountId(accountId);
    }
}

