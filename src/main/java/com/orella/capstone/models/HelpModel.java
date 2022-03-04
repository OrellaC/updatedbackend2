package com.orella.capstone.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="help")
public class HelpModel {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String issuetype;
	@Column 
	private String issuedescription;
	
	public int getId() {
		return id;
	}

	public String getIssuetype() {
		return issuetype;
	}
	
	
	public void setIssuetype(String issuename) {
		this.issuetype = issuename;
	}
	
	
	public String getIssuedescription() {
		return issuedescription;
	}
	
	
	public void setIssuedescription(String issuedescription) {
		this.issuedescription = issuedescription;
	}
	
}
