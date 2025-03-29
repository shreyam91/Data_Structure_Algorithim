// Question: Job Sequencing Problem... 
// You are given two arrays: deadline[], and profit[], which represent a set of jobs, where each job is associated with a deadline, and a profit. Each job takes 1 unit of time to complete, and only one job can be scheduled at a time. You will earn the profit associated with a job only if it is completed by its deadline.
// Your task is to find:
// The maximum number of jobs that can be completed within their deadlines.
// The total maximum profit earned by completing those jobs.
// Examples :
// Input: deadline[] = [4, 1, 1, 1], profit[] = [20, 10, 40, 30]
// Output: [2, 60]

package shreyam.gfg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class JobSequencingProblem {
    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        
        ArrayList<int[]> jobList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobList.add(new int[] {deadline[i], profit[i]});
        }
        
        Collections.sort(jobList, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int curr = 0, points = 0;
        for (int i = 0; i < n; i++) {
            if (jobList.get(i)[0] > curr) {
                curr++;
                points += jobList.get(i)[1];
                pq.offer(jobList.get(i)[1]);
            } else if (jobList.get(i)[1] > pq.peek()) {
                points -= pq.peek();
                pq.poll();
                points += jobList.get(i)[1];
                pq.offer(jobList.get(i)[1]);
            }
        }
        
       
        ArrayList<Integer> result = new ArrayList<>();
        result.add(curr);
        result.add(points);
        return result;
        
    }
    public static void main(String[] args) {
        int deadline[] = {4, 1, 1, 1}; 
        int profit[] = {20, 10, 40, 30};
        ArrayList<Integer> result = jobSequencing(deadline, profit);
        System.out.println("Maximum number of jobs: " + result.get(0));
        System.out.println("Maximum profit: " + result.get(1));
    }
}
