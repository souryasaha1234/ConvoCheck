package com.wipro.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wipro.bean.Accounts;
import com.wipro.factory.AccountsServiceFactory;
import com.wipro.service.AccountsService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting the Content Type
		response.setContentType("text/html");
		
		//Retrieving Login form data
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//Creating Accounts Object
		Accounts acc = new Accounts();
		
		//Setting the attributes of the Accounts Object
		acc.setUserName(username);
		acc.setEmail(email);
		acc.setPassword(password);
		
		//Creating Object of the Service Layer
		AccountsService accService = AccountsServiceFactory.getAccountsServiceObject();
		
		String status = accService.loginUserService(acc);
		String welcomeMessage = null;
		
		
		if(status.equalsIgnoreCase("success")) {
			//System.out.println("Account details inserted Successfully");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			welcomeMessage = "<script>\r\n"
					+ "            swal({\r\n"
					+ "                title: \"Welcome "+username+"\",\r\n"
					+ "                text: \"You'r successfully Logged in to your account\",\r\n"
					+ "                icon: \"success\",\r\n"
					+ "                button: \"OK\",\r\n"
					+ "              });\r\n"
					+ "        </script>";
			
			request.setAttribute("welcomeMessage", welcomeMessage);
			
			RequestDispatcher rd = request.getRequestDispatcher("homepage");
			rd.forward(request, response);
			//response.sendRedirect("homepage");
		}
		else if(status.equalsIgnoreCase("failure")) {
			String message = "Username or Password is Incorrect";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("loginpage");
			rd.forward(request, response);
		}
		else if(status.equalsIgnoreCase("not existed")) {
			String message = "User credentials Not Existed";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("loginpage");
			rd.forward(request, response);
		}
		else {
			System.out.println("Some error occured");
			response.sendRedirect("homepage");
		}
		
		
		
		
		
		
		
	}

}
