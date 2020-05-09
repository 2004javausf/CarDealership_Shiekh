package com.dao;

import java.util.List;

import com.beans.Offers;

public interface OffersDAO {
	
	public void offers(String userName) throws Exception;
	
	public List<Offers> getOffersList() throws Exception;
	
	public void viewOffers() throws Exception;
}