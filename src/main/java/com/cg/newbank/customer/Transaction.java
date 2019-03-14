package com.cg.newbank.customer;

public class Transaction {
	private long tranaction_id,from_account_no,to_account_no,amount_transferred;

	public long getTranaction_id() {
		return tranaction_id;
	}

	public void setTranaction_id(long tranaction_id) {
		this.tranaction_id = tranaction_id;
	}

	public long getFrom_account_no() {
		return from_account_no;
	}

	public void setFrom_account_no(long from_account_no) {
		this.from_account_no = from_account_no;
	}

	public long getTo_account_no() {
		return to_account_no;
	}

	public void setTo_account_no(long to_account_no) {
		this.to_account_no = to_account_no;
	}

	public long getAmount_transferred() {
		return amount_transferred;
	}

	public void setAmount_transferred(long amount_transferred) {
		this.amount_transferred = amount_transferred;
	}
	

}
