/*
https://leetcode.com/problems/minimum-window-substring/
76. Minimum Window Substring
Hard

4268

302

Add to List

Share
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */

import java.util.HashMap;

public class MinWindow {
        class Result {
            int len = Integer.MAX_VALUE;
            int l = 0;
            int r = 0;
        }
        public String minWindow(String s, String t) {
            if (s == null || s.length() == 0) {
                return "";
            }
            if (t == null || t.length() == 0) {
                return "";
            }
            Result result = new Result();
            HashMap<Character, Integer> charRequiredWithCount = new HashMap<Character, Integer>();
            HashMap<Character, Integer> current = new HashMap<Character, Integer>();

            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                int count = charRequiredWithCount.getOrDefault(c, 0);
                charRequiredWithCount.put(c, count + 1);
            }
            int charRequired = charRequiredWithCount.size();
            int l = 0;
            int r = 0;
            while (r < s.length()) {
                char rc = s.charAt(r);
                // System.out.println("r = " + r + " ch = " + rc);
                if (charRequiredWithCount.containsKey(rc)) {
                    int count = current.getOrDefault(rc, 0);
                    count++;
                    current.put(rc, count);
                    //System.out.println("  This char required: new count: " + count);

                    if (count == charRequiredWithCount.get(rc)) {
                        charRequired--;
                        if (charRequired == 0) {
                            // We got all chars, save if this smallest one so far
                            int newLen = r - l + 1;
                            if (newLen < result.len) {
                                result.len = newLen;
                                result.r = r;
                                result.l = l;
                            }

                            // Now increase left, i.e. contract the window
                            while (l <= r && charRequired == 0) {
                                //System.out.println("l = " + l);

                                char lc = s.charAt(l);
                                if (charRequiredWithCount.containsKey(lc)) {
                                    int countL = current.get(lc);
                                    countL--;
                                    current.put(lc, countL);
                                    if (charRequiredWithCount.get(lc) > countL) {
                                        charRequired++;
                                    }
                                }
                                l++;
                                if (charRequired == 0) {
                                    // We still seems to satisfy after reducing one char from left
                                    // Check if our final result is getting modified or not.
                                    int newLenL = r - l + 1;
                                    if (newLenL < result.len) {
                                        result.len = newLenL;
                                        result.r = r;
                                        result.l = l;
                                    }
                                }
                            }
                        }
                    }

                }
                r++;
            }
            return s.substring(result.l, result.r + 1);
        }

        public static void main (String[] args) {
            MinWindow minWindow = new MinWindow();

            //"ADOBECODEBANC"
            //"ABC"
            // o/p = "BANC"
            String minString = minWindow.minWindow("ADOBECODEBANC", "ABC");
            System.out.println(minString);
        }
}
