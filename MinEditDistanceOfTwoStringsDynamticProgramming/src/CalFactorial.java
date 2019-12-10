public class CalFactorial {
    public static int fact(int n) {
        int[] results = new int[n + 1];
        for (int i = 0; i < results.length; i++) {
            results[i]  = -1;
        }

        results[0] = 1;
        results[1] = 1;
        for (int i = 2; i <= n; i++) {
            results[i] = results[i - 1]*i;
        }
        return results[n];
    }
}
