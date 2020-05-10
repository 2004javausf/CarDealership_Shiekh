package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.beans.Cars;
import com.beans.Offers;
import com.beans.Payments;
import com.connection.ConnFactory;

public class PaymentDAOImpl implements PaymentDAO {
	public static ConnFactory cf=ConnFactory.getInstance();

	@Override
	public void makePayment(String userName) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Car ID you want to Pay Off:");
		int carID=sc.nextInt();
		System.out.println("Enter Number of Payments to pay off:");
		int numberOfPayments=sc.nextInt();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		int rem;
		double mon,amountRemaining;
		ResultSet rs=stmt.executeQuery("SELECT * FROM PAYMENTS WHERE USERNAME = '" + userName + "' AND CAR_ID = " + carID);
		if(rs.next()== true) { 
		rem=rs.getInt(3)-numberOfPayments;
		mon =rs.getInt(5)/rs.getInt(2);
		amountRemaining = rs.getInt(5)-(numberOfPayments*mon);
		rs = stmt.executeQuery("UPDATE PAYMENTS SET	AMOUNT_REMAINING = "+amountRemaining+"  WHERE CAR_ID = " + carID);
		rs = stmt.executeQuery("UPDATE PAYMENTS SET REMAINING_PAYMENTS = "+rem+"  WHERE CAR_ID = " + carID);
		}		
	}
	
	public List<Payments> viewAllPaymentsList() throws Exception {
		 List<Payments> paymentsList= new ArrayList<Payments>();
		 Connection conn=cf.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM PAYMENTS");
			Payments s=null;
			while(rs.next()) { 
			s= new Payments(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getDouble(5),rs.getString(6));  
		paymentsList.add(s);
	}
		return paymentsList;
	}
	public void remainingPaymentsList(String userName) throws Exception {
		for (int i=0; i< viewAllPaymentsList().size();i++)
		{
			String tmp= viewAllPaymentsList().get(i).toString();
			if(tmp.contains("userName=" + userName + "]"))
					{
				System.out.println("CAR ID = "+ viewAllPaymentsList().get(i).getCarID());
				System.out.println("Remaining Payments = "+viewAllPaymentsList().get(i).getRemainingPayments());
					}
		}
		
	}
	
	
}
