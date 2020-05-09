package com.methods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.connection.ConnFactory;
import com.dao.CarDealershipDAOImpl;
import com.dao.OffersDAOImpl;

public class Methods {
	public static ConnFactory cf=ConnFactory.getInstance();
	public void currentUser() throws SQLException {
		CarDealershipDAOImpl cdd=new CarDealershipDAOImpl();
		OffersDAOImpl off= new OffersDAOImpl();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username: ");
		String userName=sc.nextLine();
		System.out.println("Enter password: ");
		String password=sc.nextLine();
		ResultSet rs=stmt.executeQuery("SELECT * FROM USER1 WHERE USERNAME = '" + userName + "' AND PASSWORD1 =  '"+ password +"'");
		if(rs.next() == true) {
			System.out.println("Login Successful");
			System.out.println("1. View all Cars ");
			System.out.println("2. Make an offer ");
			System.out.println("3. View all Cars you own ");
			System.out.println("4. View all remaining payments ");
			Scanner s=new Scanner(System.in);
			int choice=s.nextInt();
						switch(choice)
						{
						case 1:
							cdd.viewCars();
							break;
						case 2:
							try {
								off.offers(userName);
							} catch (Exception e) {
								e.printStackTrace();
							}
							break;
						case 3:
							try {
								System.out.println(cdd.ownedCars(userName));
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
			return;
		}
		else {
			System.out.println("Login Un Successful");
		}
		
	}
}
		
		
//		String tmp2;
//		try {
//			System.out.println(cdd.getUserList().size());
//			for(int i = 0; i < cdd.getUserList().size(); i++) {
//				tmp2 = cdd.getUserList().get(i).toString();
//				
//				if(tmp2.contains("userName=" + username + ", " + "password=" + password + " ")) {
//					System.out.println("Login successfull");
//					
//					break;
//					}
//				else { System.out.println("Login successfull");}
//				}
			
			
//			System.out.println("What do you want to do ");
//			System.out.println("1. View all Cars ");
//			System.out.println("2. Make an offer ");
//			System.out.println("3. View all Cars you own ");
//			System.out.println("4. View all remaining payments ");
//			Scanner s=new Scanner(System.in);
//			int choice=s.nextInt();
//			switch(choice) {
//			case 1:
////				CarDealershipDAOImpl cddi=new CarDealershipDAOImpl();
//				try {
//					System.out.println(cddi.getCarsList());
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				break;
//			case 2:
//				break;
//			case 3:
//				break;
//			case 4:
//				break;
//					
//			}
//			

