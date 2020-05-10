package com.driver;

import java.sql.SQLException;
import java.util.Scanner;

import com.dao.CarDealershipDAOImpl;
import com.dao.OffersDAOImpl;
import com.dao.PaymentDAOImpl;
import com.methods.Methods;

public class Driver {

	public static void main(String[] args) throws Throwable {
		
		Methods run= new Methods();
		run.newUser();
		
		
//		PaymentDAOImpl pdi= new PaymentDAOImpl();
//		try {
//			pdi.remainingPaymentsList("wow");
////			pdi.makePayment("wow");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		OffersDAOImpl oddi = new OffersDAOImpl();
//////		try {
//////			oddi.viewOffers()\;
//////		} catch (Exception e) {
//////			// TODO Auto-generated catch block
//////			e.printStackTrace();
//////		}
//		try {
//			oddi.offers("wow");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Methods mtd=new Methods();
//		
//		CarDealershipDAOImpl cddi=new CarDealershipDAOImpl();
//		
//		try {
//			cddi.acceptRejectOffers();
////			cddi.viewCars();
////			cddi.acceptRejectOffers();
////			System.out.println(cddi.ownedCars("wow"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//		try {
//			cddi.acceptRejectOffers();
//		} catch (Exception e) {
//			// TODO Auto-generated catch bloc
//			e.printStackTrace();
//		}
//		System.out.println("Welcome, please identify as a 1: User, 2: Employee");
//		Scanner sc=new Scanner(Syslntem.in);
//		int choice=sc.nextInt();
//		switch(choice) {
//		//menu for user
//		case 1:
//			System.out.println("Press 1 if you are an existing user\nPress 2 if you want to register ");
//			choice = sc.nextInt();
//			switch(choice) {
//			case 1:
//				try {
//					cddi.checkUser();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
////				mtd.currentUser();
//				break;
////				cddi.existingUser();
//			
//			case 2:
//				try {
//					cddi.insertUser();
//					System.out.println("You can now login: ");
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				break;
//				}
//		case 2: 
//			System.out.println("Login successfull");
//			System.out.println("What do you want to do ");
//			System.out.println("1. Add a Car ");
//			System.out.println("2. Remove a Car ");
//			System.out.println("3. Accept or Reject an Offer ");
//			System.out.println("4. View all Payments ");
//					int sct = sc.nextInt();
//					switch(sct) {
//					case 1:
//						try {
//							cddi.addCars();
//						} catch (SQLException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						break;
//					case 2:
//						try {
//							cddi.removeCar();
//						} catch (SQLException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//			}		
		}
}
