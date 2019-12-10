public class Main {
    // Dynamic programming: https://www.geeksforgeeks.org/dynamic-programming/
    //
    // https://www.geeksforgeeks.org/edit-distance-dp-using-memoization/
    // Edit Distance | DP using Memoization
    //Given two strings str1 and str2 and below operations that can be performed on str1. Find the minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
    //
    //Insert
    //Remove
    //Replace
    //All of the above operations are of equal cost.
    //Examples:
    //
    //Input: str1 = “geek”, str2 = “gesek”
    //Output: 1
    //We can convert str1 into str2 by inserting a ‘s’.
    public static void main(String args[]) {
        System.out.println("\nHello world");
        int input = 3;
        System.out.printf("\nFactorial of %d:%d", input, CalFactorial.fact(input));

        System.out.printf("\nMinimum edit for two string to become same");
        computEditDistance("sunday", "saturday");
        System.out.printf(" \n  expected: 3");

        computEditDistance("cat", "cut");
        System.out.printf(" \n  expected: 1");

        computEditDistance("geek", "gesek");
        System.out.printf(" \n  expected: 1");

        computEditDistance("horse", "ros");
        System.out.printf(" \n  expected: 3");
    }

    public static void computEditDistance(String str1, String str2) {
        int[][] res = new int[str1.length()][str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                res[i][j] = -1;
            }
        }
        int distance = DynamicProgramming.ed(str1, str2, str1.length(), str2.length(), res);
        System.out.printf(" \nMinimum edit cost: %d", distance);
    }
}

