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

import com.bank.project.dao.UserDao;
import com.bank.project.model.User;

/**
 * @author SUDESHA
 *
 */

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveUserDetails(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public void updateUserDetails(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUserDetails() {
		return sessionFactory.getCurrentSession().createQuery("From User").list();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String loginCheck(String userName, String password) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("from User u where u.userName=:id AND u.password=:pass");
		theQuery.setParameter("id", userName);
		theQuery.setParameter("pass", password);
		List results = theQuery.list();
		if ((results != null) && (results.size() > 0)) {
			return "success";
		} else {
			return "failed";
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<User> getUpdateDetails(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from User u where u.userId=:id");
		query.setParameter("id", userId);
		List results = query.list();
		return results;

	}

	@SuppressWarnings("rawtypes")
	@Override
	public int getUserId(String userName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("select userId from User u where u.userName=:id");
		theQuery.setParameter("id", userName);
		List results = theQuery.list();
		System.out.println("results" + results);
		if (results != null) {
			return (Integer) results.get(0);
		} else {
			return 0;
		}

	}

}
