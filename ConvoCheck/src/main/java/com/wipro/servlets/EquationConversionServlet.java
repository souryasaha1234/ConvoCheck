package com.wipro.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.facilities.AdapterClass;
import com.wipro.implementations.InfixPostfixPrefixConvertor;
import com.wipro.implementations.ToInfix;


/**
 * Servlet implementation class EquationConversionServlet
 */
@WebServlet("/EquationConversionServlet")
public class EquationConversionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting the Content Type of the Page
		response.setContentType("text/html");
		
		//Retrieving Values from the form
		String conversion = request.getParameter("conversion");
		String number = request.getParameter("input_number");
		String output = null;
		/*
		 * <option value="infixToPostfix">infix to Postfix</option>
                <option value="infixToPrefix">infix to Prefix</option>
                <option value="PrefixToInfix">Prefix to Infix</option>
                <option value="PostfixToInfix">Postfix to Infix</option>
		 */
		//Creating Object of InfixPostfixPrefixConvertor Class
		AdapterClass ippc = new InfixPostfixPrefixConvertor();
		AdapterClass infixConvert = new ToInfix();
		//Which method to call
		if(conversion.equals("infixToPostfix")) {
			output = ippc.infixToPostfix(number);
		}
		else if(conversion.equals("infixToPrefix")) {
			output = ippc.infixToPrefix(number);
		}
		else if(conversion.equals("PrefixToInfix")) {
			output = infixConvert.prefixToInfix(number);
		}
		else if(conversion.equals("PostfixToInfix")) {
			output = infixConvert.postfixToInfix(number);
		}
		
		request.setAttribute("conversion", conversion);
		request.setAttribute("expression", number);
		request.setAttribute("output", output);
		RequestDispatcher rd = request.getRequestDispatcher("equationConversion");
		rd.forward(request, response);
		
		
		
		
		
		
		
		
	}

}
