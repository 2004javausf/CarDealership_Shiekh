package com.methods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.connection.ConnFactory;
import com.dao.CarDealershipDAOImpl;
import com.dao.OffersDAOImpl;
import com.dao.PaymentDAOImpl;

public class Users {
	public static ConnFactory cf=ConnFactory.getInstance();
	
	
	public void currentUser() throws Throwable {
		CarDealershipDAOImpl cdd=new CarDealershipDAOImpl();
		OffersDAOImpl off= new OffersDAOImpl();
		PaymentDAOImpl pdi= new PaymentDAOImpl();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		boolean quit=false;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username: ");
		String userName=sc.nextLine();
		System.out.println("Enter password: ");
		String password=sc.nextLine();
		ResultSet rs=stmt.executeQuery("SELECT * FROM USER1 WHERE USERNAME = '" + userName + "' AND PASSWORD1 =  '"+ password +"'");
		if(rs.next() == true) {
			System.out.println("Login Successful");
			do {
			System.out.println("1. View all Cars ");
			System.out.println("2. Make an offer ");
			System.out.println("3. View all Cars you own ");
			System.out.println("4. View all remaining payments ");
			System.out.println("5. Make a payment ");
			System.out.println("6. QUIT ");
			Scanner s=new Scanner(System.in);
			int choice=s.nextInt();
						switch(choice)
						{
						case 1:
							cdd.viewCars();
							break;
						case 2:
								off.offers(userName);
							break;
						case 3:
								cdd.viewMyOwnerCars(userName);	
								break;
						case 4:
							pdi.remainingPaymentsList(userName);
							break;
						case 5:
							pdi.makePayment(userName);
							break;
						case 6:
							quit=true;
							break;
						default:
							System.out.println("Invalid Choice");
							break;
						}
			}while(!quit);
		}
		else {
			System.out.println("Login Un Successful \n Try Again:");
			currentUser();
		}
		
	}
	
	public void newUser() throws Throwable{
		CarDealershipDAOImpl cdd=new CarDealershipDAOImpl();
		OffersDAOImpl off= new OffersDAOImpl();
		PaymentDAOImpl pdi= new PaymentDAOImpl();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Desire username: ");
		String userName=sc.nextLine();
		System.out.println("Enter Desire password: ");
		String password=sc.nextLine();
		ResultSet rs=stmt.executeQuery("SELECT * FROM USER1 WHERE USERNAME = '" + userName + "'");
		if(rs.next() == true) {
			System.out.println("User Name Already Exists Please Try Again: ");
			newUser();
		}
		else
		{
			String sql="INSERT INTO USER1 VALUES ('"+userName+"','"+password+"')";
			stmt.executeUpdate(sql);
			System.out.println("You Have Successfully Registered \n You Can Now Login");
			currentUser();
		}
		
}
}


