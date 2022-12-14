import java.util.Scanner;
/*
This is another part of the project Code Convertor where the BCD, Gray and Excess 3 codes are converted.
Here we have used 4 classes named 
    1. binaryAndGray Class
       =====================
       The primary motive of this class isto change a binary number to it's equivalent Gray code and 
       a Gray code to it's equivalent Binary number with the help of decimal number system.
       For this task to accomplish we have implemented 4 methods where two are from the Convertor interface in the Class as follows -->

        a) static int binaryToDecimal(int n) --> coverts binary integer to decemal integer.It's a Static method.
                The return type of this method is int. It takes one binary integer as a parameter.

        b) static int decimalToBinary(int N) --> coverts decemal integer to binary integer.It's also a 
                Static method. The return type of this method is also int. It takes one decimal integer as a 
                parameter.

        c) public int binToGray(int bin) --> coverts binary integer to gray code integer.It is a public method
                with int return type and takes a binary integer as a parameter. This method of the Convertor Interface
                is being implemented here.

        d) public int grayToBin(int gray) --> coverts gray code integer to binary integer. It is a public method
                with int return type and takes a gray code integer as a parameter. This method of the Convertor Interface
                is being implemented here.
    
    2.  binaryAndBCD Class
        ====================
        This Class is used to Convert a Decimal number to it's equivalent BCD and a BCD code to it's 
        equivalent Binary number.
        For this we have implemented the two methods of the Convertor Interface as follows -->

        a) public String decToBCD(int dec) --> coverts decimal integer to BCD String.It is public method
                with String return type and takes a decimal integer as an argument.

        b) public int BCDToBin(int bcd) --> coverts BCD integer to binary integer. It is a public method
                with int return type and takes a BCD integer as a parameter.
    
    3. binaryAndExcess3 Class
        ========================
        This Class is used to convert a Binary Number to it's equivalent Excess 3 Code and Vice versa
        For this we have implemented 2 methods of the Convertor Interface as follows -->

        a) public int binToExcess3(int bin) --> coverts binary integer to Excess3 integer. It is a public method
                with int return type and takes a Binary integer as a parameter.

        b) public int Excess3ToBin(int Excess) --> coverts Excess3 integer to binary integer. It is a public method
                with int return type and takes a Excess 3 integer as a parameter.
    
    4. grayAndExcess Class
        ======================
        This Class is used to convert a Gray Code Number to it's equivalent Excess 3 Code and Vice versa
        For this we have implemented 2 methods of the Convertor Interface as follows -->

        a) public int grayToExcess3(int gray) --> coverts gray code integer to Excess3 integer. It is a public method
                with int return type and takes a Gray integer as a parameter.

        b) public int Excess3ToGray(int excess) --> coverts Excess3 integer to gray code integer. It is a public method
                with int return type and takes a Excess 3 integer as a parameter.
 */

class binaryAndGray extends AdapterClass{ //code checked and okay
    static int binaryToDecimal(int n){
        int dec = 0;
        int base = 1;
        int temp = n;
        while (temp > 0) {
            int lastdigit = temp % 10;
            temp = temp / 10;
            dec += lastdigit * base;
            base = base * 2;
        }
        return dec;
    }
    static int decimalToBinary(int N){
        int B_Number = 0;
        int cnt = 0; 
        while (N != 0) { 
            int rem = N % 2; 
            double c = Math.pow(10, cnt); 
            B_Number += rem * c; 
            N /= 2;   
            // Count used to store exponent value 
            cnt++; 
        } 
        return B_Number; 
    } 
    public int binToGray(int bin){
        int gray;
        //convert binary into decimal
        int dec = binaryToDecimal(bin);
        gray = dec ^ (dec >> 1); // saving the gray code in decimal
        //returning binary form of the gray code
        return decimalToBinary(gray);
    }
    private char flip(char c){
        return (c == '0') ? '1' : '0';
    }
    public int grayToBin(int gray){
        String bin = "", gray_s = Integer.toString(gray);// converting gray into string
        bin += gray_s.charAt(0); //MSB is same
        for(int i=1; i<gray_s.length(); i++){
            //if curr bit is 0 add the prev bit
            if(gray_s.charAt(i) == '0')
                bin += bin.charAt(i-1);
            else
                bin += flip(bin.charAt(i-1));
        }
        return Integer.parseInt(bin);
    }
}

class binaryAndBCD extends AdapterClass{ ////code checked and oka
    public String decToBCD(int dec){
        String str = "";
        if(dec == 0){ //base case
            str += "0000";
        }
        int rev=0;//for storing reverse of dec
        while(dec>0){ // reversing dec
            rev = rev*10 + (dec%10);
            dec /= 10;
        } 
        while(rev>0){
            String b = Integer.toBinaryString(rev%10);
            
            // making every binary in 4 bit (e.g. 0000)
            b = String.format("%04d", Integer.parseInt(b));
            str = str + b;
            rev /= 10;
        }
        // int x = Integer.parseInt(str);//conversion of string to int to return as a integer
        return str;
    }
    
