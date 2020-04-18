package com.app.aforo255.account.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="customer")
public class Customer implements Serializable  {


	private static final long serialVersionUID = 2442748100662770543L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_customer")
	private Integer IdCustomer ;
	@Column(name="full_name")
	private String FullName ;
	public Integer getIdCustomer() {
		return IdCustomer;
	}
	public void setIdCustomer(Integer idCustomer) {
		IdCustomer = idCustomer;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
