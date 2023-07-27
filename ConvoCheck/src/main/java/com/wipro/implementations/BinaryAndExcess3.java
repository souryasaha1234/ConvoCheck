package com.wipro.implementations;

import com.wipro.facilities.AdapterClass;

public class BinaryAndExcess3 extends AdapterClass {
	public int binToExcess3(int bin){
        int a, dec;
        dec = BinaryAndGray.binaryToDecimal(bin);
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
        BinaryAndBCD b = new BinaryAndBCD();
        String excess = b.decToBCD(rev);
        int x = Integer.parseInt(excess);
        return x;
    }
    public int Excess3ToBin(int Excess){
        BinaryAndBCD b = new BinaryAndBCD();
        int dec, bin;
        bin = b.BCDToBin(Excess);
        // System.out.println("bin: " + bin);
        dec = BinaryAndGray.binaryToDecimal(bin);
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
        return BinaryAndGray.decimalToBinary(rev);
    }
}
