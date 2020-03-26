
class Knapsack {
    static int dp[][] = new int[200][200];
    static {

        for (int i = 0; i < 200; i++)
            for (int j = 0; j < 200; j++)
                dp[i][j] = -1;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    // Itetative - Top-down Approach
    public static int knapsackIterative(int val[], int wt[], int capacity, int size) {
        int dpIter[][] = new int[size + 1][capacity + 1];

        for (int i = 0; i <= size; i++) {
            for (int W = 0; W <= capacity; W++) {
                if (i == 0 || W == 0)
                    dpIter[i][W] = 0;
                else if (W >= wt[i - 1])
                    dpIter[i][W] = max(val[i - 1] + dpIter[i - 1][W - wt[i - 1]], dpIter[i - 1][W]);
                else
                    dpIter[i][W] = dpIter[i - 1][W];
            }
        }
        return dpIter[size][capacity];

    }

    // Memoization - Bottom-up Approach
    public static int knapsackMemoize(int val[], int wt[], int capacity, int size) {
        if (size == 0 || capacity == 0)
            return 0;
        if (dp[size][capacity] != -1)
            return dp[size][capacity];
        else {
            if (capacity >= wt[size - 1])
                return dp[size][capacity] = max(val[size - 1] + knapsack(val, wt, capacity - wt[size - 1], size - 1),
                        knapsack(val, wt, capacity, size - 1));
            else
                return dp[size][capacity] = knapsack(val, wt, capacity, size - 1);
        }
        // return dp[size][capacity];
    }

    public static int knapsack(int val[], int wt[], int capacity, int size) {

        if (size == 0 || capacity == 0)
            return 0;
        if (capacity >= wt[size - 1])
            return max(val[size - 1] + knapsack(val, wt, capacity - wt[size - 1], size - 1),
                    knapsack(val, wt, capacity, size - 1));
        else
            return knapsack(val, wt, capacity, size - 1);

    }

    public static void main(String[] args) {
        int val[] = { 60, 100, 120 };
        int wt[] = { 10, 20, 30 };
        int capacity = 50;
        int size = val.length;
        int normalRecursion = knapsack(val, wt, capacity, size);
        System.out.println("Recursive result " + normalRecursion);
        int memoize = knapsackMemoize(val, wt, capacity, size);
        System.out.println("Memoization - BottomUp " + memoize);
        int iterative = knapsackIterative(val, wt, capacity, size);
        System.out.println("Iterative - TopDown " + iterative);

    }
}