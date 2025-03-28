// Question: Activity Selection... 

// You are given a set of activities, each with a start time and a finish time, represented by the arrays start[] and finish[], respectively. A single person can perform only one activity at a time, meaning no two activities can overlap. Your task is to determine the maximum number of activities that a person can complete in a day.

// Examples:
// Input: start[] = [1, 3, 0, 5, 8, 5], finish[] = [2, 4, 6, 7, 9, 9]
// Output: 4

package shreyam.gfg;

import java.util.Arrays;

public class ActivitySelection {
    public static int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        int[][] arr = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            arr[i][0] = start[i];
            arr[i][1] = finish[i];
        }
        Arrays.sort(arr, (a,b) -> a[1] - b[1]);
        int end=-1;
        int ans=0;
        for(int i = 0 ; i < n ; i++){
            if(end < arr[i][0]){
                ans++;
                end = arr[i][1];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int finish[] = {2, 4, 6, 7, 9, 9};

        int res = activitySelection(start, finish);
        System.out.println(res);
    }
}
