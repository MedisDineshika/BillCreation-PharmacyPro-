package com.pharmacy.service;

import java.util.List;

import com.pharmacy.model.Bill;

public interface AccountsService {

	
	//saving the bill of selling drugs
	void save(Bill bill);

	//Getting each row of bill 
	List<Bill> findAll();
}