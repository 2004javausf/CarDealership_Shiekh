package com.beans;

public class Payments {
	private int carID;
	private int paymentsDecided;
	private int remainingPayments;
	private int carPrice;
	private double amountRemaining;
	private String userName;
	public Payments(int carID, int paymentsDecided, int remainingPayments, int carPrice, double amountRemaining, String userName) {
		super();
		this.carID = carID;
		this.paymentsDecided = paymentsDecided;
		this.remainingPayments = remainingPayments;
		this.carPrice = carPrice;
		this.amountRemaining = amountRemaining;
		this.userName= userName;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Payments(int carID, int remainingPayments) {
		this.carID = carID;
		this.paymentsDecided = paymentsDecided;
		this.remainingPayments = remainingPayments;
	}
	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public int getPaymentsDecided() {
		return paymentsDecided;
	}
	public void setPaymentsDecided(int paymentsDecided) {
		this.paymentsDecided = paymentsDecided;
	}
	public int getRemainingPayments() {
		return remainingPayments;
	}
	public void setRemainingPayments(int remainingPayments) {
		this.remainingPayments = remainingPayments;
	}
	public int getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	public double getAmountRemaining() {
		return amountRemaining;
	}
	public void setAmountRemaining(double amountRemaining) {
		this.amountRemaining = amountRemaining;
	}

	@Override
	public String toString() {
		return "Payments [carID=" + carID + ", paymentsDecided=" + paymentsDecided + ", remainingPayments="
				+ remainingPayments + ", carPrice=" + carPrice + ", amountRemaining=" + amountRemaining + ", userName="
				+ userName + "]";
	}
	
}
