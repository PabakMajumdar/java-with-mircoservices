package com.productservice.model;

public class ServerResponse {
Order order;
double price;
String txId;
String message;
public ServerResponse(Order order, double price, String txId, String message) {
	super();
	this.order = order;
	this.price = price;
	this.txId = txId;
	this.message = message;
}
public Order getOrder() {
	return order;
}
public void setOrder(Order order) {
	this.order = order;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getTxId() {
	return txId;
}
public void setTxId(String txId) {
	this.txId = txId;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}

}
