// Question: Smallest Divisor

// Given an integer array arr[] and an integer k (where k ≥ arr.length), find the smallest positive integer divisor such that the sum of the ceiling values of each element in arr[] divided by this divisor is less than or equal to k.

// Examples:
// Input: arr[] = [1, 2, 5, 9], k = 6
// Output: 5

package shreyam.gfg;

import java.util.Arrays;

public class SmallestDivisor{
    static int smallestDivisor(int[] arr, int k) {
        int lo = 1, hi = Arrays.stream(arr).max().getAsInt(), ans=0;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(chec(arr, mid, k)){
                ans=mid;
                hi=mid-1;
            }
            else {
                lo=mid+1;
            }
        }
        return ans;
    }
    static boolean chec(int[] arr, int possibleAns, int k){
        int sum=0;
        for(int i: arr){
            sum+=i%possibleAns == 0?i/possibleAns : i/possibleAns +1;
        }
        return sum<=k;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 5, 9};
        int k = 6;
        System.out.println(smallestDivisor(arr, k));
    }
}
