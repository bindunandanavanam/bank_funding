package com.cg.newbank.transdao;

import com.cg.newbank.transaction.Transaction;

public interface TransactionDAO {

	long deposit(long transAcc, long amt,long bal);
	long withdrawl(long transAcc, long amt,long bal);
	long showBal(long transAcc, long amt,long bal);
	Transaction fundTransfer(Transaction transaction);

}
