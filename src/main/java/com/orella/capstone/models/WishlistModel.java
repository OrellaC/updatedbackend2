package com.orella.capstone.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wishlist")
public class WishlistModel {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String itemname;
	@Column
	private String itemdescription;
	 
//	Empty constructor 
//	public WishlistModel () {
//		 
//	 }
	
	public int getId() {
		return id;
	}
	
	public String getItemname() {
		return itemname;
	}
	
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	
	public String getItemdescription() {
		return itemdescription;
	}
	
	public void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}
	
	
}
