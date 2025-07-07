// Question: Maximum Number of Events That Can Be Attended

// You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.
// You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.
// Return the maximum number of events you can attend.

// Example 1:
// Input: events = [[1,2],[2,3],[3,4]]
// Output: 3

package shreyam.leetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Quesstion1353 {
    public static int maxEvents(int[][] events) {
       Arrays.sort(events, (a, b) -> a[0] - b[0]);
        
        int n = events.length;
        int pos = 0;
        int time = 1;
        int attended = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        while (pos < n || !minHeap.isEmpty()) {
            if (minHeap.isEmpty()) {
                time = Math.max(time, events[pos][0]);
            }
            
            while (pos < n && events[pos][0] == time) {
                minHeap.offer(events[pos][1]);
                pos++;
            }
            
            while (!minHeap.isEmpty() && minHeap.peek() < time) {
                minHeap.poll();
            }
            
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                attended++;
            }
            time++;
        }
        return attended; 
    }
    public static void main(String[] args) {
        int events[][] = {{1,2},{2,3},{3,4}};
        System.out.println(maxEvents(events));
    }
}
