package com.pharmacy.dao;

import java.util.List;

import com.pharmacy.model.Bill;

public interface AccountsDao {

	
	//saving the bill of selling drugs
	void save(Bill bill);

	//Getting each row of bill 
	List<Bill> findAll();
	
}
