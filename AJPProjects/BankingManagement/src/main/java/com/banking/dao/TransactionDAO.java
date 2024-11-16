package com.banking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.banking.config.HibernateUtil;
import com.banking.model.Transaction;

public class TransactionDAO {
    
    public void saveTransaction(Transaction transaction) {
        org.hibernate.Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(transaction);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Transaction> findTransactionsByAccountId(int accountId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Transaction> query = session.createQuery("from Transaction where account.id = :accountId order by date desc", Transaction.class);
            query.setParameter("accountId", accountId);
            return query.list();
        }
    }
}
