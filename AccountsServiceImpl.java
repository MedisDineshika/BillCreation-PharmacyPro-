package com.pharmacy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pharmacy.dao.AccountsDao;
import com.pharmacy.model.Bill;

@Service
@Transactional
public class AccountsServiceImpl implements AccountsService  {

	@Autowired AccountsDao accountsDao ;
	
	//saving the bill of selling drugs
	@Override
	public void save(Bill bill) {
		accountsDao.save(bill);
		
	}
	
	//Getting each row of bill
	@Override
	public List<Bill> findAll() {
		
		return accountsDao.findAll();
	}


	
}
