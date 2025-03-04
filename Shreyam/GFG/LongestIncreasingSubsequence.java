// Question: Longest Increasing Subsequence... 
// Given an array arr[] of non-negative integers, the task is to find the length of the Longest Strictly Increasing Subsequence (LIS).
// A subsequence is strictly increasing if each element in the subsequence is strictly less than the next element.

// Examples:
// Input: arr[] = [5, 8, 3, 7, 9, 1]
// Output: 3
// Explanation: The longest strictly increasing subsequence could be [5, 7, 9], which has a length of 3.

package shreyam.gfg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    static int list(int arr[]){
        int n = arr.length;
        List<Integer>ans = new ArrayList<>();
        ans.add(arr[0]);
        for(int i=0;i<n;i++){
            if(arr[i] > ans.get(ans.size()-1)){
                ans.add(arr[i]);
            }else{
                int low = Collections.binarySearch(ans,arr[i]);
                if(low < 0){
                    low = -(low+1);
                }
                ans.set(low,arr[i]);
            }
        }
        return ans.size();
    }
    public static void main(String[] args) {
        int arr[] = {5, 8, 3, 7, 9, 1};
        int res = list(arr);
        System.out.println(res);
    }
}
