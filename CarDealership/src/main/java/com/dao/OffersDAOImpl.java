package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.beans.Cars;
import com.beans.Offers;
import com.connection.ConnFactory;

public class OffersDAOImpl implements OffersDAO {
	public static ConnFactory cf=ConnFactory.getInstance();

	@SuppressWarnings("resource")
	public void offers(String userName) throws Exception {
//		List<Offers> offerList= new ArrayList<Offers>();

		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Car ID you want to make an offer for.");
		int carID=sc.nextInt();
		System.out.println("Enter Number of months you want for payments.");
		int months=sc.nextInt();
		ResultSet rs=stmt.executeQuery("SELECT * FROM OFFERS WHERE USERNAME = '" + userName + "' AND CAR_ID = " + carID);
		if(rs.next() == true) {
			System.out.println("You Already Have a Pending Offer for this Car.");
		}
		else {
			ResultSet rss;
			rss=stmt.executeQuery("SELECT * FROM CARS WHERE CAR_STATUS = 'Available' AND CAR_ID = " + carID);

//			Offers offer=null;
			
			if(rss.next() == true)  { 
				String sql= "INSERT INTO OFFERS VALUES(" + rss.getInt(6) + ",'" + userName + "','" + rss.getString(1) + "','" + rss.getString(2) + "', " + rss.getInt(3) + "," + rss.getInt(4) + ","+months+")";
				stmt.executeUpdate(sql);
				System.out.println("=======================================================");
				System.out.println("	THANK YOU FOR YOUR OFFER.");
				System.out.println("=======================================================");
//				rss=stmt.executeQuery("INSERT INTO OFFERS VALUES(" + rss.getInt(6) + ",'" + userName + "','" + rss.getString(1) + "','" + rss.getString(2) + "', " + rss.getInt(3) + "," + rss.getInt(4) + ","+months+")");
		
//					rs = stmt.executeQuery("INSERT INTO OFFERS VALUES(" + rs.getInt(6) + ",'" + userName + "','" + rs.getString(1) + "','" + rs.getString(2) + "', " + rs.getInt(3) + "," + rs.getInt(4) + ","+months+")");
				}
			else {
				System.out.println("=======================================================");
				System.out.println("	CANNOT MAKE OFFER.");
				System.out.println("=======================================================");
			}
			}
//				while(rss.next()) {
//					System.out.println("Data added to Offers Table");
////					rs = stmt.executeQuery("INSERT INTO OFFERS VALUES(" + rs.getInt(6) + ",'" + userName + "','" + rs.getString(1) + "','" + rs.getString(2) + "', " + rs.getInt(3) + "," + rs.getInt(4) + ","+months+")");
//				}
//				offer = new Offers(rs.getInt(6),userName,rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),months);
//			rs = stmt.executeQuery("INSERT INTO OFFERS VALUES(" + carID +",'" + userName + "',);
			
//			String sql="INSERT INTO STUDENT2 VALUES ("+rs.getInt(6)+",'"+userName+"','"+rs.getString(1)+"','"+rs.getString(2)+"',"+rs.getInt(3)+","+rs.getInt(4)+","+months+")";
//			stmt.executeUpdate(sql);
//			offerList.add(offer);
		
			
		}

	public List<Offers> getOffersList() throws Exception {
		List<Offers> offersList= new ArrayList<Offers>();
		 Connection conn=cf.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM Offers");
			Offers offer=null;
			while(rs.next()) { 
			offer= new Offers(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7));  
			offersList.add(offer);
	}
		return offersList;
		
	}

	public void viewOffers() throws Exception {
		try {
			for (int i=0; i< getOffersList().size();i++)
			{
				String tmp= getOffersList().get(i).toString();
				
			 System.out.println(tmp);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
		
		
//		return offerList;
	}
	

