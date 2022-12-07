# ConvoCheck
The Code Convertor Web-App

Features Offerred :-
=======================================================================================

We are going to design a code convertor which will convert the any codes/numbers into what the user wants to.
i.e from any base to any base.
Suppose an user wants to convert a base 6 number to a base 10 number ... or any Binary number to it's equivalent Hexadecimal Form.

This web app also convert some codes to it's any equivalent forms, such as follows : 
      1) Gray Code
      2) Binary Coded Decimals(BCD)
      3) Excess-3 Code

There are also some Conversions and evaluations based on expressions we use in our Data Structures such as follows:
      1) Infix Expression
      2) Postfix Expression
      3) Prefix Expression

**We have also added an unique feature which is a LOGIN page**

      Any user can create his/her account with our web app and do any conversions as the user wants to.
      All the conversions history will be saved securely and when the user again logins into our app 
      they will get some suggesstions of conversions based on their conversion history 
      and can also retreive their past conversions.

----------------------------------------------------------------------------------------------------------------------------

Building Blocks of the App
-----------------------------------------------------------------------------------------

ConvoCheck is a JAVA based Web-App.
Technologies and Languages Used in this Web-App
----------------------------------------------------
      1) JAVA
      2) HTML
      3) CSS
      4) JAVASCRIPT
      5) JAVA SERVELET
      6) JDBC

------------------------------------------------------------------------------------------------------------
Java Code Structure :-
=========================
In a Convertor.java file we have created an Interface called ConvertorInterf in which we have all the required Conversions methods to be implemented. 
For this we have used 3 .java files for the Logic Building purpose and implementing all the ConvertorInterf methods as follows :-
1) Base_2_to_36.java
2) binGrayBCDExcess3.java
3) Infix_postfix_prefix_operations.java
---------------------------------------------------------------------------------------------------------------
Base_2_to_36.java
------------------------
      In this java file we have created a class called Base_2_to_36 which extends the Adapter class and Implements Convert() method of the ConvertorInterf Interface.
      Convert() method --> This method is designed to convert any base number to any base provided the bases must be between 2 - 36. To get a Detailed Analysis of this method please check the .java file.
---------------------------------------------------------------------------------------------------------
binGrayBCDExcess3.java
-------------------------
      In this java file we have Created 4 classes which extends the Adapter Class to implement the methods of the ConvertorInterf Interface.
      The Classes are as Follows :-
      1) binaryAndGray :- The primary motive of this class isto change a binary number to it's equivalent Gray code and 
                        a Gray code to it's equivalent Binary number with the help of decimal number system. For more information about this class Please visit the binGrayBCDExcess3.java
      2) binaryAndBCD :- This Class is used to Convert a Decimal number to it's equivalent BCD and a BCD code to it's 
                        equivalent Binary number. For more information about this class Please visit the binGrayBCDExcess3.java
      3) binaryAndExcess3 :- This Class is used to convert a Binary Number to it's equivalent Excess 3 Code and Vice versa.
                              For more information about this class Please visit the binGrayBCDExcess3.java
      4) grayAndExcess :- This Class is used to convert a Gray Code Number to it's equivalent Excess 3 Code and Vice versa.
                        For more information about this class Please visit the binGrayBCDExcess3.java
---------------------------------------------------------------------------------------------------------------
Infix_postfix_prefix_operations.java
-------------------------------------
      For this conversion and evaluations of Infix, Postfix and Prefix expressions we have created an Infix_postfix_prefix_operations.java file.
      This file contains 4 classes for the conversion and evaluation of infix, postfix and prefix expressions.
      Following is the description of each classes -->
-----------------------------------------------------------------------------
1) BasicMethods Class --> 
------------------------------
      This class contains all the basic methods needed for the infix, postfix and prefix conversion and their evaluation 
      such as isOperand() method, isOperator() method, strReverse() method and precedence() method. 
      The functionalities of these methods is fully explained in the Infix_postfix_prefix_operations.java file.
     
2) InfixPostfixPrefixConvertor Class -->
-------------------------------------------
      This class is a infix, Postfix, Prefix Convertor class i.e. it converts an infix expression to it's equivalent Postfix or Prefix Expression as required By the User.
      This class extends the Adapter Class to implement the ConvetorInterf Interface method. For More details visit the file.

3) ToInfix Class -->
-----------------------
      This class converts Postfix and Prefix expressions to its equivalent Infix Expression. 
      This class also extends the Adapter Class to implement the Convertor Interface. For more details visit the file.

 
4) PostfixPrefixEvaluation Class -->
---------------------------------------
      This is class for evaluating the Postfix and Prefix Expressions entered by the users. 
      This class also extends the Adapter Class to implement the Convertor Interface. For more details visit the file.
---------------------------------------------------------------------------------------------------------------------------------------
