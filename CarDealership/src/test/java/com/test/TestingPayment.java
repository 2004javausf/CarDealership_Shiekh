package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.dao.PaymentDAOImpl;

class TestingPayment {

	@Test
	void Payment() {
		PaymentDAOImpl pdi = new PaymentDAOImpl();
		try {
			pdi.makePayment("wow");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
