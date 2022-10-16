// Java program to convert
// Hexadecimal number to Binary

class Improve {

	// function to convert
	// Hexadecimal to Binary Number
	static void HexToBin(char hexdec[])
	{
		int i = 0;

		while (hexdec[i] != '\u0000') {

			switch (hexdec[i]) {
			case '0':
				System.out.print("0000");
				break;
			case '1':
				System.out.print("0001");
				break;
			case '2':
				System.out.print("0010");
				break;
			case '3':
				System.out.print("0011");
				break;
			case '4':
				System.out.print("0100");
				break;
			case '5':
				System.out.print("0101");
				break;
			case '6':
				System.out.print("0110");
				break;
			case '7':
				System.out.print("0111");
				break;
			case '8':
				System.out.print("1000");
				break;
			case '9':
				System.out.print("1001");
				break;
			case 'A':
			case 'a':
				System.out.print("1010");
				break;
			case 'B':
			case 'b':
				System.out.print("1011");
				break;
			case 'C':
			case 'c':
				System.out.print("1100");
				break;
			case 'D':
			case 'd':
				System.out.print("1101");
				break;
			case 'E':
			case 'e':
				System.out.print("1110");
				break;
			case 'F':
			case 'f':
				System.out.print("1111");
				break;
			default:
				System.out.print("\nInvalid hexadecimal digit " + hexdec[i]);
			}
			i++;
		}
	}

	// Driver code
	public static void main(String args[])
	{
		// Get the Hexadecimal number
		String s = "1AC5" ;
		char hexdec[] = new char[100] ;
			hexdec = s.toCharArray() ;

		// Convert HexaDecimal to Binary
		System.out.print("\nEquivalent Binary value is : ");
		try{
			HexToBin(hexdec);
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.print("");
		}

	}
	// This code is contributed by ANKITRAI1
}
