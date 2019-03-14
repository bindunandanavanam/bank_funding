package com.cg.newbank.uiesception;

public class TransactionException extends Exception {
	public TransactionException() {
		System.err.println("Fund Transfer failed");
	}

}
