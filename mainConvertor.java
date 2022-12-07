import java.util.Scanner;

class MainConvertor{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;
        char options;
        do{
            System.out.println("=============================================================");
            System.out.println("Convertor Operations");
            System.out.println("=============================================================");
            System.out.println("1) Infix Postfix and Prefix Conversions and Evaluations.");
            System.out.println("================================================================");
            System.out.println("2) Base 2 to 36 Conversions.");
            System.out.println("================================================================");
            System.out.println("3) BCD, Gray and Excess 3 Conversions.");
            System.out.println("================================================================");
            System.out.println("0) Exiting from the program.");
            System.out.println("================================================================");
            System.out.print("Enter which Convertor Operations would you like to perform : ");
            ch = sc.nextInt();

            switch(ch){
                case 0:
                    System.out.println("================================================================");
                    System.out.println("Terminating the program ....");
                    System.out.println("================================================================");
                    break;
                case 1:
                    do{
                        Scanner raj2 = new Scanner(System.in);
                        System.out.println("================================================================");
                        System.out.println("    a) Infix to Postfix Conversion.");
                        System.out.println("    b) Infix to Prefix Conversion.");
                        System.out.println("    c) Postfix to Infix Conversion.");
                        System.out.println("    d) Prefix to Infix Conversion.");
                        System.out.println("    e) Postfix Evaluation.");
                        System.out.println("    f) Prefix Evaluation.");
                        System.out.println("    g) Terminate this Operation.");
                        System.out.println("================================================================");
                        System.out.print("Enter which Infix Postfix Prefix Conversion Operation would you like to perform : ");
                        options = raj2.next().charAt(0);
                        String expression = "",output = "";
                        int evaluation;
                        ToInfix toInfix = new ToInfix();
                        Scanner raj = new Scanner(System.in);
                        switch (options) {
                            case 'g':
                                System.out.println("================================================================");
                                System.out.println("Terminating...");
                                System.out.println("================================================================");
                                break;
                            case 'a':
                                InfixPostfixPrefixConvertor ippc_a = new InfixPostfixPrefixConvertor();
                                System.out.println("**************Infix to Postfix Conversion**************");
                                System.out.println("-------------------------------------------------------");
                                System.out.println("Enter the Infix Expression you want to Convert : ");
                                expression = raj.nextLine();
                                output = ippc_a.infixToPostfix(expression);
                                System.out.println("The Postfix equivalent Expression is as follows : ");
                                System.out.println(output);
                                System.out.println();
                                //raj.close();
                                break;
                            case 'b':
                                InfixPostfixPrefixConvertor ippc_b = new InfixPostfixPrefixConvertor();
                                System.out.println("**************Infix to Prefix Conversion**************");
                                System.out.println("-------------------------------------------------------");
                                System.out.println("Enter the Infix Expression you want to Convert : ");
                                expression = raj.nextLine();
                                output = ippc_b.infixToPrefix(expression);
                                System.out.println("The Prefix equivalent Expression is as follows : ");
                                System.out.println(output);
                                System.out.println();
                                //raj.close();
                                break;
                            case 'c':
                                System.out.println("**************Postfix to Infix Conversion**************");
                                System.out.println("--------------------------------------------------------");
                                System.out.println("Enter the Postfix Expression you want to Convert : ");
                                expression = raj.nextLine();
                                output = toInfix.postfixToInfix(expression);
                                System.out.println("The Infix equivalent Expression is as follows : ");
                                System.out.println(output);
                                System.out.println();
                                //raj.close();
                                break;
                            case 'd':
                                System.out.println("**************Prefix to Infix Conversion**************");
                                System.out.println("-------------------------------------------------------");
                                System.out.println("Enter the Prefix Expression you want to Convert : ");
                                expression = raj.nextLine();
                                output = toInfix.prefixToInfix(expression);
                                System.out.println("The Infix equivalent Expression is as follows : ");
                                System.out.println(output);
                                System.out.println();
                                //raj.close();
                                break;
                            case 'e':
                                System.out.println("**************Postfix Evaluation**************");
                                System.out.println("-----------------------------------------------");
                                System.out.println("Enter the Postfix Expression you want to Convert : ");
                                expression = raj.nextLine();
                                PostfixPrefixEvaluation ppe_a = new PostfixPrefixEvaluation();
                                evaluation = ppe_a.postfixEvaluation(expression);
                                System.out.println("The Evaluation of the Postfix Expression is : ");
                                System.out.println(evaluation);
                                System.out.println();
                                //raj.close();
                                break;
                            case 'f':
                                System.out.println("**************Prefix Evaluation**************");
                                System.out.println("----------------------------------------------");
                                System.out.println("Enter the Prefix Expression you want to Convert : ");
                                expression = raj.nextLine();
                                PostfixPrefixEvaluation ppe_b = new PostfixPrefixEvaluation();
                                evaluation = ppe_b.prefixEvaluation(expression);
                                System.out.println("The Evaluation of the Prefix Expression is : ");
                                System.out.println(evaluation);
                                System.out.println();
                                //raj.close();
                                break;
                            default:
                                System.out.println("================================================================");
                                System.out.println("Please enter a valid character...");
                                System.out.println("================================================================");
                            
                        }
                        //raj2.close();
                        /*if(options!="g"){
                            options = null;
                        }*/
                    }while(options!='g');
                    break;
                case 2:
                    Base_2_to_36 object = new Base_2_to_36();
                    int x,y;
                    String number;
                    Scanner sourya = new Scanner(System.in);
                    System.out.println("Enter the number : ");
                    number = sourya.nextLine();
                    System.out.println("Enter the base of the entered number : ");
                    x = sourya.nextInt();
                    System.out.println("Enter the base to which it will be Converted : ");
                    y = sourya.nextInt();
                    String convert = object.Convert(number, x, y);
                    System.out.println("The number "+number+" of base "+x+" converted to base " + y + " becomes : "+convert);
                    System.out.println();
                    //sourya.close();
                    break;
                case 3:
                    do{
                        Scanner tojo1 = new Scanner(System.in);
                        System.out.println("================================================================");
                        System.out.println("    a) Binary to Gray Conversion.");
                        System.out.println("    b) Gray to Binary Conversion.");
                        System.out.println("    c) Decimal to BCD Conversion.");
                        System.out.println("    d) BCD to binary Conversion.");
                        System.out.println("    e) Binary to Excess-3 Conversion.");
                        System.out.println("    f) Excess-3 to Binary Conversion.");
                        System.out.println("    g) GRAY to Excess-3 Conversion.");
                        System.out.println("    h) Excess-3 to GRAY Conversion.");
                        System.out.println("    i) Terminate this operation.");
                        System.out.println("================================================================");
                        System.out.print("Enter which Code Conversion operation would you like to perform : ");
                        int bin_num,gray,dec,bcd,Ex;
                        String bcd_str;
                        ch = tojo1.next().charAt(0);
                        Scanner tojo = new Scanner(System.in);
                        binaryAndGray binge = new binaryAndGray();
                        binaryAndBCD bincd = new binaryAndBCD();
                        binaryAndExcess3 binEx = new binaryAndExcess3();
                        grayAndExcess grEx = new grayAndExcess();
                        switch(ch){
                            case 'i':
                                System.out.println("================================================================");
                                System.out.println("Terminating the operation...");
                                System.out.println("================================================================");
                                break;
                            case 'a':
                                System.out.println("**************Binary to GRAY Conversion**************");
                                System.out.println("-------------------------------------------------------");
                                System.out.print("Enter a binary number: ");
                                bin_num =  tojo.nextInt();
                                gray = binge.binToGray(bin_num);
                                System.out.println("Gray code: " + gray);
                                System.out.println();
                                break;
                            
                            case 'b':
                                System.out.println("**************GRAY to Binary Conversion**************");
                                System.out.println("------------------------------------------------------");
                                System.out.print("Enter a GRAY number: ");
                                gray =  tojo.nextInt();
                                bin_num = binge.grayToBin(gray);
                                System.out.println("Equivalent Binary: " + bin_num);
                                System.out.println();
                                break;
                            case 'c':
                                System.out.println("**************Decimal to BCD Conversion**************");
                                System.out.println("-------------------------------------------------------");
                                System.out.print("Enter a Decimal number:");
                                dec = tojo.nextInt();
                                bcd_str = bincd.decToBCD(dec);
                                System.out.println("The BCD is: " + bcd_str );
                                System.out.println();
                                break;
                            case 'd':
                                System.out.println("**************BCD to Binary Conversion**************");
                                System.out.println("------------------------------------------------------");
                                System.out.print("Enter a BCD:");
                                bcd = tojo.nextInt();
                                bin_num = bincd.BCDToBin(bcd);
                                System.out.println("The Corresponding binary is: " + bin_num);
                                System.out.println();
                                break;
                            case 'e':
                                System.out.println("**************Binary to Excess-3 Conversion**************");
                                System.out.println("-----------------------------------------------------------");
                                System.out.print("Enter a Binary number:");
                                bin_num = tojo.nextInt();
                                Ex = binEx.binToExcess3(bin_num);
                                System.out.println("The corresponding Excess-3 is: "+ Ex);
                                System.out.println();
                                break;
                            case 'f':
                                System.out.println("**************Excess-3 to Binary Conversion**************");
                                System.out.println("----------------------------------------------------------");
                                System.out.print("Enter the Excess-3 Code:");
                                Ex = tojo.nextInt();
                                bin_num = binEx.Excess3ToBin(Ex);
                                System.out.println("The corresponding binary number is: "+bin_num);
                                System.out.println();
                                break;
                            case 'g':
                                System.out.println("**************GRAY to Excess-3 Conversion**************");
                                System.out.println("--------------------------------------------------------");
                                System.out.print("Enter a GRAY code:");
                                gray = tojo.nextInt();
                                Ex = grEx.grayToExcess3(gray);
                                System.out.println("The Corresponding Excess-3 Code is: "+ Ex);
                                System.out.println();
                                break;
                            case 'h':
                                System.out.println("**************Excess-3 to GRAY Conversion**************");
                                System.out.println("----------------------------------------------------------");
                                System.out.print("Enter a Excess-3 code:");
                                Ex = tojo.nextInt();
                                gray = grEx.Excess3ToGray(Ex);
                                System.out.println("The Corresponding GRAY Code is: "+ gray);
                                System.out.println();
                                break;
                            default: 
                                System.out.println("================================================================");
                                System.out.println("Please Enter some valid input...");
                                System.out.println("================================================================");
                            }
                    }while(ch!='i');
                default:
                    System.out.println("================================================================");
                    System.out.println("Please Enter some valid input..."); 
                    System.out.println("================================================================");
            }
        }while(ch!=0);
        //sc.close();
        sc.close();
    }
}