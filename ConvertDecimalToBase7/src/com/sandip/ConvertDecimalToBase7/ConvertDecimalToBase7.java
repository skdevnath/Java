package com.sandip.ConvertDecimalToBase7;
import java.util.HashMap;

public class ConvertDecimalToBase7 {
	public static String toBase7(int num) {
	   String retStr = new String("");	
	   int co = num;
	   int rem = 0;
	   boolean isNeg = (num < 0) ? true : false;
	   if (isNeg) {
		  num = - num; 
	   }
	   
	   while (co != 0) {
		  co = num/7; 
		  rem = num - co*7;
		  num = co;
		  retStr = rem + retStr;
	   }
	   
       if (retStr.contentEquals("")) {
       // if (retStr == "") {
           retStr = "0";
       }
       if (isNeg) {
    	   retStr = "-" + retStr; 
       }
	   return retStr;
	}
	
	public static String toBase7Atlassian(int num) {
		   String retStr = new String("");	
		   int co = num;
		   int rem = 0;

		   /* 
		    * Need to map: 
		    * base 10 0 1 2 3 4 5 6
		    * base 7 0 a t l s i N 
		    */
		   HashMap<Integer, Character > atMap = new HashMap<>();
		   atMap.put(10, '7');
		   atMap.put(0, '0');
		   atMap.put(1, 'a');
		   atMap.put(2, 't');
		   atMap.put(3, 'l');
		   atMap.put(4, 's');
		   atMap.put(5, 'i');
		   atMap.put(6, 'N');

		   boolean isNeg = (num < 0) ? true : false;
		   if (isNeg) {
			  num = - num; 
		   }
		   
		   while (co != 0) {
			  co = num/7; 
			  rem = num - co*7;
			  num = co;
			  retStr = atMap.get(rem) + retStr;
		   }
		   
	       if (retStr.contentEquals("")) {
	       // if (retStr == "") {
	           retStr = "0";
	       }
	       if (isNeg) {
	    	   retStr = "-" + retStr; 
	       }
		   return retStr;
		}
}
