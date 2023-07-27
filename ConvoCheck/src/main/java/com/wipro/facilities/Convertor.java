package com.wipro.facilities;

public interface Convertor {
	 	String infixToPrefix(String expression);
	    String prefixToInfix(String expression);
	    String infixToPostfix(String expression);
	    String postfixToInfix(String expression);
	    int postfixEvaluation(String expression);
	    int prefixEvaluation(String expression);
	    String Convert(String num,int x,int y);
	    int binToGray(int bin);
	    int grayToBin(int gray);
	    String decToBCD(int dec);
	    int BCDToBin(int bcd);
	    int binToExcess3(int bin);
	    int Excess3ToBin(int Excess);
	    int grayToExcess3(int gray);
	    int Excess3ToGray(int excess);
}
