package com.example.demo.entity;

public class InventoryManagementRequest {
	
	private String action; 
    private int quantity;
    
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public InventoryManagementRequest(String action, int quantity) {
		super();
		this.action = action;
		this.quantity = quantity;
	}
	public InventoryManagementRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "InventoryManagementRequest [action=" + action + ", quantity=" + quantity + "]";
	}  

}
