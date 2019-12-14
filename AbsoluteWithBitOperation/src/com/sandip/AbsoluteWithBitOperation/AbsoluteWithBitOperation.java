package com.sandip.AbsoluteWithBitOperation;

public class AbsoluteWithBitOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		absolute(-12);
		absolute(13);
	}
	
	public static int  absolute(int in) {
		int mask = in >> (Integer.SIZE - 1); // All 1s if -ve number, all 0s if +ve number
		// If in is unsigned then extra once will not come, which is only possible in c

		System.out.printf("mask = 0x%08x\n", mask);
		int absoluteValue = (in + mask) ^ mask;
		System.out.printf("absoluteValue = %d\n", absoluteValue);
		return absoluteValue;
	}

}
