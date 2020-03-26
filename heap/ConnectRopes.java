import java.util.*;
import java.util.stream.Collectors;

class ConnectRopes {
    public static void ropesMinCost(int ropes[]) {
        // PriorityQueue<Integer> pqMin = new
        // PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        List<Integer> list = Arrays.stream(ropes).boxed().collect(Collectors.toList());
        pqMin.addAll(list);

        int result = 0;

        while (pqMin.size() > 1) {
            int f = pqMin.poll();
            int s = pqMin.poll();
            // int f = pqMin.remove();
            // int s = pqMin.remove();
            result += (f + s);
            pqMin.offer(f + s);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        // int ropes[] = { 1, 2, 3, 4, 5, 6 };
        // int ropes[] = { 4, 3, 2, 6 };
        int ropes[] = { 5, 2, 3, 9 };
        ropesMinCost(ropes);
    }
}