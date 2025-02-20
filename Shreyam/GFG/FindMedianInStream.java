// Question: Find median in a stream... 
// Given a data stream arr[] where integers are read sequentially, the task is to determine the median of the elements encountered so far after each new integer is read.
// There are two cases for median on the basis of data set size.
// 1. If the data set has an odd number then the middle one will be consider as median.
// 2. If the data set has an even number then there is no distinct middle value and the median will be the arithmetic mean of the two middle values.

// Examples:
// Input:  arr[] = [5, 15, 1, 3, 2, 8]
// Output: [5.0, 10.0, 5.0, 4.0, 3.0, 4.0] 
package shreyam.gfg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianInStream {
    public static ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> res = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : arr) {
            addNum(num, maxHeap, minHeap);
            res.add(findMedian(maxHeap, minHeap));
        }
        return res;
    }

    static void addNum(int num, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    static double findMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5, 15, 1, 3, 2, 8};
        ArrayList<Double> res = getMedian(arr);
        
        for (double median : res) {
            System.out.println(median);
        }
    }
}
