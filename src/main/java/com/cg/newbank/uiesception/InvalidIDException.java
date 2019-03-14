package com.cg.newbank.uiesception;

public class InvalidIDException extends Exception {
	public InvalidIDException() {
		System.err.println("Invalid Credentials");
	}

}
