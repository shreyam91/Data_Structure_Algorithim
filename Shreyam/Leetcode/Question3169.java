// Question: Count Days Without Meetings... 
// You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1). You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).
// Return the count of days when the employee is available for work but no meetings are scheduled.
// Note: The meetings may overlap.

// Example 1:
// Input: days = 10, meetings = [[5,7],[1,3],[9,10]]
// Output: 2

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Question3169 {
    public static int countDays(int days, int[][] meetings) {
        List<int[]> time = new ArrayList<>();
        for (int[] meeting : meetings) {
            time.add(new int[]{meeting[0], 1});
            time.add(new int[]{meeting[1] + 1, 0});
        }
        
        time.sort((a, b) -> Integer.compare(a[0], b[0]));
        
        int overlap = 0;
        int count = time.get(0)[0] - 1; 
        for (int i = 0; i < time.size() - 1; ++i) {
            if (time.get(i)[1] == 0) overlap--;
            else overlap++;
            
            if (overlap == 0) {
                count += time.get(i + 1)[0] - time.get(i)[0];
            }
        }
        
        count += days - time.get(time.size() - 1)[0] + 1; 
        return count;
    }
    public static void main(String[] args) {
       int days = 10;
       int meetings[][] = {{5,7},{1,3},{9,10}};
        int res = countDays(days, meetings);
        System.out.println(res);
    }
}
