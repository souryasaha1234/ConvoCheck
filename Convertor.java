import java.util.Scanner;

//Interface of the Convo Check project
interface ConvertorInterf{
    void decToBin(int num);
    void binToDec(int num);
    void infixToPrefix(String expression);
    void prefixToInfix(String expression);
    void infixToPostfix(String expression);
    void postfixToInfix(String expression);
    int postfixEvaluation(String expression);
    int prefixEvaluation(String expression);
}

//Adapter class implementing the interface methods
abstract class AdapterClass implements ConvertorInterf{
    public void decToBin(int num){}
    public void binToDec(int num){}
    public void infixToPrefix(String expression){}
    public void prefixToInfix(String expression){}
    public void infixToPostfix(String expression){}
    public void postfixToInfix(String expression){}
    public int postfixEvaluation(String expression){
        return 0;
    }
    public int prefixEvaluation(String expression){
        return 0;
    }
}

//The Decimal to binary and Binary to Decimal Code Convertor Class
class DecimalBinaryConvertor extends AdapterClass{
    /*This class Converts a decimal number to it's equivalent binary 
     * And a binary number to it's equivalent decimal.
     * This class provides implementation to two public methods by extending the Adapter Class.
     * 1) decToBin() --> use to convert a decimal number to binary; Takes one parameter as integer type
     * 2) binToDec() --> use to convert a bianry number to decimal; Takes one parameter as integer type
     */
    //Decimal to Binary Conversion Method
    public void decToBin(int num){
        /*This method converts a decimal number to it's equivalent binary
         * This is done by implementing a Stack , which class is already defined in Stack.java file
         */
        StackOperations s = new StackOperations();  //Creating an object instance of Stack class
        if(num == 1 || num == 0){
            //Checks if the number is 1 or 0
            System.out.println("The equivalent binary number of the entered decimal number is : "+num);
            return;
        }
        //if the number is not one or zero then do the following
        int remainder = 0;
        /*This while loop runs until the number becomes 1
         * It divides the number by 2 and push the remainder in the Stack using the push function
         * And this process continues until the number becomes 1 by dividing it with two
         */
        while(num != 1){
            remainder = num%2;
            s.push(remainder);
            num = num/2;
        }
        s.push(num);//Lastly push 1 into the Stack
        //Printing of the result
        System.out.print("The equivalent binary number of the entered decimal number is : ");
        /*This while loop is actually for printing the result.
         * It just pops out the Stack elements until the Stack becomes empty
         */
        while(s.isEmpty() != 1){
            System.out.print(s.pop());
        }
        System.out.println();
        return;//Just returning the control to the caller
    }
    //Binary to decimal Conversion Method
    public void binToDec(int num){
        /*This method converts a binary number to it's equivalent decimal
         * This is done by pure mathematical conversion.
         * If a number taken is say N, we have to multiply it's digits with 2 raise to weight.
         * This weight Starts from 0 goes till the end of the digits.
         * For Example : We have to convert bianry number to it's equivalent bianry then,
         * 1     0     1
         * x     x     x
         * 2^2  2^1   2^0
         * (1x4)+(0x2)+(1x1) = 4+0+1 = 5 (Ans)
         */
        int weight = 0,digit = 0,decimalNum = 0;
        //double power = 0.0;
        if(num == 0){
            //Checks if the number is 0
            System.out.println("The decimal equivalent of the corresponding binary number is : "+decimalNum);
            return;
        }
        //If not then do the following
        /*This while loop runs until there are no digits to take
         * i.e. it the number becomes 0
         * it takes each digit from the left of the number , multiplies it with 2 raise to the power of weight
         * and add it and store the result into a variable name decimalNum.
         * After that the weight is incremented by 1.
         * And this process is repeated again.
         */
        while(num != 0){
            digit = num%10;
            decimalNum = decimalNum + digit*(int)Math.round(Math.pow(2,weight));
            weight++;
            num = num/10;
        }
        //Printing of the result
        System.out.println("The decimal equivalent of the corresponding binary number is : "+decimalNum);
        return;
    }
}


class Convertor{
    public static void main(String[] args) {
        ConvertorInterf convo = new DecimalBinaryConvertor();
        Scanner sc = new Scanner(System.in);
        int ch = 0;
        do{
            System.out.println("============================================================================");
            System.out.println("The Convertor Operations are as follows : ");
            System.out.println("1) Decimal to Binary Convertor.");
            System.out.println("2) Binary to Decimal Convertor.");
            System.out.println("3) Infix to Postfix Convertor.");
            System.out.println("4) Exit the program.");
            System.out.println("============================================================================");
            System.out.print("Enter which operation do you want to perform : ");
            int c = sc.nextInt();
            switch(c){
                case 1:
                    System.out.println("Enter the decimal number which you want to convert : ");
                    int decimalNum = sc.nextInt();
                    convo.decToBin(decimalNum);
                    break;
                case 2:
                    System.out.println("Enter the binary number which you want to convert : ");
                    int binaryNum = sc.nextInt();
                    convo.binToDec(binaryNum);
                    break;
                case 3:
                    System.out.println("Enter the infix expression : ");
                    String expression = sc.next();
                    InfixPostfixPrefixConvertor ippc = new InfixPostfixPrefixConvertor();
                    ippc.infixToPostfix(expression);
                    break;
                case 4:
                    System.out.println("Terminating from the program...");
                    ch = 1;
                    break;
                default:
                    System.out.println("Please enter a valid choice...");
                    break;
            }
        }while(ch != 1);
        sc.close();
    }
}
