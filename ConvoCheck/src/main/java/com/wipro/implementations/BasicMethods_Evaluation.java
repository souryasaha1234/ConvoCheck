package com.wipro.implementations;

public class BasicMethods_Evaluation {
	/*This class contains all the basic methods needed for the postfix and prefix evaluation.
     * The class contains 1 methods -->
     * 1) isOperator --> Checks whether the symbol of the expression is an operator or not.
     *                   If it is then, the method returns 1 and otherwise 0.
     */
    //To check the symbol is an operator or not
    public int isOperator(String operator){
        switch(operator){
            case "+":
            case "-":
            case "*":
            case "/":
            case "$":
            case "^":
            case "%":
                return 1;//Return 1 if the symbol is an operator
            default:
                return 0;//Otherwise 0
        }
    }
}
