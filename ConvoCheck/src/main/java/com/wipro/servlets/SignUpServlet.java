package com.wipro.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wipro.bean.Accounts;
import com.wipro.factory.AccountsServiceFactory;
import com.wipro.service.AccountsService;

/**
 * Servlet implementation class SignUpServlet
 */

/*messageSign = "Confirm Password is not same";
			HttpSession session = request.getSession();
			session.setAttribute("messageSign", messageSign);
			response.sendRedirect("loginpage");*/

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting the response content Type
		response.setContentType("text/html");
		
		//Retrieving Data from the form
		String username = request.getParameter("username");
		username = username.substring(0,1).toUpperCase() + username.substring(1);
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cnfpass = request.getParameter("cnfpass");
		String messageSign = null;
		
		//Checking the Confirm password and entered password
		if(password.equals(cnfpass)) {
			//Creating an Account Object
			Accounts acc = new Accounts();
			
			//Setting the username, email, password and cnf password of the account
			acc.setUserName(username);
			acc.setEmail(email);
			acc.setPassword(password);
			
			//Creating Accounts Service Class Object
			AccountsService accService = AccountsServiceFactory.getAccountsServiceObject();
			
			//Using the Service class method to sign-up/ register the account eith the site
			String status = accService.signUpUserService(acc);
			
			//If Account Credentials are inserted successfully then create an HttpSession
			if(status.equalsIgnoreCase("success")) {
				System.out.println("Account details inserted Successfully");
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				/*request.setAttribute("username", username);
				RequestDispatcher rd = request.getRequestDispatcher("homepage");
				rd.forward(request, response);*/
				response.sendRedirect("homepage");
			}
			else {
				System.out.println("Account details not inserted Successfully");
				response.sendRedirect("loginpage");
			}
			
		}
		else {
			messageSign = "Confirm Password is not same";
			request.setAttribute("messageSign", messageSign);
			request.setAttribute("username", username);
			request.setAttribute("email", email);
			request.setAttribute("password", password);
			RequestDispatcher rd = request.getRequestDispatcher("loginpage");
			rd.forward(request, response);
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
