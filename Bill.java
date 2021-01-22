
package com.pharmacy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Transient;


@Entity
@Table(name= "Bill")
public class Bill {

	
	@GeneratedValue @Id
	private int id;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="item_code")
	private String item_code;
	
	@Column(name="unitPrice")
	private Long unitPrice ;
	
	
	@Column(name="quantity")
	private Long quantity ;
	
	
	@Column(name="price")
	private Long price ;
	
	@Column(name="total")
	private Long total ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	
	
	
	
	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public Long getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
	
	//@Column(name="amountRecieved")
	//private Long amountRecieved ;
	
	//@Column(name="balance")
	//private Long balance ;	
}
