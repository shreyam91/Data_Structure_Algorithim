// Question:Aggressive Cows... 
// You are given an array with unique elements of stalls[], which denote the position of a stall. You are also given an integer k which denotes the number of aggressive cows. Your task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.

// Examples :
// Input: stalls[] = [1, 2, 4, 8, 9], k = 3
// Output: 3


package shreyam.GFG160;

import java.util.Arrays;

public class AggressiveCows {
    public static int aggressiveCows(int[] stalls, int k) {

        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 0, high = stalls[n-1]-stalls[0], ans =0;
        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(mid, k, stalls)){
                ans = mid;
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return ans;
    }
    static boolean isPossible(int mid, int k, int[] stalls){
        int count = 1, lastCow = stalls[0];
        for(int i=1;i< stalls.length;i++){
            if(stalls[i]-lastCow>=mid){
                count++;
                lastCow = stalls[i];
                if(count >= k){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int stalls[] = {1, 2, 4, 8, 9};
        int k = 3;
        int res = aggressiveCows(stalls, k);
        System.out.println(res);

    }
}
