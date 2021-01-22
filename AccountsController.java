package com.pharmacy.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pharmacy.model.Bill;
//import com.pharmacy.model.Disease;
//import com.pharmacy.model.FieldOfBill;
import com.pharmacy.model.Item;
import com.pharmacy.service.AccountsService;
import com.pharmacy.service.ItemService;

@Controller
@Transactional
public class AccountsController {

	@Autowired

	AccountsService accountsService;

	@Autowired
	ItemService itemService;
	
	
	//getting the bill of selling drugs
	@RequestMapping(value = "/login/bill2", method = RequestMethod.GET)
	public String view2(Model model, Date EXD) throws Exception {
		Bill bill = new Bill();

		model.addAttribute("ItemsForBill", itemService.findByEXDMoreBefore(EXD));
		model.addAttribute("itemM", bill);

		return "Bill2";
	}

	//saving the bill of selling drugs
	@RequestMapping(value = "/bill2/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveBill2(@RequestBody List<Bill> fieldsOfBill) {
		for (Bill bill : fieldsOfBill) {
			accountsService.save(bill);
			
		}
		
	}

	
	//Getting drugs ordering invoice
	@RequestMapping(value = "/login/invoice", method = RequestMethod.GET)
	public String view3(Model model, Date EXD) throws Exception {
		Item item = new Item();

		model.addAttribute("ItemsForBill", itemService.findByEXDBefore(EXD));
		model.addAttribute("listOfSuppliers", itemService.findAllSuppliers());
		model.addAttribute("itemM", item);

		return "DrugRequestForm";
	}

	//saving drugs ordering invoice
	@RequestMapping(value = "/invoice/add", method = RequestMethod.POST)
	public void saveInvoice(@ModelAttribute("itemM") Item item, BindingResult result, HttpSession httpSession,
			Model model, final RedirectAttributes redirectAttributes) {

		model.addAttribute("id", item.getId());

		model.addAttribute("itemName", item.getItemName());
		model.addAttribute("quantity", item.getQuantity());

		itemService.save(item);
	}

}
