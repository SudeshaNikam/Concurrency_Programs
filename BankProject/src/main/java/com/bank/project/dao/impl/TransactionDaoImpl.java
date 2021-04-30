/**
 * 
 */
package com.bank.project.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.project.dao.TransactionDao;
import com.bank.project.model.Transaction;

/**
 * @author SUDESHA
 *
 */

@Repository
public class TransactionDaoImpl implements TransactionDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveTransferAmount(Transaction transaction, int userId) {
		sessionFactory.getCurrentSession().save(transaction);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Transaction> getTransactionHistory(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Transaction u where u.userId=:id");
		query.setParameter("id", userId);
		List results = query.list();
		return results;
	}

	@Override
	public void removeAndAmount(int accountId, int amount1) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("update Account a set a.balance =:amount where a.accountId=:id");
		query.setParameter("amount", amount1);
		query.setParameter("id", accountId);
		query.executeUpdate();
	}

}
