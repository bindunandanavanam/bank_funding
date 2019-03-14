package com.cg.newbank.custservice;

import com.cg.newbank.customer.Customer;



public interface CustService {
	Customer register(Customer customer);
	Customer login(long acc, String pswd);

}
