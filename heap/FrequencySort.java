import java.util.*;

class FrequencySort {

    // Using min
    @SuppressWarnings("unchecked")
    public static List<Integer> freqSort(int A[]) {
        // Create map to store frequency of element.
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A)
            map.put(i, map.getOrDefault(i, 0) + 1);

        // to sort in Decreasing order
        // PriorityQueue<Map.Entry<Integer, Integer>> pq = new
        // PriorityQueue<>(Comparator.comparing(e -> -e.getValue()));

        // to sort in Non-Decreasing order
        // PriorityQueue<Map.Entry<Integer, Integer>> pq = new
        // PriorityQueue<>(Comparator.comparing(e -> e.getValue()));

        // To sort we simply pass method with lambda and change the order of "a" and "b"
        // for sort.
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> e = pq.remove();
            for (int i = 0; i < (int) e.getValue(); i++)
                res.add((Integer) e.getKey());
        }
        /*
         * This is for string sort frequency based. Change Map.Entry<Character, Integer>
         * and return type as String. // String str = ""; while (!pq.isEmpty()) {
         * Map.Entry e = pq.remove(); for (int i = 0; i < (int) e.getValue(); i++) str
         * += e.getKey(); } System.out.println(str);
         */

        // System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        // String s = "aabcdddde";
        int A[] = { 2, 2, 5, 8, 5, 6, 8, 8 };

        System.out.println(freqSort(A));
    }
}