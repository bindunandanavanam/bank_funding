package com.cg.newbank.transservice;

import com.cg.newbank.transaction.Transaction;

public interface TransactionService {

	long deposit(long transAcc, long amt,long bal);

	long withdrawl(long acc, long amt, long bal);

	long dispBal(long acc, long amt, long bal);

	Transaction fundTransfer(Transaction transaction);

}
