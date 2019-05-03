package com.sandip.ConvertDecimalToBase7;

/* 
 * Given an integer, return its base 7 string representation.
 *  Example 1:
 *  Input: 100
 *  Output: "202"
 *  Example 2:
 *  Input: -7
 *  Output: "-10" 
 * 
 */

/*
 * Little different question in Atlsin 
 * Complete the function that takes an integer as its argument and returns the encoded string in base 7 using the following encoding rule:
 *  base 10 0 1 2 3 4 5 6
 *  base 7 0 a t l s i N
 *  Sample Input 1
 *   7
 *  Sample Output 1
 *   a0
 */

public class ConvertTo7baseMainMethod {
	public static void main(String args[]) {
		int in = 8;
		String retStr;
	    retStr = ConvertDecimalToBase7.toBase7(in);
		System.out.println("Base 7 of " + in + " is:" + retStr);
		
		
		in = 7;
	    retStr = ConvertDecimalToBase7.toBase7Atlassian(in);
		System.out.println("Base 7 of " + in + " is:" + retStr);
	}

}
