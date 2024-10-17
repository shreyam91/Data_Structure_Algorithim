package Shreyam.SlidingWindow;

import java.util.HashMap;

public class LongestSubarrayOfSumK {
    public static int subarrayOfSum(int[]arr, int k){
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int maxLength =0;
        int curSum =0;

        for(int i=0;i<arr.length;i++){
            curSum += arr[i];
            
            if(curSum == k){
                maxLength = i+1;
            }

            if(sumMap.containsKey(curSum-k)){
                maxLength = Math.max(maxLength, i-sumMap.get(curSum-k));
            }

            if(!sumMap.containsKey(curSum)){
                sumMap.put(curSum, i);
            }

        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[]arr = {4,1,1,1,1,2,3,5};
        int k = 5;

        int res = subarrayOfSum(arr, k);
        System.out.println("Length of largest subarray is: " + res);

    }
}
