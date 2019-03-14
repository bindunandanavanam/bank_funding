package com.cg.newbank.transdao;

public interface TransactionDAO {

	void deposit(long transAcc, long amt,long bal);
	void withdrawl(long transAcc, long amt,long bal);
	void showBal(long transAcc, long amt,long bal);

}
