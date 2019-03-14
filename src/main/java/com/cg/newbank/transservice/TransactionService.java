package com.cg.newbank.transservice;

public interface TransactionService {

	void deposit(long transAcc, long amt,long bal);

	void withdrawl(long acc, long amt, long bal);

	void dispBal(long acc, long amt, long bal);

}
