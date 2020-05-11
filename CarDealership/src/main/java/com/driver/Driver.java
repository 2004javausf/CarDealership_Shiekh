package com.driver;

import java.sql.SQLException;

import java.util.Scanner;

import com.dao.CarDealershipDAOImpl;
import com.dao.OffersDAOImpl;
import com.dao.PaymentDAOImpl;
import com.methods.Employee;
import com.methods.Users;

public class Driver {

	public static void main(String[] args) throws Throwable {
		Employee employee=new Employee();
		Users customer=new Users();
		System.out.println("=======================================================\n");
		System.out.println("             WELCOME TO CAR DEALERSHIP\n");
		System.out.println("=======================================================\n");
		System.out.println("Do You want to Login as an Employee or as a Customer");
		System.out.println("If You are a First time User Go for Simple registration");
		System.out.println("1. Employee");
		System.out.println("2. Customer");
		System.out.println("3. Register");
		System.out.println("   Press Any Other Key to Exit");
		Scanner sc=new Scanner(System.in);
		int input= sc.nextInt();
		switch(input)
		{
		case 1:
			employee.employee();
			break;
		case 2:
			customer.currentUser();
			break;
		case 3:
			customer.newUser();
			break;
		
		default:
			System.out.println("Thanks for using our Dealership");
			break;
			
		}
	}
}
