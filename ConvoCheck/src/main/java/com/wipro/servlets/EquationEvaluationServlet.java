package com.wipro.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.facilities.AdapterClass;
import com.wipro.implementations.PostfixPrefixEvaluation;

/**
 * Servlet implementation class EquationEvaluationServlet
 */
@WebServlet("/EquationEvaluationServlet")
public class EquationEvaluationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		//Retrieving Data from the form
		String evaluation = request.getParameter("evaluation");
		String expression = request.getParameter("input_number");
		int output = 0;
		
		//Creating Evaluation Class Object
		AdapterClass eval = new PostfixPrefixEvaluation();
		
		//Checking which evaluation to perform to call
		if(evaluation.equals("prefixEvaluation")) {
			output = eval.prefixEvaluation(expression);
		}
		else if(evaluation.equals("postfixEvaluation")) {
			output = eval.postfixEvaluation(expression);
		}
		
		//Setting the attributes
		request.setAttribute("evaluation", evaluation);
		request.setAttribute("number", expression);
		request.setAttribute("output", output);
		RequestDispatcher rd = request.getRequestDispatcher("evaluation");
		rd.forward(request, response);
		
		
		
		
		
	}

}
