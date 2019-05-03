package com.sandip.SubStringCorrectWithSet;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static int lengthOfLongestSubstring(String s) {
		int logestSubStrLen = 0;
		int i = 0, j = 0;
		int ml = 0;
		int l = s.length();
        Set<Character> charSet = new HashSet<Character>();
		while (i < l && j < l) {
			if (charSet.contains(s.charAt(j))) {
				charSet.remove(s.charAt(i));
				i++;
			} else {
				charSet.add(s.charAt(j));
				j++;
				if (ml < (j - i)) {
					ml = (j - i);
				}
				
			}
		}

		return ml;
    }
}
