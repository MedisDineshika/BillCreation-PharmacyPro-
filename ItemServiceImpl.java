package com.pharmacy.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.AutoPopulatingList;

import com.pharmacy.dao.ItemDao;
import com.pharmacy.model.Categorized;
import com.pharmacy.model.Disease;
import com.pharmacy.model.Item;

import com.pharmacy.model.Reg;

@Service
@Transactional

public class ItemServiceImpl implements ItemService  {

	//Autowire the ItemDao 
	@Autowired ItemDao itemDao ;
	
	
	
	@Override
	//Save the Item 
	public void save(Item item) {
		itemDao.save(item);
		
	}
	//Save the types of Deseses
	

	@Override
	public List<Item> findAll() {
		return itemDao.findAll();
		
	}
	
	
	//Get the list of items which are going to expire within the given period 
	@Override
	public  List<Item> findByEXDBefore(Date EXD) {
		return itemDao.findByEXDBefore(EXD);
		
		
	}

	
	//Get the list of items which are nearing the minimum stock count 
	@Override
	public List<Item> findByQuantity(Long quantity) {
		return itemDao.findByQuantity(quantity);
	}

	
	//Get the list of items which are appearing in the Bill
	@Override
	public List<Item> findByEXDMoreBefore(Date EXD) {
		return itemDao.findByEXDMoreBefore(EXD);
	}

	@Override
	public List<Reg> findAllSuppliers() {
		
		return itemDao.findAllSuppliers();
	}
	@Override
	public void save(Disease disease) {
		itemDao.save(disease);
		
	}
	@Override
	public void save(AutoPopulatingList<Disease> listOfDiseases) {
		for (Disease disease : listOfDiseases) {
			itemDao.save(disease);
		}
		
	}


	@Override
	public List<Disease> findAllDiseases() {
		return itemDao.findAllDiseases();
		
	}


	@Override
	public List<Item> fetchDifference() {
		return itemDao.Instock();
		
	}


	@Override
	public void save(Categorized categorized) {
		itemDao.save(categorized);
		
	}

	
	
	
	
}
