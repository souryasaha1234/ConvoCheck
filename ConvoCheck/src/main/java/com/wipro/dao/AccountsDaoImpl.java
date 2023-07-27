package com.wipro.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wipro.bean.Accounts;
import com.wipro.factory.ConnectionFactory;

public class AccountsDaoImpl implements AccountsDao {

	@Override
	public String signUpUser(Accounts acc) {
		
		//Resource Declarations
		Connection con = null;
		Statement st = null;
		
		//Variable Declarations
		String userName = null,email = null,password = null,status = null;
		int count = 0;
		
		try {
			//Establishing Connection with the database
			con = ConnectionFactory.getConnectionObject();
			
			//Creating Statement Object
			if(con != null) {
				st = con.createStatement();
			}
			
			//Getting the Account details from Accounts class object
			userName = "'"+acc.getUserName()+"'";
			email = "'"+acc.getEmail()+"'";
			password = "'"+acc.getPassword()+"'";
			
			//insert into accounts values('raysouvik18@gmail.com','tojo123','SouvikTojo')
			//Creating the Query
			String query = "INSERT INTO ACCOUNTS VALUES("+email+","+password+","+userName+")";
			
			//Executing the Query
			if(st != null)
				count = st.executeUpdate(query);
			
			//Generating Status
			if(count == 1) 
				status = "success";
			else
				status = "failure";
			
		}catch (SQLException se) {
			if(se.getErrorCode() == 1)
				System.out.println("Duplicate cannot be inserted to Primary Key Column.");
			if(se.getErrorCode() == 1400)
				System.out.println("Null cannot be Inserted to primary key column.");
			if(se.getErrorCode() >= 900 && se.getErrorCode() <= 999)
				System.out.println("Inavlid column Names or table name or SQL keywords");
			if(se.getErrorCode() == 12899)
				System.out.println("Do not insert more than column size data columns");
			System.out.println(se.toString());
			status = "error";
		}
		catch (Exception e) {
			status = "error";
			e.printStackTrace();
		}
		finally {
			try {
				if(st != null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return status;
	}

	@Override
	public String loginUser(Accounts acc) {
		
		//Resource Declarations
		Connection con = null;
		Statement st = null;
		ResultSet rst = null;
		
		//Variable Declarations
		String username = null,email = null,password = null,status = null;
		
		try {
			
			//Establishing Database Connection
			con = ConnectionFactory.getConnectionObject();
			
			//Creating Statement Object
			if(con != null)
				st = con.createStatement();
			
			//Getting the details of account
			username = acc.getUserName();
			email = acc.getEmail();
			password = acc.getPassword();
			
			//select username,email_address from accounts where username='Rajdeep' and password='123';
			//Creating the Query
			String query = "SELECT USERNAME,EMAIL_ADDRESS FROM ACCOUNTS WHERE EMAIL_ADDRESS='"+email+"' AND PASSWORD='"+password+"'";
			
			//Executing the Query
			if(st != null)
				rst = st.executeQuery(query);
			
			//Validating User Credentials
			if(rst.next()) {
				if(username.equals(rst.getString(1)) && email.equals(rst.getString(2))) {
					status = "success";
				}
				else
					status = "failure";
			}
			else
				status = "not existed";
			
		}catch (SQLException se) {
			if(se.getErrorCode() == 1)
				System.out.println("Duplicate cannot be inserted to Primary Key Column.");
			if(se.getErrorCode() == 1400)
				System.out.println("Null cannot be Inserted to primary key column.");
			if(se.getErrorCode() >= 900 && se.getErrorCode() <= 999)
				System.out.println("Inavlid column Names or table name or SQL keywords");
			if(se.getErrorCode() == 12899)
				System.out.println("Do not insert more than column size data columns");
			System.out.println(se.toString());
			status = "error"; 
		}catch (Exception e) {
			status = "error";
			e.printStackTrace();
		}
		finally {
			try {
				if(rst != null)
					rst.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(st != null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return status;
	}

}
