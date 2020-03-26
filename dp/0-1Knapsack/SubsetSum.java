class SubsetSum {

    // public static int max(int a, int b) {
    // return a > b ? a : b;
    // }

    // Tabulation - Topdown approach
    public static boolean isSubsetPresentTabulation(int A[], int sum, int n) {

        boolean dp[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= sum; j++) {
                if (A[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - A[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }

        return dp[n][sum];

    }

    public static boolean isSubsetPresent(int A[], int sum, int n) {
        if (n == 0 && sum > 0)
            return false;
        if (n == 0)
            return true;
        if (sum < A[n - 1])
            return isSubsetPresent(A, sum, n - 1);
        return isSubsetPresent(A, sum - A[n - 1], n - 1) || isSubsetPresent(A, sum, n - 1);
        // return 0;
    }

    public static void main(String[] args) {
        // int A[] = { 3, 2, 4, 12, 5, 34 };
        // int sum = 50;
        int A[] = { 2, 3, 7, 8, 10 };
        int sum = 5;
        int n = A.length;
        System.out.println("Recursive (No - DP) " + isSubsetPresent(A, sum, n));
        System.out.println("Tablulation (Topdown - DP) " + isSubsetPresentTabulation(A, sum, n));
    }
}