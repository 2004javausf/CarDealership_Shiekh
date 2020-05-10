package com.methods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.connection.ConnFactory;
import com.dao.CarDealershipDAOImpl;
import com.dao.OffersDAOImpl;
import com.dao.PaymentDAOImpl;

public class Employee {
	public static ConnFactory cf=ConnFactory.getInstance();
	
	public void employee() throws Throwable {
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
		ResultSet rs=stmt.executeQuery("SELECT * FROM Employee WHERE EMPLOYEE_NAME = '" + userName + "' AND EMP_PASSWORD =  '"+ password +"'");
		if(rs.next() == true) {
			System.out.println("Login Successful");
			do {
			System.out.println("1. View all Cars ");
			System.out.println("2. View all Offers ");
			System.out.println("3. Accept or Reject Offers ");
			System.out.println("4. Add a Car ");
			System.out.println("5. Remove a Car ");
			System.out.println("6. View Payments ");
			System.out.println("7. Quit ");
			Scanner s=new Scanner(System.in);
			int choice=s.nextInt();
			switch(choice)
			{
			case 1:
				cdd.viewCars();
				break;
			case 2:
				off.viewOffers();
				break;
			case 3:
				cdd.acceptRejectOffers();
				break;
			case 4:
				cdd.addCars();
				break;
			case 5:
				cdd.removeCar();
				break;
			case 6:
				pdi.viewPayments();
				break;
			case 7:
				quit=true;
				break;
			default:
				System.out.println("Invalid Choice");
				break;
					
			}
		}while(!quit);
		}
		else {
			System.out.println("Login Error Try Again");
			employee();
		}
	
	}
}
