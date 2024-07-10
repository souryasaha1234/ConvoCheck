# ConvoCheck

The Code Convertor Web-App

## Video demonstration

Visit 👉 [watch](https://youtu.be/uz7MAlkPEcQ?si=ChzuoANIYXdKpbFP)

# Features Offerred :-

We are going to design a code convertor which will convert the any codes/numbers into what the user wants to.
i.e from any base to any base.
Suppose an user wants to convert a base 6 number to a base 10 number ... or any Binary number to it's equivalent Hexadecimal Form.

This web app also convert some codes to it's any equivalent forms, such as follows : 1) Gray Code 2) Binary Coded Decimals(BCD) 3) Excess-3 Code

There are also some Conversions and evaluations based on expressions we use in our Data Structures such as follows: 1) Infix Expression 2) Postfix Expression 3) Prefix Expression

**We have also added an unique feature which is a LOGIN page**

      Any user can create his/her account with our web app and do any conversions as the user wants to.
      All the conversions history will be saved securely and when the user again logins into our app
      they will get some suggesstions of conversions based on their conversion history
      and can also retreive their past conversions.(to be implemented)

---

## Building Blocks of the Website

ConvoCheck is a JAVA based Web-App for some day-to-day conversions mentioned above.

## Technologies and Languages Used in this Website

      1) JAVA
      2) HTML
      3) CSS
      4) JAVASCRIPT
      5) JAVA SERVELET
      6) JDBC
      7) JSP

---

## Java Code Structure :-

      We have 7 packages in the Java Resources(src/main/java/)

      1) com.wipro.bean -> Contains the Accounts class of the User i.e. the Email,UserName and PassWord.

      2) com.wipro.dao -> This is a DAO layer which is used for accessing or gaining connection with the Database(for Database Connectivity). This Layer contains an Interface where there are two methods for Login and Sign-up for the User. This layer also contains an Implementation Class which implements the methods of the DAO Interface.

      3) com.wipro.service -> This is a Service which is used for establishing communication between the Servlets and the DAO layer. This layer contains and Interface and an Implementation class of it. The Interface contains the methods which is used for communicating between the DAO layer and Servlet layer and the Implementation class contains the Implementation of the Interface methods.

      4) com.wipro.factory -> This a factory layer which contains all the Factory Classes used for establishing Connection with the Database and for Object Creation of Service and DAO layers.
      It contains 3 classes
            a) AccountsDaoFactory.class -> Used for Creating Object of the DAO layer.
            b) AccountsServiceFactory.class -> Used for Creating Object of the Service Layer.
            c) ConnectionFactory.class -> Used for Creating the Connection with the Database and Generating the Connection Object which will be used by the DAO layer for communication with the Database.

      5) com.wipro.facilities -> This Package contains the Convertor Interface which has all the Methods/Services/Facilities which has to be Implemented. And it also contains an Adapter Class which gives empty implementations to the methods of the Convertor Interface.

      6) com.wipro.implementations -> This package contains all the Implementation of the Convertor Interface methods by extending the Adapter Class in com.wipro.facilities package. This package contains 10 Classes :
            a) Base_2_to_36 -> In this java file we have created a class called Base_2_to_36 which extends the Adapter class and Implements Convert() method of the ConvertorInterf Interface. Convert() method --> This method is designed to convert any base number to any base provided the bases must be between 2 - 36. To get a Detailed Analysis of this method please check the .java file.
            b) BasicMethods_Evaluation -> This Class has all the basic methods which are frequently used for Evaluation of different Expressions.
            c) BasicMethods -> This Class has all the Basic methods which are frequently used for Converting different Expressions.
            d) BinaryAndBCD -> This Class is used to Convert a Decimal number to it's equivalent BCD and a BCD code to it's equivalent Binary form.
            e) BinaryAndExcess3 -> This class is used to convert a Binary Code to it's Equivalent Excess-3 Code and an Excess-3 code to it's Equivalent Binary Form.
            f) BinaryAndGray -> The primary motive of this class isto change a binary number to it's equivalent Gray code and a Gray code to it's equivalent Binary number with the help of decimal number system.
            g) GrayAndExcess -> This Class is used to convert a Gray Code Number to it's equivalent Excess 3 Code and Vice versa.
            h) InfixPostfixPrefixConvertor -> This class is a infix, Postfix, Prefix Convertor class i.e. it converts an infix expression to it's equivalent Postfix or Prefix Expression as required By the User. This class extends the Adapter Class to implement the ConvetorInterf Interface method.
            i) ToInfix -> This class converts Postfix and Prefix expressions to its equivalent Infix Expression. This class also extends the Adapter Class to implement the Convertor Interface.
            j) PostfixPrefixEvaluation -> This is class for evaluating the Postfix and Prefix Expressions entered by the users. This class also extends the Adapter Class to implement the Convertor Interface.

      7) com.wipro.servlets -> This Package Contains all the Servlets to be used in the Application. There are total of 8 Servlets in the Application.
            a) StartServlet -> This is the StartUp Servlet which Starts the Application by Establishing the Connection with the Database and Generating the Connection Object.
            b) SignUpServlet -> This Servlet is called when the user wants to Sign-up. This Servlet Creates an User Account (If the details are properly entered) in the database.
            c) LogInServlet -> This Servlet Logs in to the user account iff the account exists and the user credentials are entered correctly.
            d) LogOutServlet -> This Servlet is used for Logging Out from the Application.
            e) EquationEvaluationServlet -> This Servlet is used for retrieving the input from the form data and Generating the equation evaluated result and sending it to the jsp page for display
            f) EquationConversionServlet -> This Servlet is used for Converting the Infix, Postfix and Prefix Expressions and displaying the result of the Conversions in the jsp page.
            g) CodeConversionServlet -> This Servlet is used for Converting the BCD, Gray and Excess-3 codes and display the result of them in the jsp page.
            h) BaseConversionServlet -> This Servlet is used for Converting a number of any base to any base and display the result of the Conversion.

