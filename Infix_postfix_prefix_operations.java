import java.util.Scanner;
import java.util.*;

//Basic Methods Class
class BasicMethods{
    /*This class contains all the basic methods needed for the infix, postfix, prefix conversion and their
     * evaluation.
     * The class contains 4 methods -->
     * 1) isOperand --> Checks whether the symbol of the expression is an operand or not. If it is then,
     *                  the method returns 1 otherwise 0.
     * 2) isOperator --> Checks whether the symbol of the expression is an operator or not.
     *                   If it is then, the method returns 1 and otherwise 0.
     * 3) sreReverse --> Takes a String of expression and returns a newly reversed expression to the caller.
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



//Infix Postfix and Prefix Convertor
class InfixPostfixPrefixConvertor extends AdapterClass{
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
    InfixPostfixPrefixConvertor(){
        //It is a no-arg constructor which initializes the resultant output array to blank.
        outputArray = "";
    }
    OperatorStack ops = new OperatorStack();//Creating an OperatorStack class object instance
    
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
            if(bsm.isOperand(expression.charAt(i)) == 1){
                outputArray += expression.charAt(i);
                continue;
            }
            //If the symbol is an open parenthesis
            if(expression.charAt(i) == '('){
                ops.pushOperatorStack(expression.charAt(i));
                continue;
            }
            //If the symbol is an operator
            if(bsm.isOperator(expression.charAt(i)) == 1){
                /*This while loop runs only when the precedence of the incoming symbol is lower
                 * than the precedence of the Symbol in the Stack top.
                 */
                while(ops.top != -1 && bsm.precedence(expression.charAt(i)) <= bsm.precedence(ops.operatorStack[ops.top])){
                    /*If it is, then pop the Stack top element until the precedence of the symbol is
                     * higher than the precedence of the Stack top Symbol
                     */
                    outputArray += ops.popOperatorStack();
                }
                //Push the incoming Symbol into the Stack
                ops.pushOperatorStack(expression.charAt(i));
                continue;
            }
            //If the symbol is a left parenthesis
            if(expression.charAt(i) == ')'){
                while((next = ops.popOperatorStack()) != '('){
                    outputArray += next;
                }
                continue;
            }
        }
        //Popping of the remaining elements from the Stack.
        while(ops.top != -1){
            outputArray += ops.popOperatorStack();
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
                while(ops.top != -1 && bsm.precedence(symbol) < bsm.precedence(ops.operatorStack[ops.top])){
                    outputArray += ops.popOperatorStack();
                }
                //After the execution of this while push the Symbol into the operator Stack
                ops.pushOperatorStack(symbol);
            }
            //If the Symbol of the expression is close parenthesis ")" then push it into the Stack
            else if(symbol == ')'){
                ops.pushOperatorStack(symbol);
            }
            //If the symbol is an open parenthesis "(" then
            else if(symbol == '('){
                char next;
                /*Pop the operator Stack until close parenthesis is being encountered
                 * and append the popped out operator to the output array.
                 */
                while((next = ops.popOperatorStack()) != ')'){
                    outputArray += next;
                }
            }
            else{
                //Else if it is a operand just append it into the output array
                outputArray += symbol;
            }
        }
        //Popping the remaining the remaining elements from the Stack
        while(ops.top != -1){
            outputArray += ops.popOperatorStack();
        }
        //Printing the result
        /*System.out.println("The equivalent prefix expression of the given infix expression is : ");
        System.out.println(bsm.strReverse(outputArray));*/
        String newArray = bsm.strReverse(outputArray);
        return newArray;
    }
}
//ToInfix Convertor class
class ToInfix extends AdapterClass{
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
                infix.pop();//Popping the peek element from the Stack
                infix.push("(" + operand2 + symbol + operand1 + ")");
                //Pushing the whole expression into the Stack
            }
        }
        //Displaying the result
        /*System.out.println("The Infix equivalent of the given postfix expression is : ");
        System.out.println(infix.peek());*/
        return infix.peek();
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
        return infix.peek();
    }
}


