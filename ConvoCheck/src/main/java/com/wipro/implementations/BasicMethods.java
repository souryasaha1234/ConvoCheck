package com.wipro.implementations;

public class BasicMethods {
	/*This class contains all the basic methods needed for the infix, postfix, prefix conversion and their
     * evaluation.
     * The class contains 4 methods -->
     * 1) isOperand --> Checks whether the symbol of the expression is an operand or not. If it is then,
     *                  the method returns 1 otherwise 0.
     * 2) isOperator --> Checks whether the symbol of the expression is an operator or not.
     *                   If it is then, the method returns 1 and otherwise 0.
     * 3) strReverse --> Takes a String of expression and returns a newly reversed expression to the caller.
     * 4) precedence --> Checks and returns the precedence of the operator.
     */

    //To check if the symbol is an operand or not
    public int isOperand(char operand){
        /*This is a public method which checks that the symbol of the given infix/postfix/prefix expression
         * is operand or not
         */
        if((operand >= 'a' && operand <= 'z')||(operand >= 'A' && operand <= 'Z')){
            return 1;//Return 1 if the symbol is an operand
        }
        return 0;//Otherwise 0
    }

    //To check the symbol is an operator or not
    public int isOperator(char operator){
        /*This is a public method which checks that the symbol of the given infix/postfix/prefix expression
         * is a operator or not. This is done by using switch case
         */
        switch(operator){
            case '+':
            case '-':
            case '*':
            case '/':
            case '$':
            case '^':
            case '%':
                return 1;//Return 1 if the symbol is an operator
            default:
                return 0;//Otherwise 0
        }
    }

    //To reverse the expression
    public String strReverse(String expression){
        /*This is a public method which reverses the passed String and returns a new reversed String */
        int i;
        String newExpression = "";//Taking a newExpression String variable to store the reversed String.
        char ch;
        //Traversing through the String expression from lenght-1 to 0
        for(i = expression.length()-1; i>=0; i--){
            ch = expression.charAt(i);
            newExpression += ch;//Appending the characters into the newExpression
        }
        return newExpression;//Returning the Reverse String
    }
    //To check the precedence of the operator
    public int precedence(char operator){
        /*This is a public method which returns the precedence of the operators in the given
         * infix/postfix/prefix expression
         */
        switch(operator){
            //These are the different cases in which different values will be returned
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '$':
            case '^':
                return 3;
            default:
                return 0;
        }
    }
}
