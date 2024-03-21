package com.productservice.model;



public class Order {


//	@GeneratedValue(strategy = GenerationType.AUTO)
	int orderId;
	String orderName;
	int qty;
	double price;
	
	public Order(int orderId, String orderName, int qty, double price) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.qty = qty;
		this.price = price;
	}
	public Order() {
		super();
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + ", qty=" + qty + ", price=" + price + "]";
	}
	
}
