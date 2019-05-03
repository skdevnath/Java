package com.sandip.HashTableEg;

import java.util.Hashtable;
import java.util.Map;


public class HashTableEg {
	public static void test() {
		Hashtable<People, String> peopleDb = new Hashtable<People, String>();
		People sandip = new People("Sandip", "Kumar", "Devnath");
		People vidya = new People("Vidya", "", "Kumble");
		People raj = new People("Raj", "Kumar", "");
		
		peopleDb.put(sandip, "S pass");
		peopleDb.put(vidya, "V fail");
		peopleDb.put(raj, "R pass");
		// peopleDb.put(null, "pass");  You can't enter null as key
		// peopleDb.put(raj, null); You can't even enter value as null in Hashtable
		
		for (Map.Entry<People, String> entry : peopleDb.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		System.out.println("Sandip result :" + peopleDb.get(sandip));
	
	}
}
