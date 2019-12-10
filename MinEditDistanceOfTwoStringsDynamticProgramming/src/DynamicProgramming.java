public class DynamicProgramming {
    public static int myMin(int a, int b, int c) {
        if (a < b) {
            if (a < c) {
                return a;
            } else {
               return c;
            }
        } else if (b < c) {
            return b;
        } else {
            return c;
        }
    }

    public static int labMin(int a, int b, int c) {
        return Math.min(Math.min(a,b), c);
    }

    public static int ed(String str1, String str2, int m, int n, int[][] res) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }

        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            if (res[m - 1][n - 1] == -1) {
                res[m - 1][n - 1] = ed(str1, str2, m - 1, n - 1, res);
            }
        } else {
            // insert/replace/delete
            if (res[m - 1][n - 1] == -1) {
                res[m - 1][n - 1] = 1 + myMin(ed(str1, str2, m, n - 1, res),
                        ed(str1, str2, m -1, n - 1, res),
                        ed(str1, str2, m - 1, n, res));
            }
        }
        return res[m - 1][n - 1];
    }
}
