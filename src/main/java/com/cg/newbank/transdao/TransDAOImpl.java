package com.cg.newbank.transdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.newbank.transaction.Transaction;

public class TransDAOImpl implements TransactionDAO {

	public long deposit(long transAcc, long amt, long bal) {
		System.out.println(transAcc);
		long res = bal + amt;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Bindu", "oracle123");
			PreparedStatement ps = con.prepareStatement("update customer_details set balance= ? where account_no=?");
			ps.setLong(1, res);
			ps.setLong(2, transAcc);
			int x = ps.executeUpdate();
			// if (x == 1)
			// System.out.println("done");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Ato-generated catch block
			e.printStackTrace();
		}
		return res;

	}

	public long withdrawl(long transAcc, long amt, long bal) {
		System.out.println(transAcc);
		int c = 0;
		long res = 0;
		if (amt < bal) {
			res = bal - amt;

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Bindu",
						"oracle123");
				PreparedStatement ps = con
						.prepareStatement("update customer_details set balance= ? where account_no=?");
				ps.setLong(1, res);
				ps.setLong(2, transAcc);
				int x = ps.executeUpdate();
				// if (x == 1)
				// System.out.println("done");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Ato-generated catch block
				e.printStackTrace();
			}
			c++;
		}
		if (c == 0)
			return 0;
		else
			return res;
	}

	public long showBal(long transAcc, long amt, long bal) {

		return bal;
	}

	public Transaction fundTransfer(Transaction transaction) {
		int c = 0;
		long amt = transaction.getAmountTransferred();
		long fromBal = 0, toBal = 0, fromAcc = 0, toAcc = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Bindu", "oracle123");
			PreparedStatement ps = con.prepareStatement("select * from customer_details where account_no=? ");
			ps.setLong(1, transaction.getFromAccountNo());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				fromAcc = rs.getLong(1);
				fromBal = rs.getLong(10);
			}
			PreparedStatement ps1 = con.prepareStatement("select * from customer_details where account_no=? ");
			ps1.setLong(1, transaction.getToAccountNo());
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				toAcc = rs1.getLong(1);
				toBal = rs1.getLong(10);
			}
			if (amt < fromBal) {
				fromBal = fromBal - amt;
				toBal = toBal + amt;
				PreparedStatement ps2 = con
						.prepareStatement("insert into transaction_details values(trans.nextval,?,?,?)");
				ps2.setLong(1, fromAcc);
				ps2.setLong(2, toAcc);
				ps2.setLong(3, amt);
				int x = ps2.executeUpdate();
				if (x == 1) {
					PreparedStatement ps3 = con
							.prepareStatement("update customer_details set balance= ? where account_no=?");
					ps3.setLong(1, fromBal);
					ps3.setLong(2, fromAcc);
					ps3.executeUpdate();

					PreparedStatement ps4 = con
							.prepareStatement("update customer_details set balance= ? where account_no=?");
					ps4.setLong(1, toBal);
					ps4.setLong(2, toAcc);
					ps4.executeUpdate();

					transaction.setAmountTransferred(amt);
					transaction.setFromAccountNo(fromAcc);
					transaction.setToAccountNo(toAcc);

					// System.out.println("done");
				}
				c++;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Ato-generated catch block
			e.printStackTrace();
		}
		if(c!=0)
		return transaction;
		else 
			return null;
	}
}