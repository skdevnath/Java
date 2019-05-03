package com.sandip.FindShortedSubStringWithAllWords;
import java.util.*;

/* http://www.geeksforgeeks.org/shortest-substring-string-containing-given-words/
 * Question: Shortest substring of a string containing all given words
 *           Print the shortest sub-string of a string containing all 
 *           the given words.
 * e.g. 1
 *    Sentence = "The world is here. this is a life full of ups and downs. life is world."
 *    words = { "life", "ups", "is", "world" };
 * e.g. 2
 *    Sentence = "this is a test. this is a programming test. a programming test this is"
 *    words_array : {"this", "test", "a", "programming"} 
 */

public class FindShortSubStringMain {

	public static String getSortestStr(String str, String[] wordArray) {
		HashSet<String> wordSet = new HashSet<String>();
		for (String s: wordArray) {
			wordSet.add(s);
		}
		String shortestStr = null;
		
        // We remove punctuations before splitting.
        str = str.replace(".", "");
        str = str.replace(",", "");
        str = str.replace("!", "");
        
        System.out.println("\nFinal str is:" + str);
        System.out.println(" words array is:" + wordSet);
        
		int strLen = str.length();

		for (int s = 0; s < strLen; s++) {
			if ((s != 0) && str.charAt(s) != ' ') {
				continue;
			}
			for (int e = s; e < strLen; e++) {
				String subString;
				if ((str.charAt(e) != ' ') && (e != (strLen - 1))) {
					continue;
				}
				if (e == (strLen -1) ) {
					subString = str.substring(s, strLen);
				} else {
					subString = str.substring(s, e);
				}
				// System.out.println("\nSubstring before split: " + subString);
				String[] strArraySplit = subString.split(" ");
				HashSet<String> hashSet = new HashSet<String>();
				for (String sTmp: strArraySplit) { 
					hashSet.add(sTmp);
				}
				// System.out.println("Sub string to check:" + hashSet + "Shortest str length: " 
				  //            + ((shortestStr != null) ? shortestStr.length() : 0));
				if (hashSet.containsAll(wordSet)) {
					// System.out.println("All word Array matched");
					/* Aim is to get shorted string, which has all words */
					if (shortestStr == null ||
							((shortestStr.length() > subString.length()))){
						shortestStr = subString;
						break;
					}
				} else {
					// System.out.println("All word Array didn't matched");
				}
				if ((shortestStr != null) && (subString.length() > shortestStr.length())) {
					/* No point continuing as we already have smaller sentence, which has all words */
					break;
				}
			}

		}
		return shortestStr;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String words[] = {"san", "raj", "is"};
		String str = "do you know san is raj not anything else";
		System.out.println( "Sub string is :" + getSortestStr(str, words));

		String str1 = "The world is here. this is a" +
				" life full of ups and downs. life is world.";
		String words2[] = { "life", "ups", "is", "world" };
		System.out.println( "Sub string is :" + getSortestStr(str1, words2));
		
		String str2 = "this is a test. this is a programming test. a programming test this is";
		String words3[] = {"this", "test", "a", "programming"}; 
		System.out.println( "Sub string is :" + getSortestStr(str2, words3));
	}
}
