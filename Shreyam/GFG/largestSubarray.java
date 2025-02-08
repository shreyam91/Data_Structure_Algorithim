// Question: Largest subarray of 0's and 1's... 
// Given an array arr of 0s and 1s. Find and return the length of the longest subarray with equal number of 0s and 1s.

// Examples:
// Input: arr[] = [1, 0, 1, 1, 1, 0, 0]
// Output: 6
// Explanation: arr[1...6] is the longest subarray with three 0s and three 1s.

package shreyam.gfg;
import java.util.HashMap;
import java.util.Map;

public class largestSubarray {
    static int maxLength(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) arr[i]=-1;
        }
        int k=0;
        int sum=0,length=0;

        Map<Integer,Integer>mp = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==k) length=Math.max(length,i+1);
            if (mp.containsKey(sum)) {
                length = Math.max(length, i - mp.get(sum));
            } else {
                mp.put(sum, i);
            }
        }
        return length;
    }
    public static void main(String[] args) {
        int [] arr = {1,0,1,1,1,0,0};
        int res = maxLength(arr);

        System.out.println(res);
    }
}
