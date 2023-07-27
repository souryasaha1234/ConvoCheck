package com.wipro.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.factory.ConnectionFactory;

/**
 * Servlet implementation class StartServlet
 */
@WebServlet(value="/StartServlet",loadOnStartup=1)
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con = null;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		//Creating connection object
			try {
				con = ConnectionFactory.getConnectionObject();
				if(con != null)
					System.out.println("Connection Established");
				else
					System.out.println("Connection not Established");
			} catch (Exception e) {
				throw new ServletException("Error in init() of "+getClass().getName(),e);
			}
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting the content type
		response.setContentType("text/html");
		
		//Redirecting to the Home Page
		response.sendRedirect("homepage");
		
	}

}
