import java.util.Scanner;
import java.util.*;
//Infix Postfix and Prefix Convertor
class InfixPostfixPrefixConvertor extends AdapterClass{
    /*This class is a infix, Postfix, Prefix Convertor class.
     * This class has some private and public methods still now.
     * The class is not fully ready yet.... If any Contributions Possible please come forward.
     * And Also provide the suitable comment lines of this class.
    */
    String outputArray;//Resultant output array
    InfixPostfixPrefixConvertor(){
        //It is a no-arg constructor which initializes the resultant output array to blank.
        outputArray = "";
    }
    OperatorStack ops = new OperatorStack();//Creating an OperatorStack class object instance
    
    //To check if the symbol is an operand or not
    private int isOperand(char operand){
        /*This is a private method which checks that the symbol of the given infix/postfix/prefix expression
         * is operand or not
         */
        if((operand >= 'a' && operand <= 'z')||(operand >= 'A' && operand <= 'Z')){
            return 1;//Return 1 if the symbol is an operand
        }
        return 0;//Otherwise 0
    }

    //To check the symbol is an operator or not
    private int isOperator(char operator){
        /*This is a private method which checks that the symbol of the given infix/postfix/prefix expression
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

    //To check the precedence of the operator
    private int precedence(char operator){
        /*This is a private method which returns the precedence of the operators in the given
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
    //Infix to Postfix Convertor Method
    public void infixToPostfix(String expression){
        int i = 0;
        char next = '\0';
        /*This for loop which iterates through the whole expression */
        for(i = 0; i<expression.length(); i++){
            //If the symbol is an operand
            if(this.isOperand(expression.charAt(i)) == 1){
                outputArray += expression.charAt(i);
                continue;
            }
            //If the symbol is an open parenthesis
            if(expression.charAt(i) == '('){
                ops.pushOperatorStack(expression.charAt(i));
                continue;
            }
            //If the symbol is an operator
            if(this.isOperator(expression.charAt(i)) == 1){
                /*This while loop runs only when the precedence of the incoming symbol is lower
                 * than the precedence of the Symbol in the Stack top.
                 */
                while(ops.top != -1 && precedence(expression.charAt(i)) <= precedence(ops.operatorStack[ops.top])){
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
        System.out.println("The equivalent postfix expression of the given infix expression is : ");
        System.out.println(outputArray);//Printing of Result
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
     * This class also contains a private method isOperand() which checks if the symbol of the expression
     * is an operand or not.
    */
    
    //Private Method isOperand of boolean return type
    private boolean isOperand(char operand){
        //Returns true if the symbol of the expression is an operand, otherwise false
        return (operand >= 'a' && operand <= 'z') || (operand >= 'A' && operand <= 'Z');
    }

    //Public method postfixToInfix of void return type
    public void postfixToInfix(String expression){
        //Creating an object reference to the Stack of String
        Stack<String> infix = new Stack<String>();

        //For loop that iterates through the whole expression
        for(int i = 0; i<expression.length(); i++){
            char symbol = expression.charAt(i);
            //If the symbol is an operand then push into the Stack
            if(isOperand(symbol)){
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
        System.out.println("The Infix equivalent of the given prefix expression is : ");
        System.out.println(infix.peek());
    }
}


//Postfix and Prefix Evaluation Class
class PostfixPrefixEvaluation extends AdapterClass{
    int evaluation;
    int[] values;
    StackOperations s = new StackOperations();
    Scanner sc = new Scanner(System.in);
    PostfixPrefixEvaluation(){
        evaluation = 0;
        values = new int[32];
    }
    //To check the symbol of the expression is an operand or not
    private int isOperand(char operand){
        /*This is a private method which checks that the symbol of the given infix/postfix/prefix expression
         * is operand or not
         */
        if((operand >= 'a' && operand <= 'z')||(operand >= 'A' && operand <= 'Z')){
            return 1;//Return 1 if the symbol is an operand
        }
        return 0;//Otherwise 0
    }

    //To enter values to each of the operands of the expression from the user
    private void takeValue(String expression){
        int i;
        for(i = 0; i<expression.length(); i++){
            if(isOperand(expression.charAt(i)) == 1){
                System.out.println("Enter the value of the operand "+expression.charAt(i));
                values[i] = sc.nextInt();
            }
        }
        return;
    }

    //Method for the Postfix Expression Evaluation
    public int postfixEvaluation(String expression){
        //This non-static method of the class does the evaluation of any postfix expression
        //Taking the values of each operand of the expression.
        takeValue(expression);
        int i,a,b,temp = 0;
        //Traversing through the whole expression
        for(i = 0; i<expression.length(); i++){
            //Checking the Symbol of the expression is operand or not
            if(isOperand(expression.charAt(i)) == 1){
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
}

class Test{
    public static void main(String[] args) {
        PostfixPrefixEvaluation ppe = new PostfixPrefixEvaluation();
        int result = ppe.postfixEvaluation("ab+cd-*");
        System.out.println("The result of the postfix evaluation is : "+result);
        ToInfix toInfix = new ToInfix();
        toInfix.postfixToInfix("ab+cd-*");
    }
}