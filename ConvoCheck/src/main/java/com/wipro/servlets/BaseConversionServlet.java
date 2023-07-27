package com.wipro.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.facilities.AdapterClass;
import com.wipro.implementations.Base_2_to_36;

/**
 * Servlet implementation class BaseConversionServlet
 */
@WebServlet("/BaseConversionServlet")
public class BaseConversionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting response type
		response.setContentType("text/html");
		
		//Retrieving Values from the form
		String num = request.getParameter("input_number");
		int fromBase = Integer.parseInt(request.getParameter("fromBase"));
		int toBase = Integer.parseInt(request.getParameter("toBase"));
		
		//Creating Base_2_to_36 class Object
		AdapterClass baseConvert = new Base_2_to_36();
		//Calling the Convert function of the class
		String output = baseConvert.Convert(num, fromBase, toBase);
		
		//Sending the output to the baseConversion.jsp Page
		request.setAttribute("num", num);
		request.setAttribute("fromBase", fromBase);
		request.setAttribute("toBase", toBase);
		request.setAttribute("output", output);
		RequestDispatcher rd = request.getRequestDispatcher("baseConversion");
		rd.forward(request, response);
		
		
		
		
		
		
		
		
		
	}

}
