package com.cg.newbank;

import java.util.Scanner;

import com.cg.newbank.customer.Customer;
import com.cg.newbank.custservice.CustService;
import com.cg.newbank.custservice.CustServiceImpl;
import com.cg.newbank.transaction.Transaction;
import com.cg.newbank.transservice.TransactionService;
import com.cg.newbank.transservice.TransactionServiceImpl;
import com.cg.newbank.uiesception.InvalidIDException;
import com.cg.newbank.uiesception.InvalidInputException;
import com.cg.newbank.uiesception.TransactionException;
import com.cg.newbank.uiesception.WithDrawlException;

public class App {
	static Transaction transaction = new Transaction();
	static CustService custservice = new CustServiceImpl();
	static TransactionService transactionservice = new TransactionServiceImpl();

	public static Scanner sc = new Scanner(System.in);

	public void disp(Long account, Long balance) {
		TransactionService transactionService = new TransactionServiceImpl();
		long acc = account;
		long bal = balance;
		long amt = 0,res=0;
		System.out.println("enter 1. deposit 2. withdrwal 3. show balance 4.Fund Transfer");
		int i = sc.nextInt();
		switch (i) {
		case 1:
			System.out.println("enter amount to deposit");
			amt = sc.nextLong();
			res=transactionService.deposit(acc, amt, bal);
			System.out.println("Balance is"+res);
			break;
		case 2:
			System.out.println("enter amount to debit");
			amt = sc.nextLong();
			res=transactionService.withdrawl(acc, amt, bal);
			if(res!=0)
			System.out.println("Balance is"+res);
			else
				try {
					throw new WithDrawlException();
				} catch (WithDrawlException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
		case 3:
			res=transactionService.dispBal(acc, amt, bal);
			System.out.println("Balance is"+res);
			break;
			
		case 4 :
			System.out.println("enter the source account no");
			transaction.setFromAccountNo(sc.nextLong());
			System.out.println("enter destination account no");
			transaction.setToAccountNo(sc.nextLong());
			System.out.println("enter amount to be transferred");
			transaction.setAmountTransferred(sc.nextLong());
			transaction=transactionService.fundTransfer(transaction);
			if(transaction!=null)
		System.out.println(transaction.getAmountTransferred()+" is transferred from "+transaction.getFromAccountNo()+" to "+transaction.getToAccountNo());
			else
				try {
					throw new TransactionException();
				} catch (TransactionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	public static void main(String[] args) {
		App app = new App();
		Customer customer = new Customer();
		Customer customer1 = new Customer();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter 1. Register 2. Login");
		int c = sc.nextInt();
		switch (c) {
		case 1:

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

			customer = custservice.register(customer);
			if(customer==null)
				try {
					throw new InvalidInputException();
				} catch (InvalidInputException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			break;
		case 2:
			System.out.println("enter account no");
			long acc = sc.nextLong();
			System.out.println("enter password");
			String pswd = sc.next();
			customer1 = custservice.login(acc, pswd);
			if (customer1 != null) {
				System.out.println("welcome " + customer1.getFirstName());
				app.disp(customer1.getAccountNo(), customer1.getBalance());
			} else
				try {
					throw new InvalidIDException();
				} catch (InvalidIDException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;

		}
sc.close();
	}

}
