package com.wipro.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.facilities.AdapterClass;
import com.wipro.implementations.BinaryAndBCD;
import com.wipro.implementations.BinaryAndExcess3;
import com.wipro.implementations.BinaryAndGray;
import com.wipro.implementations.GrayAndExcess;

/**
 * Servlet implementation class CodeConversionServlet
 */
@WebServlet("/CodeConversionServlet")
public class CodeConversionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting the Content Type
		response.setContentType("text/html");
		
		//Retrieving the data from the form
		String conversion = request.getParameter("conversion");
		int number = Integer.parseInt(request.getParameter("input_number"));
		int output = 0;
		//String binary = null;
		
		
		//Creating Object of the Adapter Class
		AdapterClass adp = null;
		
		/*<option value="binaryToGray">Binary To Gray</option>
            <option value="GrayTobinary">Gray To Binary</option>
            <option value="decimalToBCD">Decimal To BCD</option>
            <option value="BCDTobinary">BCD To Binary</option>
            <option value="binaryToExcess3">Binary To Excess-3</option>
            <option value="Excess3Tobinary">Excess-3 To Binary</option>
            <option value="grayToExcess3">Gray To Excess-3</option>
            <option value="Excess3Togray">Excess-3 To Gray</option>
         */
		//Checking which operation is to be performed
		if(conversion.equals("binaryToGray")) {
			adp = new BinaryAndGray();
			output = adp.binToGray(number);
		}
		else if(conversion.equals("GrayTobinary")) {
			adp = new BinaryAndGray();
			output = adp.grayToBin(number);
		}
		else if(conversion.equals("decimalToBCD")) {
			adp = new BinaryAndBCD();
			output = Integer.parseInt(adp.decToBCD(number));
		}
		else if(conversion.equals("BCDTobinary")) {
			adp = new BinaryAndBCD();
			output = adp.BCDToBin(number);
		}
		else if(conversion.equals("binaryToExcess3")) {
			adp = new BinaryAndExcess3();
			output = adp.binToExcess3(number);
		}
		else if(conversion.equals("Excess3Tobinary")) {
			adp = new BinaryAndExcess3();
			output = adp.Excess3ToBin(number);
		}
		else if(conversion.equals("grayToExcess3")) {
			adp = new GrayAndExcess();
			output = adp.grayToExcess3(number);
		}
		else if(conversion.equals("Excess3Togray")) {
			adp = new GrayAndExcess();
			output = adp.Excess3ToGray(number);
		}
		
		//Sending the values to the form
		request.setAttribute("conversion", conversion);
		request.setAttribute("number", number);
		request.setAttribute("output", output);
		RequestDispatcher rd = request.getRequestDispatcher("codeConversion");
		rd.forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
