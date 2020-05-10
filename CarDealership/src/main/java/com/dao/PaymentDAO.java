package com.dao;

import java.util.List;

import com.beans.Payments;

public interface PaymentDAO {
	
	public void makePayment(String userName) throws Exception;
	
	public List<Payments> viewAllPaymentsList() throws Exception;
	public void remainingPaymentsList(String userName) throws Exception;
}
