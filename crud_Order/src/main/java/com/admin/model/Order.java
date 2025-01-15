package com.admin.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Date orderDate;
	private Date eventDate;
	private String mobileNumber;
	private String address;
	private int quantity;
	private String status;
	private double amount;
	private double billAmount;
	public Order(int id, String name, Date orderDate, Date eventDate, String mobileNumber, String address, int quantity,
			String status, double amount, double billAmount) {
		super();
		this.id = id;
		this.name = name;
		this.orderDate = orderDate;
		this.eventDate = eventDate;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.quantity = quantity;
		this.status = status;
		this.amount = amount;
		this.billAmount = billAmount;
	}
	public Order() {
		super();
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", orderDate=" + orderDate + ", eventDate=" + eventDate
				+ ", mobileNumber=" + mobileNumber + ", address=" + address + ", quantity=" + quantity + ", status="
				+ status + ", amount=" + amount + ", billAmount=" + billAmount + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