---

## HTML/CSS/JS/JSP Directory Structure

      Inside the Webapp Folder we have all the JSP, CSS, JS files.
      a) index.jsp -> This is the HomePage or the index page of the Application .
      b) about.jsp -> For the About page of the Application.
      c) login.jsp -> This is the Login and Sign-Up page where the user can Login / Sign-up in thier accounts.
      d) baseConversion.jsp -> This is the page where we can convert any number of any base to any base.
      e) codeConversion.jsp -> This is the page where we can convert all the BCD, Gray and Excess-3 codes.
      f) equationConversion.jsp -> This is the page where we can Convert any Infix, Postfix and Prefix Expression/Equations.
      g) evaluation.jsp -> In this page we can perform Evaluation of Postfix and Prefix Expressions.
      h) style.css -> Contains all the styles of the application.
      i) script.js -> Contains all the Scripts of the application.

---

## WEB-INF Folder

      In this folder we have our web.xml file which contains the URL configurations of all the jsp files and Servlets. It also contains all the Welcome file configurations of the application.

---

## Running the Application

      1) Clone the application from the Git Repository.
      2) Ensure these following softwares are installed prior running :
            a) Eclipse IDE
            b) Tomcat Server version 9.0
            c) MySQL
            d) Java 8 or higher
      3) Open the Project in the Eclipse IDE.
      4) Configure Tomcat Server with the IDE.
      5) Make sure that in the "lib" folder of the Tomcat Server there is MySQL connector.jar file. If not then add it.
      6) Create a Database named ConvoCheck in your MySQL Database.
      7) Create a Table within the database named Accounts with fields as Email_Address(Primary Key),Username,Password.
      8) Change the hostname and password in the ConnectionFactory.java file to your own set hostname and password in MySQL.
      9) Run the Application by running the Tomcat Server.

---
