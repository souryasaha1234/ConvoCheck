# ConvoCheck
The Code convertor and checker

This a project which is going to bulid up in java.
We are going to design a code convertor which will convert the following codes into what the user wants to.
1) Binary Code/Number
2) Decimal Code/Number
3) Octal Code/Number
4) Hexadecimal Code/Number
5) Gray Code
6) Binary Coded Decimals(BCD)
7) Excess-3 Code

There are also some Conversions and evaluations based on expressions as follows:
1) Infix Expression
2) Postfix Expression
3) Prefix Expression

For this conversion and evaluations of the above expressions we have created an Infix_postfix_prefix_operations.java file.
This file contains 4 classes for the conversion and evaluation of infix, postfix and prefix methods.
Following is the description of each classes -->
-----------------------------------------------------------------------------
1) BasicMethods Class --> 
------------------------------
This class contains all the basic methods needed for the infix, postfix and prefix conversion and their evaluation
      The class contains 4 methods -->
      A) isOperand --> Checks whether the symbol of the expression is an operand or not. If it is then,
                       the method returns 1 otherwise 0.
      B) isOperator --> Checks whether the symbol of the expression is an operator or not.
                        If it is then, the method returns 1 and otherwise 0.
      C) sreReverse --> Takes a String of expression and returns a newly reversed expression to the caller.
      D) precedence --> Checks and returns the precedence of the operator.
     
2) InfixPostfixPrefixConvertor Class -->
-------------------------------------------
This class is a infix, Postfix, Prefix Convertor class.
      This class has public methods.
      The class is fully ready.... If any Contributions Possible please come forward.
      And Also provide the suitable comment lines of this class.
      This class implements two methods of the interface ConvertorInterf. They are as follows : 
      1) infixToPostfix() --> The methods is used to convert an Infix expression given by the user 
                              to it's equivalent Postfix Expression. This method take only one parameter
                              as a String expression. It has a void return type.
      2) infixToPrefix() --> The method is used to convert an Infix Expression given by the user to it's
                             equivalent Prefix Expression. This method take only one parameter as String
                             expression. It has a void return type.

3) ToInfix Class -->
-----------------------
This class converts Postfix and Prefix expressions to its equivalent Infix Expression 
      This class contains two public void return type methods
      1) postfixToInfix() --> Converts the postfix expression to its equivalent infix expression
                              Takes a parameter as expression of String type
      2) prefixToInfix() --> Converts the prefix expression to it's equivalent infix expression
                             Takes a parameter as expression of String type
    
4) PostfixPrefixEvaluation Class -->
---------------------------------------
This is class for evaluating the Postfix and Prefix Expressions entered by the users.
      This class has 3 methods , one private and two public methods.
      1) takeValue() --> This method is a private method which is used to enter values to each of the 
                         operands of the expression from the user.
      2) postfixEvaluation() --> This is a public method which is used to evaluate the postfix expression
                                 with respect to the values of the operands given by the user.
                                 This method returns the result of the evaluation as an integer.
      3) prefixExpression() --> This is a public method which is used to evaluate the prefix expression
                                 with respect to the values of the operands given by the user.
                                 This method returns the result of the evaluation as an integer.
    


Note:- Every body are free to contribute just when you all commit your changes please provide a name at the bottom