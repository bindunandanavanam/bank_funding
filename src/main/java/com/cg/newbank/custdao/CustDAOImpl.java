package com.cg.newbank.custdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.newbank.customer.Customer;

public class CustDAOImpl implements CustDAO {
	Customer customer = new Customer();

	public Customer register(Customer customer) {
		int c=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Bindu", "oracle123");

			PreparedStatement ps = con.prepareStatement(
					"insert into customer_details(first_name,last_name,email_id,password,pancard_no,aadhaar_no,address,mobile,balance) values(?,?,?,?,?,?,?,?,?)");

			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, customer.getEmailId());
			ps.setString(4, customer.getPassword());
			ps.setString(5, customer.getPancardNo());
			ps.setString(6, customer.getAadhaarNo());
			ps.setString(7, customer.getAddress());
			ps.setString(8, customer.getMobileNo());
			ps.setLong(9, customer.getBalance());
			int i = ps.executeUpdate();
			if (i == 1) {
				PreparedStatement ps2 = con
						.prepareStatement("select account_no,balance from customer_details where aadhaar_no=?");
				ps2.setString(1, customer.getAadhaarNo());
				ResultSet rs = ps2.executeQuery();
				while (rs.next()) {
					customer.setAccountNo(rs.getLong(1));
					customer.setBalance(rs.getLong(2));
					c++;
				}

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Ato-generated catch block
			e.printStackTrace();
		}
		if(c==1)
		return customer;
		else
			return null;
	}

	public Customer login(long acc, String pswd) {
		int c = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Bindu", "oracle123");
			PreparedStatement ps = con.prepareStatement("select * from customer_details where account_no=?");
			ps.setLong(1, acc);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (acc == rs.getLong(1)) {
					if (pswd.equals(rs.getString(5))) {
						customer.setAccountNo(rs.getLong(1));
						customer.setFirstName(rs.getString(2));
						customer.setLastName(rs.getString(3));
						customer.setEmailId(rs.getString(4));
						customer.setPassword(rs.getString(5));
						customer.setPancardNo(rs.getString(6));
						customer.setAadhaarNo(rs.getString(7));
						customer.setAddress(rs.getString(8));
						customer.setMobileNo(rs.getString(9));
						customer.setBalance(rs.getLong(10));

						c++;
					}
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Ato-generated catch block
			e.printStackTrace();
		}
		if (c != 0)
			return customer;
		else
			return null;

	}

}
