package com.cg.newbank.transdao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cg.newbank.transaction.Transaction;

class TransDAOImplTest {
	TransDAOImpl trans=new TransDAOImpl();
	Transaction transaction=new Transaction();

	@Test
	void testDeposit() {
		assertEquals(300,trans.deposit(1005, 200, 100));
	}

	@Test
	void testWithdrawl() {
		assertEquals(280,trans.withdrawl(1004, 20, 300));
	}

	@Test
	void testShowBal() {
		assertEquals(280, trans.showBal(1004, 0, 280));
	}

	@Test
	void testFundTransfer() {
		transaction.setAmountTransferred(10);
		transaction.setFromAccountNo(1004);
		transaction.setToAccountNo(1001);
		assertEquals(transaction, trans.fundTransfer(transaction));
	}

}
