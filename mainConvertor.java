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
            System.out.println("--------------------------------------------------");
            
            System.out.println("================================================================");
            System.out.println("2) Base 2 to 36 Conversions.");
            System.out.println("================================================================");
            System.out.println("3) BCD, Gray and Excess 3 Conversions.");
            System.out.println("-------------------------------------------------");
            System.out.println("    a) BCD to Gray Conversion.");
            System.out.println("    b) BCD to Excess3 Conversion.");
            System.out.println("    c) Gray to BCD Conversion.");
            System.out.println("    d) Excess3 to BCD Conversion.");
            System.out.println("    e) Gray to Excess3 Conversion.");
            System.out.println("    f) Excess3 to Gray Conversion.");
            System.out.println("================================================================");
            System.out.println("0) Exiting from the program.");
            System.out.println("Enter which Convertor Operations would you like to perform : ");
            ch = sc.nextInt();

            switch(ch){
                case 0:
                    System.out.println("Terminating the program ....");
                    break;
                case 1:
                    do{
                        Scanner raj2 = new Scanner(System.in);
                        System.out.println("    a) Infix to Postfix Conversion.");
                        System.out.println("    b) Infix to Prefix Conversion.");
                        System.out.println("    c) Postfix to Infix Conversion.");
                        System.out.println("    d) Prefix to Infix Conversion.");
                        System.out.println("    e) Postfix Evaluation.");
                        System.out.println("    f) Prefix Evaluation.");
                        System.out.println("    g) Terminate this Operation.");
                        System.out.println("================================================================");
                        System.out.println("Enter which Infix Postfix Prefix Conversion Operation would you like to perform : ");
                        options = raj2.next().charAt(0);
                        String expression = "",output = "";
                        int evaluation;
                        System.out.println("================================================================");
                        ToInfix toInfix = new ToInfix();
                        Scanner raj = new Scanner(System.in);
                        switch (options) {
                            case 'g':
                                System.out.println("Terminating...");
                                break;
                            case 'a':
                                InfixPostfixPrefixConvertor ippc_a = new InfixPostfixPrefixConvertor();
                                System.out.println("Infix to Postfix Conversion.");
                                System.out.println("------------------------------------");
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
                                System.out.println("Infix to Prefix Conversion.");
                                System.out.println("------------------------------------");
                                System.out.println("Enter the Infix Expression you want to Convert : ");
                                expression = raj.nextLine();
                                output = ippc_b.infixToPrefix(expression);
                                System.out.println("The Prefix equivalent Expression is as follows : ");
                                System.out.println(output);
                                System.out.println();
                                //raj.close();
                                break;
                            case 'c':
                                System.out.println("Postfix to Infix Conversion.");
                                System.out.println("------------------------------------");
                                System.out.println("Enter the Postfix Expression you want to Convert : ");
                                expression = raj.nextLine();
                                output = toInfix.postfixToInfix(expression);
                                System.out.println("The Infix equivalent Expression is as follows : ");
                                System.out.println(output);
                                System.out.println();
                                //raj.close();
                                break;
                            case 'd':
                                System.out.println("Prefix to Infix Conversion.");
                                System.out.println("------------------------------------");
                                System.out.println("Enter the Prefix Expression you want to Convert : ");
                                expression = raj.nextLine();
                                output = toInfix.prefixToInfix(expression);
                                System.out.println("The Infix equivalent Expression is as follows : ");
                                System.out.println(output);
                                System.out.println();
                                //raj.close();
                                break;
                            case 'e':
                                System.out.println("Postfix Evaluation.");
                                System.out.println("------------------------------------");
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
                                System.out.println("Prefix Evaluation.");
                                System.out.println("------------------------------------");
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
                                System.out.println("Please enter a valid character...");
                            
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
                    
            }
        }while(ch!=0);
        //sc.close();
        sc.close();
    }
}