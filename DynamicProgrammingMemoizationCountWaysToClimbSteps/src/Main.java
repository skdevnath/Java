import java.util.*;
import java.lang.*;

/*
Dynamic programming:
Memoization (Top Down) - recursion is done. It starts from N to 1.


https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair/0
Hint: Start reverse i.e. top of the stair. Top down approach. Memoization.

Another way to solve is by avoiding recursion i.e. Tabulation. e.g. following.
https://leetcode.com/problems/climbing-stairs/discuss/25299/Basically-it's-a-fibonacci.


There are N stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time.
Count the number of ways, the person can reach the top (order does matter).

Input:
The first line contains an integer 'T' denoting the total number of test cases. In each test cases, an integer N will be given.

Output:
For each testcase, in a new line, print number of possible ways to reach Nth stair. Answer your output % 10^9+7.

Constraints:
1<=T<=105
1<=N<=105

Example:
Input:
3
4
10
24
Output:
5
89
75025
 */

class Main {
    public static void main (String[] args) {
        //code
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter any number: ");
        int cases = scan.nextInt();
        for (int i = 0; i < cases; i++) {
            int steps = scan.nextInt();
            System.out.println("Calling fw for step: " + steps);
            int totalWays = fw(steps);
            System.out.println("   Total ways: " + totalWays);
        }
        scan.close();
    }
    public static int fw(int n) {
        int[] res = new int[n + 1];// ignore res[0]
        for (int i = 0; i < n + 1; i++) {
            res[i] = -1;
        }
        System.out.println("fwr getting called for :" + n);
        return fwr(n, res);
    }
    public static int fwr(int n, int[] res) {
        if (n > res.length) {
            System.out.println("Error: res is smaller than input: " + n);
            return 0;
        }
        if (res[n] != -1) {
            return res[n];
        }
        if (n == 1) {
            res[1] = 1;
            return res[n];
        }
        if (n == 2) {
            res[2] = 2;
            return res[n];
        }
        if (n == 3) {
            res[3] = 3;
            return res[n];
        }

        // If reverse jump is one step
        int ways = fwr(n - 1, res);

        // If reverse jump is two step
        ways += fwr(n - 2, res);
        res[n] = ways;
        return ways;
    }
}
