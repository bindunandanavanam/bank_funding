package com.cg.newbank.transdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransDAOImpl implements TransactionDAO {

	public void deposit(long transAcc, long amt,long bal) {
		System.out.println(transAcc);
		long res=	bal+amt;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Bindu","oracle123");
			PreparedStatement ps =con.prepareStatement("update customer_details set balance= ? where account_no=?");
			ps.setLong(1, res);
			ps.setLong(2, transAcc);
			int x=ps.executeUpdate();
			if (x == 1) 
				System.out.println("done");
				else
					System.out.println("not inserted");
		
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Ato-generated catch block
		e.printStackTrace();
	}
	

}

	public void withdrawl(long transAcc, long amt, long bal) {
		System.out.println(transAcc);
		if(amt<bal) {
		long res=	bal-amt;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Bindu","oracle123");
			PreparedStatement ps =con.prepareStatement("update customer_details set balance= ? where account_no=?");
			ps.setLong(1, res);
			ps.setLong(2, transAcc);
			int x=ps.executeUpdate();
			if (x == 1) 
				System.out.println("done");
				else
					System.out.println("not inserted");
		
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Ato-generated catch block
		e.printStackTrace();
	}
		
	} else {
		System.out.println("insufficient bal");
	}
	}

	public void showBal(long transAcc, long amt, long bal) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Bindu","oracle123");
			PreparedStatement ps =con.prepareStatement("select balance from customer_details where account_no=?");
			ps.setLong(1, transAcc);
			ResultSet rs=ps.executeQuery();
			System.out.println(rs.getLong(1));
			while(rs.next()) {
				System.out.println("done");
				System.out.println(rs.getLong(1));
			}
				
		
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Ato-generated catch block
		e.printStackTrace();
	}
		
	}
}
