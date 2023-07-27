package com.wipro.implementations;

import java.util.Stack;

import com.wipro.facilities.AdapterClass;

public class InfixPostfixPrefixConvertor extends AdapterClass {
	/*This class is a infix, Postfix, Prefix Convertor class.
     * This class has public methods.
     * The class is fully ready.... If any Contributions Possible please come forward.
     * And Also provide the suitable comment lines of this class.
     * This class implements two methods of the interface ConvertorInterf. They are as follows : 
     * 1) infixToPostfix() --> The methods is used to convert an Infix expression given by the user 
     *                         to it's equivalent Postfix Expression. This method take only one parameter
     *                         as a String expression. It has a void return type.
     * 2) infixToPrefix() --> The method is used to convert an Infix Expression given by the user to it's
     *                        equivalent Prefix Expression. This method take only one parameter as String
     *                        expression. It has a void return type.
    */
    String outputArray;//Resultant output array
    public InfixPostfixPrefixConvertor(){
        //It is a no-arg constructor which initializes the resultant output array to blank.
        outputArray = "";
    }
    Stack<Character> ops = new Stack<>();//Creating an OperatorStack class object instance
    
    BasicMethods bsm = new BasicMethods();//Creating a BasicMethods Class object instance
    
    //Infix to Postfix Convertor Method
    public String infixToPostfix(String expression){
        /*This is a public method which is implemented here.
         * This method is used to convert a given infix expression to it's equivalent postfix.
         */
        int i = 0;
        char next = '\0';
        /*This for loop which iterates through the whole expression */
        for(i = 0; i<expression.length(); i++){
            //If the symbol is an operand
            char a = expression.charAt(i);
            if(bsm.isOperand(a) == 1){
                outputArray += a;
                continue;
            }
            //If the symbol is an open parenthesis
            if(a == '('){
                ops.push(a);
                continue;
            }
            //If the symbol is an operator
            if(bsm.isOperator(a) == 1){
                /*This while loop runs only when the precedence of the incoming symbol is lower
                 * than or equal to the precedence of the Symbol in the Stack top.
                 */
                while(!ops.empty() && bsm.precedence(a) <= bsm.precedence(ops.peek())){
                    /*If it is, then pop the Stack top element until the precedence of the symbol is
                     * higher than the precedence of the Stack top Symbol
                     */
                    outputArray += ops.pop();
                }
                //Push the incoming Symbol into the Stack
                ops.push(a);
                continue;
            }
            //If the symbol is a left parenthesis
            if(a == ')'){
                while((next = ops.pop()) != '('){
                    outputArray += next;
                }
                continue;
            }
        }
        //Popping of the remaining elements from the Stack.
        while(!ops.empty()){
            outputArray += ops.pop();
        }
        //System.out.println("The equivalent postfix expression of the given infix expression is : ");
        //System.out.println(outputArray);//Printing of Result
        return outputArray;
    }
    

    //Infix to Prefix Convertor Method
    public String infixToPrefix(String expression){
        /*This is a public method which is implemented here.
         * This method is used to convert a given infix expression to it's equivalent prefix
         */
        //First reverse the expression and store the new reversed expression in a String variable newExpression
        String newExpression = bsm.strReverse(expression);
        int i;
        //Iterate through the whole reversed expression
        for(i = 0; i<newExpression.length(); i++){
            char symbol = newExpression.charAt(i);
            //If the symbol of the expression is an operator
            if(bsm.isOperator(symbol) == 1){
                //while Loop To pop all the operators of higher precedence if there is any.
                while(!ops.empty() && bsm.precedence(symbol) < bsm.precedence(ops.peek())){
                    outputArray += ops.pop();
                }
                //After the execution of this while push the Symbol into the operator Stack
                ops.push(symbol);
            }
            //If the Symbol of the expression is close parenthesis ")" then push it into the Stack
            else if(symbol == ')'){
                ops.push(symbol);
            }
            //If the symbol is an open parenthesis "(" then
            else if(symbol == '('){
                char next;
                /*Pop the operator Stack until close parenthesis is being encountered
                 * and append the popped out operator to the output array.
                 */
                while((next = ops.pop()) != ')'){
                    outputArray += next;
                }
            }
            else{
                //Else if it is a operand just append it into the output array
                outputArray += symbol;
            }
        }
        //Popping the remaining the remaining elements from the Stack
        while(!ops.empty()){
            outputArray += ops.pop();
        }
        //Printing the result
        /*System.out.println("The equivalent prefix expression of the given infix expression is : ");
        System.out.println(bsm.strReverse(outputArray));*/
        String newArray = bsm.strReverse(outputArray);
        return newArray;
    }
}
