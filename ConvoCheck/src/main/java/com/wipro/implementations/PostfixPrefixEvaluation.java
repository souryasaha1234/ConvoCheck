package com.wipro.implementations;

import java.util.Stack;

import com.wipro.facilities.AdapterClass;

public class PostfixPrefixEvaluation extends AdapterClass {
	/*This is class for evaluating the Postfix and Prefix Expressions entered by the users.
     * This class has 2 methods , one private and two public methods.
     * 1) postfixEvaluation() --> This is a public method which is used to evaluate the postfix expression
     *                            with respect to the values of the operands given by the user.
     *                            This method returns the result of the evaluation as an integer.
     * 2) prefixExpression() --> This is a public method which is used to evaluate the prefix expression
     *                            with respect to the values of the operands given by the user.
     *                            This method returns the result of the evaluation as an integer.
     */
    int evaluation;
    //int[] values;
    Stack<Integer> stack = new Stack<>();
    //Scanner sc = new Scanner(System.in);
    public PostfixPrefixEvaluation(){
        /*A no arg Constructor to declare the value of evaluation to be 0 and declare the integer array values */
        evaluation = 0;
        //values = new int[32];
    }
    BasicMethods_Evaluation bsm = new BasicMethods_Evaluation();//Cretaing BasicMethods class object instance
    //Method for the Postfix Expression Evaluation
    public int postfixEvaluation(String expression){
        //This non-static method of the class which does the evaluation of any postfix expression
        //This method returns the result of the evaluation to the caller.
		String[] sa = expression.split(" ");
        int i,a,b,temp = 0;
        //Traversing through the whole expression 
        for(i = 0; i<sa.length; i++){
            //Checking the Symbol of the expression is operand or not using isOperator().
            if(bsm.isOperator(sa[i]) != 1){
                stack.push(Integer.parseInt(sa[i]));
            }
            //If the symbol is not an operand then it must be an operator
            else{
                //Pop two times from the Stack
                a = stack.pop();
                b = stack.pop();
                //Considering which operator it has encountered
                switch(sa[i]){
                    //Perform the following required operations as the operator is encountered
                    case "+":
                        temp = b + a;
                        break;
                    case "-":
                        temp = b - a;
                        break;
                    case "*":
                        temp = b * a;
                        break;
                    case "/":
                        temp = b/a;
                        break;
                    case "^":
                    case "$":
                        temp = (int)Math.pow(b,a);
                        break;
                }//end switch
                stack.push(temp);//Push the result back into the Stack
            }//end else
        }//end for
    return stack.pop();//Pop and return the Stack top to obtain the final result after evaluation
    }
    //Method for the Prefix Expression Evaluation
    public int prefixEvaluation(String expression){
        //This non-static method of the class which does the evaluation of any prefix expression
        //This method returns the result of the evaluation to the caller.
        int i = 0,a = 0,b = 0,temp = 0;
        //Seperating the Inputs using split(" "). 
		String[] sa = expression.split(" ");
        for(i = sa.length-1; i>=0; i--){
            //Checking the Symbol of the expression is operand or not using isOperator().
            if(bsm.isOperator(sa[i]) != 1){
                stack.push(Integer.parseInt(sa[i]));
            }
            else{
                //Pop two times from the Stack
                a = stack.pop();
                b = stack.pop();
                //Considering which operator it has encountered
                switch(sa[i]){
                    //Perform the following required operations as the operator is encountered
                    case "+":
                        temp = a + b;
                        break;
                    case "-":
                        temp = a - b;
                        break;
                    case "*":
                        temp = a * b;
                        break;
                    case "/":
                        temp = a/b;
                        break;
                    case "^":
                    case "$":
                        temp = (int)Math.pow(a,b);
                        break;
                }//end switch
                stack.push(temp);//Push the result back into the Stack
            }//end else
        }//end for
        return stack.pop();//Pop and return the Stack top to obtain the final result after evaluation
    }
}
