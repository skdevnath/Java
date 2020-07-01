/*
 https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
 https://www.youtube.com/watch?v=GTJr8OvyEVQ
 desc: https://docs.google.com/document/d/1GJqWSXoifBIAytlRrWQp1LF8-AfPSR3eSJhU1pcgOP0/edit
 */


import java.util.ArrayList;

public class KPMAlgoBruteForce {

    /*
      Break string in parts from the begining. For each part, find longest suffix, which is
      prefix too. These many characters to be avoided next time to compare.
      Finding longest proper prefix which is also suffix
      +--+--+--+--+--+--+--+--+
        0  1  2  3  4  5  6  7   = index
      +--+--+--+--+--+--+--+--+
        a  b  c  d  a  b  c  y   = e.g. pattern
      +--+--+--+--+--+--+--+--+
        0  0  0  0  1  2  3  0    = suffixIdx consider as sub string and find max len matching suffix for prefix.
      +--+--+--+--+--+--+--+--+     This many characters to be ignored from the beginning while matching text.
     */
    static int[] getPatterLsp(String pattern) {
        if (pattern == null || pattern.length() == 0) {
            return null;
        }
        int[] lsp = new int[pattern.length()];
        for (int i = 0; i < lsp.length; i++) {
            lsp[i] = 0; // name lps indicates longest proper prefix which is also suffix
        }
        // Check first character from 2nd char, as soon as it matches we can start prefix and sufix match
        int suffixIdx = 1;
        lsp[0] = 0; // for first char string there is is no prefix and suffix string.
        while (suffixIdx < pattern.length()) {
            if (pattern.charAt(suffixIdx) == pattern.charAt(0)) {
                int prefixIdx = 0;
                do {
                    lsp[suffixIdx] = prefixIdx + 1;
                } while (suffixIdx < pattern.length() && pattern.charAt(++prefixIdx) == pattern.charAt(++suffixIdx));
                if (suffixIdx < pattern.length()) {
                    lsp[suffixIdx] = 0; // No match so start from first char of prefix
                }
            } else {
                lsp[suffixIdx++] = 0; // No match so start from first char of prefix
            }
        }
        return lsp;
    }

    /*
      Find the pattern.
     */
    static ArrayList<Integer> findPatternInStr(String text, String pattern) {
        ArrayList<Integer> resList = new ArrayList<Integer>();

        if (text == null || text.length() == 0 || pattern == null || pattern.length() == 0) {
            return resList;
        }
        int[] lsp = getPatterLsp(pattern);
        // for (int i = 0; i < lsp.length; i++) {
        //     System.out.println(lsp[i] + ",");
        // }

        int t = 0;
        int p = 0;
        while (t < text.length()) {
            if (text.charAt(t) != pattern.charAt(p)) {
                if (p > 0) {
                    p = lsp[p - 1];
                } else {
                    p = 0;
                }
            } else {
                if (p == (pattern.length() - 1)) {
                    // full matched
                    resList.add(t - pattern.length() + 1);
                    p = lsp[p - 1];
                } else {
                    p++;
                }
            }
            t++;
        }

        return resList;
    }

    public static void main(String[] args) {
        String txt1 = "ABABDABACDABABCABAB";
        String pat1 = "ABABCABAB";

        String txt2 = "abcxabcdabxabcdabcdabcy";
        String pat2 = "abcdabcy";

        System.out.println("Match indexes");
        ArrayList<Integer> matches = findPatternInStr(txt2, pat2);
        matches.forEach(x -> System.out.println(x + ","));
    }
}
