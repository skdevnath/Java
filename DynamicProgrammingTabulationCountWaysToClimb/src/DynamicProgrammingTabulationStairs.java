// https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair/0
// There are N stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time.
// Count the number of ways, the person can reach the top (order does matter).
//
//        Input:
//        The first line contains an integer 'T' denoting the total number of test cases. In each test cases, an integer N will be given.
//
//        Output:
//        For each testcase, in a new line, print number of possible ways to reach Nth stair. Answer your output % 10^9+7.
//
//        Constraints:
//        1<=T<=105
//        1<=N<=105
//
//        Example:
//        Input:
//        3
//        4
//        10
//        24
//        Output:
//        5
//        89
//        75025
import java.util.Scanner;

public class DynamicProgrammingTabulationStairs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalTests = scanner.nextInt();
        while(totalTests > 0) {
           totalTests--;
           int steps = scanner.nextInt();
           System.out.printf("In steps: %d\n", steps);
           int totalWays = totalWays(steps);
           System.out.println(totalWays);
        }
    }

    public static int totalWays(int steps) {
        int[] res = new int[steps + 1];
        for (int i = 0;i < res.length; i++) {
            res[i] = -1;
        }
        if (steps >= 1) {
            res[1] = 1;
            if (steps == 1) {
                return 1;
            }
        }
        if (steps >= 2) {
            res[2] = 2;
            if (steps == 2) {
                return 2;
            }
        }
        if (steps >= 3) {
            res[3] = 3;
            if (steps == 3) {
                return 3;
            }
        }
        for (int i = 4; i <= steps; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[steps];
    }
}
