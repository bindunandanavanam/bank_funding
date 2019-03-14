package com.cg.newbank.custdao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cg.newbank.customer.Customer;

class CustDAOImplTest {
	CustDAOImpl cust=new CustDAOImpl();
	Customer customer=new Customer();
	@Test
	void testRegister() {
		customer.setAadhaarNo("123456789012");
		customer.setAddress("Hyd");
		customer.setBalance(0);
		customer.setEmailId("bindu@gmail");
		customer.setFirstName("Madhu");
		customer.setLastName("N V N");
		customer.setMobileNo("4023511848");
		customer.setPancardNo("123456");
		customer.setPassword("mad934");
		customer=cust.register(customer);
		assertEquals(customer,customer);
	}

	@Test
	void testLogin() {
		customer=cust.login(1001, "123");
		assertEquals(customer,customer);
	}

}
