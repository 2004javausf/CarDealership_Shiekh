 package com.dao;

import java.util.List;

import com.beans.Cars;
import com.beans.User;

public interface CarDealershipDAO {
	
//	public void insertUser() throws Exception;
	
	public List<User> getUserList() throws Exception;
	
	public List<Cars> getCarsList() throws Exception;
	
	public void addCars() throws Exception;
	
	public void removeCar() throws Exception;
	
//	public void checkUser() throws Exception;
	
	public void viewCars() throws Exception;
	
	public List<Cars> ownedCars(String userName) throws Exception;
	
	public void acceptRejectOffers() throws Exception;
	
}
