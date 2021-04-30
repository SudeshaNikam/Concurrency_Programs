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

import com.bank.project.dao.AccountDao;
import com.bank.project.model.Account;

/**
 * @author SUDESHA
 *
 */

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveAccountDetails(Account account) {
		sessionFactory.getCurrentSession().save(account);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getAllAccountDetails() {
		return sessionFactory.getCurrentSession().createQuery("From Account").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getAllAccountDetailsById(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Account u where u.userId=:id");
		query.setParameter("id", userId);
		@SuppressWarnings("rawtypes")
		List results = query.list();
		return results;

	}

	@Override
	public Account geAccountIdByFromAccNo(String fromAccountNumber) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Account a where a.accountNo=:id");
		query.setParameter("id", fromAccountNumber);
		return (Account) query.uniqueResult();

	}

	@Override
	public Account geAccountIdByToAccNo(String toAccountNumber) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Account a where a.accountNo=:id");
		query.setParameter("id", toAccountNumber);
		return (Account) query.uniqueResult();

	}

}
