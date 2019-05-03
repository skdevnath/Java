package com.sandip.leetcode.SubStringLen;
import java.util.Map;
import java.util.HashMap;


public class Solution {
	private static Map<String, Boolean> alphaTrack = new HashMap<String, Boolean>();

	private static void initAlphaTrack() {
		alphaTrack.put("a", false);
		alphaTrack.put("b", false);
		alphaTrack.put("c", false);
		alphaTrack.put("d", false);
		alphaTrack.put("e", false);
		alphaTrack.put("f", false);
		alphaTrack.put("g", false);
		alphaTrack.put("h", false);
		alphaTrack.put("i", false);
		alphaTrack.put("j", false);
		alphaTrack.put("k", false);
		alphaTrack.put("l", false);
		alphaTrack.put("m", false);
		alphaTrack.put("n", false);
		alphaTrack.put("o", false);
		alphaTrack.put("p", false);
		alphaTrack.put("q", false);
		alphaTrack.put("r", false);
		alphaTrack.put("s", false);
		alphaTrack.put("t", false);
		alphaTrack.put("u", false);
		alphaTrack.put("v", false);
		alphaTrack.put("w", false);
		alphaTrack.put("x", false);
		alphaTrack.put("y", false);
		alphaTrack.put("z", false);
	}
	private static int lengthOfSubstring(String s, int beginIdx) {
		int subStrLen = 0;
		String subStr = s.substring(beginIdx);
		String lowerSubStr = subStr.toLowerCase();
		char subCharA[] = lowerSubStr.toCharArray();
		
		// System.out.printf("Checking substring for %s\n", lowerSubStr);
		
		// clear the alpha hash
		initAlphaTrack();
		for (char c:subCharA) {
			if (Character.isLetter(c)) {
				if (alphaTrack.get(String.valueOf(c))) {
					// System.out.printf(" Found '%c' again in this sub-str\n", c);
					break;
				} else {
					// System.out.printf(" First time we found '%c' in sub-str, saving it. Str value(c): %s\n", c, String.valueOf(c));
					alphaTrack.put(String.valueOf(c), true);
					// System.out.printf(" retriveing saved value for alphaTrack['%s'] =  %s\n",
					//		   String.valueOf(c), alphaTrack.get(String.valueOf(c)));
					subStrLen++;
				}
			}
		}
        
		return subStrLen;
    }

	public static int lengthOfLongestSubstring(String s) {
		int logestSubStrLen = 0;
		for (int i = 0; i < s.length(); i++) {
			int subStrLen = lengthOfSubstring(s, i);
			if (subStrLen > logestSubStrLen) {
				logestSubStrLen = subStrLen; 
			}
		}

		return logestSubStrLen;
    }
	
}
