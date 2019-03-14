package com.cg.newbank.transservice;

import com.cg.newbank.transaction.Transaction;
import com.cg.newbank.transdao.TransDAOImpl;
import com.cg.newbank.transdao.TransactionDAO;

public class TransactionServiceImpl implements TransactionService{
	
	TransactionDAO transactionDAO=new TransDAOImpl();

	public long deposit(long transAcc, long amt,long bal) {
		long res=transactionDAO.deposit(transAcc, amt,bal);
		return res;
	}

	public long withdrawl(long transAcc, long amt, long bal) {
		long res=transactionDAO.withdrawl(transAcc, amt,bal);
		return res;
	}

	public long dispBal(long transAcc, long amt, long bal) {
		long res=transactionDAO.showBal(transAcc, amt, bal);
		return res;
		
	}

	public Transaction fundTransfer(Transaction transaction) {
		transaction=transactionDAO.fundTransfer(transaction);
		return transaction;
	}

}
