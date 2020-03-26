import java.util.*;

class SumOfElementBetweenK1andK2 {
    public static void solver(int A[], int k1, int k2) {
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
        int result = 0;
        for (int i : A)
            pqMax.offer(i);

        while (!pqMax.isEmpty()) {
            if (pqMax.size() > k1 && pqMax.size() < k2)
                result += pqMax.poll();
            else
                pqMax.remove();
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        // int A[] = { 20, 8, 22, 4, 12, 10, 14 };
        // int k1 = 3, k2 = 6;
        int A[] = { 10, 2, 50, 12, 48, 13 };
        int k1 = 2, k2 = 6;
        solver(A, k1, k2);
    }
}