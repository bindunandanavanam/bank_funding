package com.cg.newbank.uiesception;

public class InvalidInputException extends Exception {
	public InvalidInputException() {
		System.err.println("Pls enter 10 digit mobile no and 12 digit aadhaar no");
	}

}
