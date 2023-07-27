package com.wipro.implementations;

import com.wipro.facilities.AdapterClass;

public class BinaryAndBCD extends AdapterClass {
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
