package com.wipro.implementations;

import com.wipro.facilities.AdapterClass;

public class BinaryAndGray extends AdapterClass {
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
