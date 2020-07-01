import java.util.ArrayList;
import java.util.*;

public class AppMain {
    public static void main(String args[]) {
        List<Integer> matchIdxes = new ArrayList<Integer>();
        String str = "AABAACAADAABAABA";
        String pattern = "AABA";
        matchIdxes = findAllSubStrings(str, pattern);
        System.out.printf("\"%s\", Substring(%s) match indexes: \n", str, pattern);
        for (int i: matchIdxes) {
            System.out.println(i + " ,");
        }

    }

    public static List<Integer> findAllSubStrings(String str, String pattern) {
        List<Integer> retIdxes = new ArrayList<Integer>();

        if (str.length() >= pattern.length()) {
            int numOfCharsToTry = str.length() - pattern.length();
            for (int i = 0; i <= numOfCharsToTry; i++) {
                boolean matched = checkSubStringMatch(str, i, pattern);
                if (matched) {
                    retIdxes.add(i);
                }
            }
        }
        return retIdxes;
    }

    public static boolean checkSubStringMatch(String str, int idx, String pattern) {
        boolean retMatched = true;
        if (str.substring(idx, idx + pattern.length()).compareTo(pattern) == 0) {
            retMatched = true;
        } else {
            retMatched = false;
        }
        return retMatched;
    }
}
