// Question: Meeting Rooms III

// You are given an integer n representing the number of rooms numbered from 0 to n - 1. Additionally, you are given a 2D integer array meetings[][] where meetings[i] = [starti, endi] indicates that a meeting is scheduled during the half-closed time interval [starti, endi). All starti values are unique.
// Meeting Allocation Rules:
// When a meeting starts, assign it to the available room with the smallest number.
// If no rooms are free, delay the meeting until the earliest room becomes available. The delayed meeting retains its original duration.
// When a room becomes free, assign it to the delayed meeting with the earliest original start time.
// Determine the room number that hosts the most meetings. If multiple rooms have the same highest number of meetings, return the smallest room number among them.

// Examples:
// Input: n = 2, meetings[][] = [[0, 6], [2, 3], [3, 7], [4, 8], [6, 8]]
// Output: 1


package shreyam.gfg;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsIII {
    public static int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
      
        PriorityQueue<int[]> busyRooms = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
      
        PriorityQueue<Integer> idleRooms = new PriorityQueue<>();
      
        for (int i = 0; i < n; i++) {
            idleRooms.offer(i);
        }
      
        int[] count = new int[n];
      
        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
          
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                idleRooms.offer(busyRooms.poll()[1]);
            }
          
            int roomId;
            if (!idleRooms.isEmpty()) {
                roomId = idleRooms.poll();
                busyRooms.offer(new int[] {end, roomId});
            } else {
                int[] busyRoom = busyRooms.poll();
                roomId = busyRoom[1];
                busyRooms.offer(new int[] {busyRoom[0] + end - start, roomId});
            }
          
            count[roomId]++;
        }
      
        int mostBookedRoom = 0;
        for (int i = 0; i < n; i++) {
            if (count[mostBookedRoom] < count[i]) {
                mostBookedRoom = i;
            }
        }
      
        return mostBookedRoom;        
    }
    public static void main(String[] args) {
        int n = 2;
        int meetings[][] = {{0, 6}, {2, 3}, {3, 7}, {4, 8}, {6, 8}};
        System.out.println(mostBooked(n, meetings));
    }
}
