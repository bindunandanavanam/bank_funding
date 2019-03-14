package com.cg.newbank;

import java.util.Scanner;

import com.cg.newbank.customer.Customer;
import com.cg.newbank.customer.Transaction;
import com.cg.newbank.custservice.CustService;
import com.cg.newbank.custservice.CustServiceImpl;
import com.cg.newbank.transservice.TransactionService;
import com.cg.newbank.transservice.TransactionServiceImpl;

public class App 
{
	public static Scanner sc = new Scanner(System.in);
	public void disp(Long account, Long balance){
		TransactionService transactionService=new TransactionServiceImpl();
		long acc=account;
		long bal=balance;
		System.out.println("enter 1. deposit 2. withdrwal 3. show balance");
		int i=sc.nextInt();
		switch(i){
		case 1:
			transactionService.deposit(acc, amt, bal);
			break;
		case 2:
			transactionService.deposit(acc, amt, bal);
			break;
		case 3:
		
			transactionService.deposit(acc, amt, bal);
			break;
		}
	}
	static long transAcc,bal;
	static Customer customer =new Customer();
	static Transaction transaction =new Transaction();
	static CustService custservice =new CustServiceImpl();
	static TransactionService transactionservice =new TransactionServiceImpl();
	
    public static void main( String[] args )
    {
    	
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the choice 1. Login/Registration 2. Transaction");
        int ch=sc.nextInt();
        switch(ch)
        {
        case 1:
        	System.out.println("enter 1. Register 2. Login");
        	int c=sc.nextInt();
        	if(c==1) {
        		System.out.println("enter first_name");
        		customer.setFirstName(sc.next());
        		System.out.println("enter last_name");
        		customer.setLastName(sc.next());
        		System.out.println("enter email");
        		customer.setEmailId(sc.next());
        		System.out.println("enter password");
        		customer.setPassword(sc.next());
        		System.out.println("enter pan card ");
        		customer.setPancardNo(sc.next());
        		System.out.println("enter aadhaar no");
        		customer.setAadhaarNo(sc.next());
        		System.out.println("enter address");
        		customer.setAddress(sc.next());
        		System.out.println("enter mobile number");
        		customer.setMobileNo(sc.next());
        		customer.setBalance(0);
        		
        		custservice.register(customer);
        		
        	}
        	else if(c==2) {
        		System.out.println("enter account no");
        		long acc=sc.nextLong();
        		System.out.println("enter password");
        		String pswd=sc.next();
        		customer=	custservice.login(acc,pswd);
        		 transAcc=customer.getAccountNo();
        		 System.out.println(transAcc);
        		 bal=customer.getBalance();
        		 customer.setAccountNo(transAcc);
        		 
  
        	}
        	break;
        case 2:
        	System.out.println("Transaction");
        	System.out.println("Enter 1. Deposit 2. Withdrawl 3. Show Balance 4. Fund Transfer ");
        	int c2=sc.nextInt();
        	System.out.println(customer.getAccountNo());
        	
        }
        	
    }

}