//Postfix and Prefix Evaluation Class
class PostfixPrefixEvaluation extends AdapterClass{
    /*This is class for evaluating the Postfix and Prefix Expressions entered by the users.
     * This class has 3 methods , one private and two public methods.
     * 1) takeValue() --> This method is a private method which is used to enter values to each of the 
     *                    operands of the expression from the user.
     * 2) postfixEvaluation() --> This is a public method which is used to evaluate the postfix expression
     *                            with respect to the values of the operands given by the user.
     *                            This method returns the result of the evaluation as an integer.
     * 3) prefixExpression() --> This is a public method which is used to evaluate the prefix expression
     *                            with respect to the values of the operands given by the user.
     *                            This method returns the result of the evaluation as an integer.
     */
    int evaluation;
    int[] values;
    StackOperations s = new StackOperations();
    Scanner sc = new Scanner(System.in);
    PostfixPrefixEvaluation(){
        /*A no arg Constructor to declare the value of evaluation to be 0 and declare the integer array values */
        evaluation = 0;
        values = new int[32];
    }
    
    BasicMethods bsm = new BasicMethods();//Cretaing BasicMethods class object instance

    //To enter values to each of the operands of the expression from the user
    private void takeValue(String expression){
        int i;
        //Traversing through the whole expression
        for(i = 0; i<expression.length(); i++){
            //If the symbol of the expression is an operand then enter the value of that operand.
            if(bsm.isOperand(expression.charAt(i)) == 1){
                System.out.println("Enter the value of the operand "+expression.charAt(i));
                values[i] = sc.nextInt();
            }
        }
        return;
    }

    //Method for the Postfix Expression Evaluation
    public int postfixEvaluation(String expression){
        //This non-static method of the class which does the evaluation of any postfix expression
        //This method returns the result of the evaluation to the caller.
        //Taking the values of each operand of the expression.
        takeValue(expression);
        int i,a,b,temp = 0;
        //Traversing through the whole expression
        for(i = 0; i<expression.length(); i++){
            //Checking the Symbol of the expression is operand or not
            if(bsm.isOperand(expression.charAt(i)) == 1){
                s.push(values[i]);
            }
            //If the symbol is not an operand then it must be an operator
            else{
                //Pop two times from the Stack
                a = s.pop();
                b = s.pop();
                //Considering which operator it has encountered
                switch(expression.charAt(i)){
                    //Perform the following required operations as the operator is encountered
                    case '+':
                        temp = b + a;
                        break;
                    case '-':
                        temp = b - a;
                        break;
                    case '*':
                        temp = b * a;
                        break;
                    case '/':
                        temp = b/a;
                        break;
                    case '^':
                    case '$':
                        temp = (int)Math.pow(b,a);
                        break;
                }//end switch
                s.push(temp);//Push the result back into the Stack
            }//end else
        }//end for
    return s.pop();//Pop and return the Stack top to obtain the final result after evaluation
    }

    //Prefix Evaluation
    public int prefixEvaluation(String expression){
        //This a non-static method which evaluates the given prefix expression.
        //This method returns the result of the evaluation to the caller.
        int i = 0,a = 0,b = 0,temp = 0;
        //Taking the values of each operand of the expression.
        takeValue(expression);
        //Storing the reversed expression in a newExpression String variable
        String newExpression = bsm.strReverse(expression);
        //For loop for iterating through the new reversed String
        for(i = 0; i<newExpression.length(); i++){
            char symbol = newExpression.charAt(i);
            //If the symbol of the expression is an operand or not
            if(bsm.isOperand(symbol) == 1){
                //If it is then push the corresponding value of the operand into the operandStack
                s.push(values[newExpression.length()-i-1]);
            }
            //If the symbol of the xpression is not an operand then it must be an operator
            else{
                //If it is then pop the operand Stack two times
                a = s.pop();
                b = s.pop();
                //Switch Case
                switch(symbol){
                    //Perform the following required operations as the operator is encountered
                    case '+':
                        temp = a + b;
                        break;
                    case '-':
                        temp = a - b;
                        break;
                    case '*':
                        temp = a * b;
                        break;
                    case '/':
                        temp = a/b;
                        break;
                    case '^':
                    case '$':
                        temp = (int)Math.pow(a,b);
                        break;
                }
                //Push the result of the evaluation of the two popped operands in to the Stack again
                s.push(temp);
            }
        }
        return s.pop();//Poping and returning the result of the evaluation
    }
}