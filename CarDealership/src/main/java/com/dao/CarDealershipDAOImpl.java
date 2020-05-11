package com.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.beans.Cars;
import com.beans.User;
import com.connection.ConnFactory;

public class CarDealershipDAOImpl implements CarDealershipDAO {
	
	public static ConnFactory cf=ConnFactory.getInstance();
	
	public List<User> getUserList() throws SQLException{
		 List<User> userList= new ArrayList<User>();
		 Connection conn=cf.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM USER1");
			User s=null;
			while(rs.next()) { 
			s= new User(rs.getString(1),rs.getString(2));  
			userList.add(s);
	}
	
			return userList;
	}
	public void addCars() throws SQLException{
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		Scanner sc=new Scanner(System.in);
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Car ID:");
		int carID=s.nextInt();
		ResultSet rs=stmt.executeQuery("SELECT * FROM CARS WHERE CAR_ID = " +carID);
		if(rs.next() == true) {
			System.out.println("CAR ID ALREADY EXIST \n Enter CAR ID Again:");
			carID=s.nextInt();
		}
		System.out.println("Add Car Make:");
		String carMake=sc.nextLine();
		System.out.println("Add Car Model:");
		String carModel=sc.nextLine();
		System.out.println("Add Car Year:");
		int carYear=sc.nextInt();
		System.out.println("Add Car Price:");
		int carPrice=sc.nextInt();
		String sql="INSERT INTO CARS VALUES ( '"+carMake+"','"+carModel+"', "+carYear+" , "+carPrice+", 'Available',"+carID+",'-----')";
		stmt.executeUpdate(sql);
		System.out.println("=======================================================\n");
		System.out.println("             CAR ADDED TO LOT\n");
		System.out.println("=======================================================\n");
	}
	
	public List<Cars> getCarsList() throws Exception {
		 List<Cars> carsList= new ArrayList<Cars>();
		 Connection conn=cf.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM Cars");
			Cars s=null;
			while(rs.next()) { 
			s= new Cars(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getInt(6));  
			carsList.add(s);
	}
		return carsList;
	}

	public void removeCar() throws SQLException{
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Car ID to Remove:");
		int serialNumber=sc.nextInt();
		ResultSet rs=stmt.executeQuery("SELECT * FROM CARS WHERE CAR_ID = " +serialNumber);
		if(rs.next() == true) {
			String sql="DELETE FROM CARS WHERE CAR_ID=("+serialNumber+")";
			stmt.executeUpdate(sql);
			rs = stmt.executeQuery("DELETE FROM PAYMENTS WHERE CAR_ID=( "+ serialNumber+")");
			rs = stmt.executeQuery("DELETE FROM OFFERS WHERE CAR_ID=( "+ serialNumber+")");
			System.out.println("=======================================================\n");
			System.out.println("             CAR REMOVED FROM LOT\n");
			System.out.println("=======================================================\n");
			
		}
		else
		{
			System.out.println("Car ID Doesn't Exist TRY AGAIN");
			removeCar();
		}
	}


	public void viewCars() throws SQLException {
		try {
			for (int i=0; i< getCarsList().size();i++)
			{
				String tmp= getCarsList().get(i).toString();
				
			 System.out.println(tmp);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}


	public void acceptRejectOffers() throws Exception {
		int carId;
		Scanner s=new Scanner(System.in);
		 System.out.println("Enter Car ID you want to Accept or Deny Offer for");
		carId= s.nextInt();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM OFFERS WHERE CAR_ID = "+ carId);
		String choice;
		Scanner sc=new Scanner(System.in);
		 System.out.println("Do you want to accept any offer or reject offers: ");
		 System.out.println("Enter: ");
		choice=sc.nextLine();
		if(choice.equals("accept")) {
			 System.out.println("Enter the user name for which you want to accept offer");
			String userName=sc.nextLine();
			rs = stmt.executeQuery("UPDATE CARS SET CAR_STATUS = 'Owned'  WHERE CAR_ID = " + carId);
			rs = stmt.executeQuery("UPDATE CARS SET OWNER = '"+userName+"'  WHERE CAR_ID = " + carId);
			
			rs = stmt.executeQuery("INSERT INTO PAYMENTS (CAR_ID,PAYMENTS_DECIDED,REMAINING_PAYMENTS,CAR_PRICE,AMOUNT_REMAINING,USERNAME) SELECT CAR_ID,NUMBER_OF_MONTHS,NUMBER_OF_MONTHS,CAR_PRICE,CAR_PRICE,USERNAME FROM OFFERS WHERE USERNAME = '"+userName+"' AND CAR_ID= "+ carId);
			rs = stmt.executeQuery("DELETE FROM OFFERS WHERE CAR_ID = " + carId);

			return;
		}
		else if(choice.equals("reject"))
		{
			rs = stmt.executeQuery("DELETE FROM OFFERS WHERE CAR_ID = " + carId);
			System.out.println("Offer removed");
		}
	}


	public List<Cars> ownedCars(String userName) throws Exception {
		List<Cars> ownedCarsList= new ArrayList<Cars>();
		 Connection conn=cf.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM CARS WHERE OWNER= '"+ userName +"'");
			Cars s=null;
			while(rs.next()) { 
				s= new Cars(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getInt(6));  
				ownedCarsList.add(s);

	}
		 return ownedCarsList;
	}
	
	public void viewMyOwnerCars(String userName) throws Exception{
		try {
			for (int i=0; i< ownedCars(userName).size();i++)
			{
				String tmp= ownedCars(userName).get(i).toString();
				
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
	}


	
		
	


