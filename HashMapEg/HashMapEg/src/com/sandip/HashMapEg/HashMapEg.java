package com.sandip.HashMapEg;

import java.util.HashMap;
import java.util.Map;

public class HashMapEg {
	public static void test() {
		HashMap<People, String> resultDb = new HashMap<People, String>();
		People sandip = new People("Sandip", "Kumar", "Devnath");
		People ajay = new People("Ajay", "Kumar", "HN");
		People vidya = new People("Vidya", "", "Kumble");
		
		resultDb.put(sandip, "pass");
		resultDb.put(ajay, "fail");
		resultDb.put(vidya, "pass");
		resultDb.put(null, "pass"); // Trying to enter key as null, 
		                            // you can enter in HashMap, but not in Hashtable.
		
		
		// You can retrieve the null key
		for(Map.Entry<People, String> entry: resultDb.entrySet()) {
			System.out.println(entry.getKey() + " is " + entry.getValue());
		}

		// You can overwrite a data by put again with same key
		resultDb.put(vidya, "fail");
		resultDb.put(ajay, null); // You can add value as null
		
		// After modification
		System.out.println("\nAfter modification:");
		for(Map.Entry<People, String> entry: resultDb.entrySet()) {
			System.out.println(entry.getKey() + " is " + entry.getValue());
		}
	}

}
