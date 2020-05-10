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
	
	
	
//	public void insertUser() throws SQLException {
//		
//		Connection conn=cf.getConnection();
//		Statement stmt=conn.createStatement();
//		Scanner sc= new Scanner(System.in);
//		System.out.println("Enter desire username: ");
//		String username=sc.nextLine();
//		System.out.println("Enter desire password: ");
//		String password=sc.nextLine();
//		String sql="INSERT INTO USER1 VALUES ('"+username+"','"+password+"')";
//		stmt.executeUpdate(sql);
//	}
	
	
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
		System.out.println("Add Car Make:");
		String carMake=sc.nextLine();
		System.out.println("Add Car Model:");
		String carModel=sc.nextLine();
		System.out.println("Add Car Year:");
		int carYear=sc.nextInt();
		System.out.println("Add Car Price:");
		int carPrice=sc.nextInt();
		String sql="INSERT INTO CARS VALUES ( '"+carMake+"','"+carModel+"', "+carYear+" , "+carPrice+", 'Available',"+carID+")";
		stmt.executeUpdate(sql);
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
		
		System.out.println("Enter Serial Number:");
		int serialNumber=sc.nextInt();
		String sql="DELETE FROM CARS WHERE CAR_ID=("+serialNumber+")";
		stmt.executeUpdate(sql);
	}

	
//	public void checkUser(String userName, String password) throws SQLException{
////		Scanner sc=new Scanner(System.in);
////		System.out.println("Enter username: ");
////		String username=sc.nextLine();
////		System.out.println("Enter password: ");
////		String password=sc.nextLine();
//		for (int i=0; i< getUserList().size();i++)
//		{
//			String tmp= getUserList().get(i).toString();
//			if (tmp.contains("userName=" + userName + ", " + "password=" + password + " ")) {
//				System.out.println("User Name Already Exists");
//				break;
//				}
//			else { System.out.println("Login successfull");}
//			}
//		}


	public void viewCars() throws SQLException {
		try {
			for (int i=0; i< getCarsList().size();i++)
			{
				String tmp= getCarsList().get(i).toString();
				
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
			rs = stmt.executeQuery("DELETE FROM OFFERS WHERE USERNAME = '"+userName+"' AND CAR_ID = " + carId);
			//			String sql="INSERT INTO PAYMENTS VALUES ("+carId+","+rs.getInt(6)+")";
//			stmt.executeUpdate(sql);
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
	}


	
		
	


