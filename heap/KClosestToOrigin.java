import java.util.*;

class KClosestToOrigin {

    // public static List<Integer> solver(int A[][], int K) {
    public static int[][] solver(int A[][], int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (b[0] * b[0] + b[1] * b[1] - (a[0] * a[0] + a[1] * a[1])));
        for (int i[] : A) {
            pq.add(i);
            if (pq.size() > K)
                pq.remove();
        }
        int res[][] = new int[K][2];
        while (K > 0)
            res[--K] = pq.remove();
        return res;
    }

    public static void main(String[] args) {
        int points[][] = { { 1, 3 }, { -2, 2 } };
        int K = 1;
        // solver(points, K);
        int re[][] = solver(points, K);
        for (int i[] : re)
            for (int j : i)
                System.out.print(j);
    }
}