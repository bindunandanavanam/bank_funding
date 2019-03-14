package com.cg.newbank.transservice;

import com.cg.newbank.transdao.TransDAOImpl;
import com.cg.newbank.transdao.TransactionDAO;

public class TransactionServiceImpl implements TransactionService{
	
	TransactionDAO transactionDAO=new TransDAOImpl();

	public void deposit(long transAcc, long amt,long bal) {
		transactionDAO.deposit(transAcc, amt,bal);
		
	}

	public void withdrawl(long transAcc, long amt, long bal) {
		transactionDAO.withdrawl(transAcc, amt,bal);
		
	}

	public void dispBal(long acc, long amt, long bal) {
		// TODO Auto-generated method stub
		
	}

}
