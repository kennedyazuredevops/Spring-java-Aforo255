package com.app.aforo255.account.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
@Entity
@Table(name = "account")
public class Account implements Serializable {

	private static final long serialVersionUID = -7823734661943925569L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_account")
	private Integer IdAccount;
	@Column(name = "total_amount")
	private double TotalAmount;
	@Column(name = "id_customer")
	private Integer IdCustomer;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_customer", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Customer customer;

	public Integer getIdAccount() {
		return IdAccount;
	}

	public void setIdAccount(Integer idAccount) {
		IdAccount = idAccount;
	}

	public double getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}

	public Integer getIdCustomer() {
		return IdCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		IdCustomer = idCustomer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
