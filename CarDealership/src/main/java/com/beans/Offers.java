package com.beans;

public class Offers {
	private int carID;
	private String userName;
	private String carMake;
	private String carModel;
	private int carYear;
	private int carPrice;
	private int months;
	public Offers(int carID, String userName, String carMake, String carModel, int carYear, int carPrice, int months) {
		super();
		this.carID = carID;
		this.userName = userName;
		this.carMake = carMake;
		this.carModel = carModel;
		this.carYear = carYear;
		this.carPrice = carPrice;
		this.months = months;
	}
	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCarMake() {
		return carMake;
	}
	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public int getCarYear() {
		return carYear;
	}
	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}
	public int getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	public int getMonths() {
		return months;
	}
	public void setMonths(int months) {
		this.months = months;
	}
	@Override
	public String toString() {
		return "Offers [carID=" + carID + ", userName=" + userName + ", carMake=" + carMake + ", carModel=" + carModel
				+ ", carYear=" + carYear + ", carPrice=" + carPrice + ", months=" + months + "]";
	}
	
}
