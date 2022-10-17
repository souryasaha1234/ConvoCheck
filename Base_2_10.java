import java.util.Scanner;

class Base_2_10{
	
	/*Convert_To_Decimal(int Num, int base)
	  This method takes the number and base of the respective number as argument
	  then the number will be changed to Decimal number using its base and pass it to the caller function*/
	public static int Convert_To_Decimal(int Num, int base){
		int decimalNum = 0;//Initializing Decimal number with 0
		int	count = 0;//For counting the number of the digits 
		
		//Changing the number to Decimal
		while (Num != 0)//Run the loop till the Num Taken as input be zero
		{	
			decimalNum += (Num % 10) * (Math.pow(base, count));
			++count;
			Num /= 10;
		}
		return decimalNum;
	}
	
	/*Convert_To_Base_Y(int decimalNumber,int y)
	  This method takes the Decimal number generated in the Convert_to_Decimal function and base to which it is to be converted
	  of the respective number as argument
	  then the number will be changed to equivalent number(with the provided base) and pass it to the caller function*/
	public static int Convert_To_Base_Y(int decimalNumber,int y){
		int Number = 0, i = 1;

		while (decimalNumber != 0)
		{
			Number += (decimalNumber % y) * i;
			decimalNumber /= y;
			i *= 10;
		}

		return Number;

	}
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		//Taking the base of the number as input which is to be converted
		System.out.print("Enter the base of the number:");
		int x = input.nextInt();
		
		//Taking the number which is to be converted
		System.out.print("Enter the number:");
		int number = input.nextInt();
		
		//Taking the base to which the number is to be converted
		System.out.print("Enter the base of the number to which you want to convert the number:");
		int y = input.nextInt();
		
		if(x==y){
			System.out.println(number);
		}
		
		else{
			//Calling the function to change the number to binary
			int p = Convert_To_Decimal(number, x);
			
			//Getting the output
			System.out.println(Convert_To_Base_Y(p,y));
		}
		input.close();
	}
	
}