package com.beans;

public class Cars {
	private int carID;
	private String carStatus;
	private String carMake;
	private String carModel;
	private int carYear;
	private int carPrice;
	public Cars( String carMake, String carModel, int carYear, int carPrice, String carStatus,int carID ) {
		super();
		this.carID = carID;
		this.carStatus = carStatus;
		this.carMake = carMake;
		this.carModel = carModel;
		this.carYear = carYear;
		this.carPrice = carPrice;
	}
	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public String getCarStatus() {
		return carStatus;
	}
	public void setCarStatus(String carStatus) {
		this.carStatus = carStatus;
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
	@Override
	public String toString() {
		return "Cars [carID=" + carID + ", carStatus=" + carStatus + ", carMake=" + carMake + ", carModel=" + carModel
				+ ", carYear=" + carYear + ", carPrice=" + carPrice + "]";
	}
	

	
}
