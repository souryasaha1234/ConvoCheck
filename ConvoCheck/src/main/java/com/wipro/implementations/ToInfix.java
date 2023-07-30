package com.wipro.implementations;

import java.util.Stack;

import com.wipro.facilities.AdapterClass;

public class ToInfix extends AdapterClass {
	/*This class converts Postfix and Prefix expressions to its equivalent Infix Expression 
     * This class contains two public void return type methods
     * 1) postfixToInfix() --> Converts the postfix expression to its equivalent infix expression
     *                         Takes a parameter as expression of String type
     * 2) prefixToInfix() --> Converts the prefix expression to it's equivalent infix expression
     *                        Takes a parameter as expression of String type
    */
    
    BasicMethods bsm = new BasicMethods();//Cretaing BasicMethods class object instance

    //Public method postfixToInfix of void return type
    public String postfixToInfix(String expression){
        //Creating an object reference to the Stack of String
        Stack<String> infix = new Stack<String>();

        //For loop that iterates through the whole expression
        for(int i = 0; i<expression.length(); i++){
            char symbol = expression.charAt(i);
            //If the symbol is an operand then push into the Stack
            if(bsm.isOperand(symbol) == 1){
                infix.push(symbol + "");//Pushing symbol into the Stack
            }
            //If the symbol is not an operand then it should be an operator
            else{
                /*If the symbol is an operator then Store the peek element of the Stack in a String Variable
                 * and then pop that peek element from the Stack
                 * Repeat this for one more time with another variable
                 */
                String operand1 = infix.peek();//Storing the peek item of the Stack in variable operand1
                infix.pop();//Popping the peek element from the Stack
                String operand2 = infix.peek();//Storing the peek item of the Stack in variable operand2
                System.out.println(operand2);
                infix.pop();//Popping the peek element from the Stack
                infix.push("(" + operand2 + symbol + operand1 + ")");
                //Pushing the whole expression into the Stack
            }
        }
        //Displaying the result
        /*System.out.println("The Infix equivalent of the given postfix expression is : ");
        System.out.println(infix.peek());*/
        String output = infix.peek();
        output = output.substring(1,output.length()-1);
        return output;
    }

    //Public method of prefixToInfix of void return type
    public String prefixToInfix(String expression){
        //Creating an object reference to the Stack of String
        Stack<String> infix = new Stack<String>();
        //For loop that iterates through the whole expression in reverse order
        for(int i = expression.length()-1; i>=0; i--){
            char symbol = expression.charAt(i);
            //If the symbol is an operand then push into the Stack
            if(bsm.isOperand(symbol) == 1){
                infix.push(symbol+"");//Pushing the symbol into the Stack
            }
            //If the symbol is not an operand then it should be an operator
            else{
                /*If the symbol is an operator then Store the peek element of the Stack in a String Variable
                 * and then pop that peek element from the Stack
                 * Repeat this for one more time with another variable
                 */
                String operand1 = infix.peek();//Storing the peek item of the Stack in variable operand1
                infix.pop();//Popping the peek element from the Stack
                String operand2 = infix.peek();//Storing the peek item of the Stack in variable operand1
                infix.pop();//Popping the peek element from the Stack
                infix.push("(" + operand1 + symbol + operand2 + ")");
                //Pushing the whole expression into the Stack
            }
        }
        //Displaying the result
        /*System.out.println("The Infix equivalent of the given prefix expression is : ");
        System.out.println(infix.peek());*/
        String output = infix.peek();
        output = output.substring(1,output.length()-1);
        return output;
    }

}
