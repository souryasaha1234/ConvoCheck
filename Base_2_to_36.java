import java.util.Scanner;

public class Base_2_to_36
{
	/*This function will at first convert the String num to decimal and then convert it to the equivalent base y number
	  so we have used decimal nnumber as medium to convert base x number to the quivalent base y number...*/
	public static String Convert(String num,int x,int y){
		
		//A digits string is fixed so that the index is to be compared and get the number such as A - 10,B - 11,C-12 and so on... 
		String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int decimal=0, i, rem;
        String output = "";
		
		//If someone take the input in Lower Case letters thwn this will convert all those to the Upper case letters...
		 num = num.toUpperCase();
        
		//This loop will convert the base x number to the equivalent decimal number...
        for (i = 0; i < num.length(); i++)
        {
            char c = num.charAt(i);//The character at index i is stored in variable c...
            int d = digits.indexOf(c);//The character stored at c will then be compared to the digits String to get the respective number...
            decimal = x*decimal + d;
        }
		
		//In this loop the decimal number obtained from the above loop is then convert it to get the equivalent base y number... 
		while(decimal!=0)
		{
			rem = decimal%y;
			if(rem<10)
				//We know that 0 which is the first non negative integer character has the ASCII value 48 so we added 48 to get the respective ASCII character...
				rem = rem+48;
			 else
				//We know that A which is the first Alphabet character has the ASCII value 65 so we added 55 to get the respective ASCII character...
				rem = rem+55;//
			output = (char)rem + output ;
			i++;
			decimal = decimal/y;
        }
	//return the string of the output
	return output;
	}
	public static void main(String[] args)
   {
	   
		int x,y;
		
		Scanner s = new Scanner(System.in);
		
		//Here x is the base in which the number is taken as input...
		System.out.print("Enter the base of the number that is to be converted: ");
		x = s.nextInt();
		
		String hexdec_num;
        Scanner in = new Scanner(System.in);
		
		//The Number that is to be converted from base x to base y in taken as input as a String...
        System.out.print("Input a number: ");
        hexdec_num = in.nextLine();
		
		//Here y is the base to which the number is to be converted...
		System.out.print("Enter the base to which the number is to be converted: ");
		y = s.nextInt();
		
		//The function is called to convert and print the output...
		System.out.println(Convert(hexdec_num,x,y));
   }
}