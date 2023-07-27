package com.wipro.implementations;

import com.wipro.facilities.AdapterClass;

public class GrayAndExcess extends AdapterClass {
	public int grayToExcess3(int gray){
        BinaryAndGray g = new BinaryAndGray();
        int bin = g.grayToBin(gray);
        BinaryAndExcess3 e = new BinaryAndExcess3();
        int excess = e.binToExcess3(bin);
        return excess;
    }
    public int Excess3ToGray(int excess){
        BinaryAndExcess3 e = new BinaryAndExcess3();
        int bin = e.Excess3ToBin(excess);
        BinaryAndGray g = new BinaryAndGray();
        int gray = g.binToGray(bin);
        return gray;
    }
}
