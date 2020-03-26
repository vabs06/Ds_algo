// package heap;

import java.util.*;
import java.util.Map.Entry;

class TopKFreq {

    @SuppressWarnings("unchecked")
    // Using Bucket Sort
    public static List<Integer> usingBucketSort(int[] A, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A)
            map.put(a, map.getOrDefault(a, 0) + 1);
        int max = 0;

        // Get the max frequency.
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            max = Math.max(max, entry.getValue());

        // initialize an array of ArrayList. index is frequency, value is list of
        // numbers
        ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[max + 1];
        for (int i = 1; i <= max; i++)
            arr[i] = new ArrayList<Integer>();

        for (Map.Entry<Integer, Integer> num : map.entrySet()) {
            int count = num.getValue();
            int number = num.getKey();
            arr[count].add(number);
        }

        List<Integer> result = new ArrayList<>();

        // Add most frequent number to result.
        for (int index = max; index >= 1; index--) {
            if (arr[index].size() > 0) {
                for (int element : arr[index]) {
                    result.add(element);
                    if (result.size() == k)
                        return result;
                }
            }
        }
        return result;

    }

    // Using the Min Heap.
    public static List<Integer> usingHeap(int[] A, int k) {

        // Map is use to store the "key" as element and "value" as key's frequency.
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : A)
            mp.put(i, mp.getOrDefault(i, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparing(e -> e.getValue()));
        // PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) ->
        // a.getValue() - b.getValue());

        // Each map entry into PQ, then poll when PQ size increses more than "k".
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k)
                pq.poll();
        }

        // Extract k high frequent element from PQ and store inside the list.
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty())
            result.add(pq.poll().getKey());

        // Reverse the List
        Collections.reverse(result);
        return result;

    }

    public static void main(String[] args) {
        int A[] = { 1, 1, 1, 3, 2, 2, 4 };
        int k = 2;
        System.out.println("Using Min Heap " + usingHeap(A, k));
        System.out.println("Using Bucket Sort " + usingBucketSort(A, k));
    }
}