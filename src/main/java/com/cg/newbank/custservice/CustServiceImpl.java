package com.cg.newbank.custservice;

import com.cg.newbank.custdao.CustDAO;
import com.cg.newbank.custdao.CustDAOImpl;
import com.cg.newbank.customer.Customer;

public class CustServiceImpl implements CustService{

	CustDAO custdao=new CustDAOImpl();
	Customer customer =new Customer();
	public Customer register(Customer customer) {
		if(customer.getMobileNo().length()==10) {
			if(customer.getAadhaarNo().length()==12) {
				
				customer=custdao.register(customer);
			return customer;
		}
			else
				return null;
		}
		else
			return null;
		
	}

	public Customer login(long acc,String pswd) {
		customer=custdao.login(acc, pswd);
		return customer;
		
	}

	

}
