// Question: Top K Frequent Elements... 
package shreyam.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    // <!--- Brute Force Approach ---> TC: O(nlogn) SC: O(n)
    // public static List<Integer> frequentElement(int[] nums, int k) {
    //     Map<Integer, Integer> frequencyMap = new HashMap<>();
    //     for (int num : nums) {
    //         frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    //     }
        
    //     List<Map.Entry<Integer, Integer>> list = new ArrayList<>(frequencyMap.entrySet());
        
    //     list.sort((a, b) -> b.getValue() - a.getValue());
        
    //     List<Integer> result = new ArrayList<>();
    //     for (int i = 0; i < k; i++) {
    //         result.add(list.get(i).getKey());
    //     }
    //     return result;
    // }

    // <!--- Optimal Approach ---> TC: O(nlogk)
    static List<Integer> frequentElement(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }
        
        Collections.reverse(result);
        
        return result;
    } 
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        int k = 2;
        List<Integer> res = frequentElement(arr, k);        
        System.out.println(res);
    }
}