    public int BCDToBin(int bcd){
        String s = Integer.toString(bcd);
        //length of the string
        int l = s.length(), num = 0, mul = 1, sum = 0;

        // If the length of given BCD is not divisible by 4
        for(int i = l%4 - 1; i >= 0; i--){
            sum += (s.charAt(i) - '0') * mul;
            mul *= 2;
        }
        num = sum;
        sum = 0;
        mul = (int)Math.pow(2, 3);
        int ctr = 0;
        // If the length of given BCD is divisible by 4
        for(int i = l % 4; i < l; i++){
            ctr++;
            sum += (s.charAt(i) - '0') * mul;
            mul /= 2;
            if (ctr == 4){
                num = num * 10 + sum;
                sum = 0;
                mul = (int)Math.pow(2, 3);
                ctr = 0;
            }
        }
        
        // Convert decimal to binary
        String ans = "";
        while (num > 0){
            ans += (char)(num % 2 + '0');
            num /= 2;
        }     
        StringBuilder ans1 = new StringBuilder();
        // Append a string into StringBuilder input1
        ans1.append(ans);
        // Reverse StringBuilder input1
        ans = ans1.reverse().toString();
        return Integer.parseInt(ans);
    }
}

class binaryAndExcess3 extends AdapterClass{
    public int binToExcess3(int bin){
        int a, dec;
        dec = binaryAndGray.binaryToDecimal(bin);
        // System.out.println(dec);
        int temp=dec, count=0, rev=0;
        //adding each digit of dec with 3 and saving in count variable
        while(temp != 0){
            a = temp%10;
            count = count*10 + a + 3;
            temp /= 10;
        }
        //reversing the number as due to addition number got reversed
        temp=count;
        while(temp != 0){
            int remainder = temp % 10;
            rev = rev * 10 + remainder;
            temp /= 10;
        }
        // System.out.println(rev);
        binaryAndBCD b = new binaryAndBCD();
        String excess = b.decToBCD(rev);
        int x = Integer.parseInt(excess);
        return x;
    }
    public int Excess3ToBin(int Excess){
        binaryAndBCD b = new binaryAndBCD();
        int dec, bin;
        bin = b.BCDToBin(Excess);
        // System.out.println("bin: " + bin);
        dec = binaryAndGray.binaryToDecimal(bin);
        // System.out.println("dec: " dec);
        int temp=dec, count=0, rev=0, a;
        //subtracting 3 from each digit of dec and saving in count variable
        while(temp != 0){
            a = temp%10;
            count = count*10 + a - 3;
            temp /= 10;
        }
        //reversing the number as due to addition number got reversed and saving in rev variable
        temp=count;
        while(temp != 0){
            int remainder = temp % 10;
            rev = rev * 10 + remainder;
            temp /= 10;
        }
        return binaryAndGray.decimalToBinary(rev);
    }
}

class grayAndExcess extends AdapterClass{
    public int grayToExcess3(int gray){
        binaryAndGray g = new binaryAndGray();
        int bin = g.grayToBin(gray);
        binaryAndExcess3 e = new binaryAndExcess3();
        int excess = e.binToExcess3(bin);
        return excess;
    }
    public int Excess3ToGray(int excess){
        binaryAndExcess3 e = new binaryAndExcess3();
        int bin = e.Excess3ToBin(excess);
        binaryAndGray g = new binaryAndGray();
        int gray = g.binToGray(bin);
        return gray;
    }
}

class Test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bin_num, bin, dec, bcd;
        //input binary number
        System.out.print("Enter a binary number: ");
        bin_num =  sc.nextInt();
        

        // passing the binary and getting gray code in binary
        binaryAndGray b = new binaryAndGray();
        int gray = b.binToGray(bin_num);//return type = int
        System.out.println("Gray code: " + gray); //printing binary form of the gray code
        
        
        dec =  binaryAndGray.binaryToDecimal(bin_num);
        // passing the decemal number and getting BCD code in binary
        binaryAndBCD bb = new binaryAndBCD();
        String bcd_str =bb.decToBCD(dec);//return type = String
        System.out.println("BCD code:" + bcd_str); //printing BCD code
    
        
        // passing the binary and getting Excess-3 code in binary
        binaryAndExcess3 be = new binaryAndExcess3();
        int excess3 = be.binToExcess3(bin_num);//return type = int
        System.out.println("Excess-3 code: " + excess3); //printing binary form of the BCD code
        

        // passing the gray and getting code in binary
        //input gray code
        System.out.print("Enter a gray code: ");
        gray =  sc.nextInt();
        bin =b.grayToBin(gray);//return type = int
        System.out.println("Binary number of that: " + bin); //printing binary form of the gray code
        
        
        // passing the bcd and getting decimal
        // input bcd code
        System.out.print("Enter a bcd: ");
        bcd =  sc.nextInt();
        bin =bb.BCDToBin(bcd);//return type = int and it is returning a binary string
        dec = binaryAndGray.binaryToDecimal(bin);
        System.out.println("Decimal number of that: " + dec); //printing binary form of the BCD
        
        
        // passing the Excess-3 and getting code in binary
        //input Excess-3 code
        System.out.print("Enter a Excess-3 code: ");
        excess3 =  sc.nextInt();
        bin =be.Excess3ToBin(excess3);//return type = int
        System.out.println("Binary number of that: " + bin); //printing binary form of the gray code
        
        
        //psssing gray code and getting exces3 code
        //input gray code
        System.out.print("Enter a gray code: ");
        gray =  sc.nextInt();
        grayAndExcess ge = new grayAndExcess();
        excess3 = ge.grayToExcess3(gray); //return type = int
        System.out.println("Excess3 of that: " + excess3); //printing the returned excess3 code
        
        
        // passing the Excess-3 and getting gray code
        //input Excess-3 code
        System.out.print("Enter a Excess-3 code: ");
        excess3 =  sc.nextInt();
        gray = ge.Excess3ToGray(excess3);
        System.out.println("Gray code of that: " + gray); //printing the returned gray code    
        
        sc.close();
    }
}