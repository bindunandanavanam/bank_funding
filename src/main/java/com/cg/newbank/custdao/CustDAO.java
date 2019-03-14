package com.cg.newbank.custdao;

import com.cg.newbank.customer.Customer;

public interface CustDAO {
	Customer register(Customer customer);
	Customer login(long acc,String pswd);

}
