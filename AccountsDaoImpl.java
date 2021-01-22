package com.pharmacy.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pharmacy.model.Bill;

@Repository
public class AccountsDaoImpl implements AccountsDao {

	@Autowired
	SessionFactory sessionFactory;
	
	//saving the bill of selling drugs
	@Override
	public void save(Bill bill) {
		sessionFactory.getCurrentSession().save(bill);
		
	}

	//Getting each row of bill 
	@SuppressWarnings("unchecked")
	@Override
	public List<Bill> findAll() {
	
		
		Session session = sessionFactory.getCurrentSession();
		List<Bill> result= null;
		try {
			Query query = session.createQuery("from Bill");
			
			
			
			 result = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

}
}
