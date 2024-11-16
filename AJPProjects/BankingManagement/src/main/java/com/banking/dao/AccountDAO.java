package com.banking.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.banking.config.HibernateUtil;
import com.banking.model.Account;

public class AccountDAO {
    
    public void saveAccount(Account account) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(account);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public Account findAccountById(int accountId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Account> query = session.createQuery("from Account where accountNumber = :accountId", Account.class);
            query.setParameter("accountId", accountId);
            return query.uniqueResult();
        }
    }

    public void updateBalance(Account account, double newBalance) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            account.setBalance(newBalance);
            session.update(account);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}