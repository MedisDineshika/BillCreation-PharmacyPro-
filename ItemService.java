package com.pharmacy.service;

import java.util.Date;
import java.util.List;

import org.springframework.util.AutoPopulatingList;

import com.pharmacy.model.Categorized;
import com.pharmacy.model.Disease;
import com.pharmacy.model.Item;

import com.pharmacy.model.Reg;

public interface ItemService {

	//Save the Item of Drugs 
	public void save (Item item );
	
	//Save the types of Diseases
	public void save ( Disease disease);
	
	
	public List<Item> findAll();
	
	
	
	//Get the list of Items which is going to expire 
	public  List<Item> findByEXDBefore(Date EXD);

	
	
	//Get the list of items which are nearing the minimum stock count 
	public List<Item> findByQuantity(Long quantity);
	
	//Get the list of items which are appearing in the Bill
	public List<Item>findByEXDMoreBefore(Date EXD);

	public List<Reg> findAllSuppliers();

	public void save(AutoPopulatingList<Disease> listOfDiseases);

	public List<Disease> findAllDiseases();

	//public Object findAllSuppliers();
	
	public List<Item> fetchDifference();

	public void save(Categorized categorized);

	
	
	
	
}
