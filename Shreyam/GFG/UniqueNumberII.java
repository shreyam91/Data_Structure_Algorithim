// Question: Unique Number II ... 
// Given an array arr[] containing 2*n + 2 positive numbers, out of which 2*n numbers exist in pairs whereas the other two number occur exactly once and are distinct. Find the other two numbers. Return the answer in increasing order.

// Examples:
// Input: arr[] = [1, 2, 3, 2, 1, 4]
// Output: [3, 4] 
// Explanation: 3 and 4 occur exactly once.

package shreyam.gfg;

import java.util.Arrays;

public class UniqueNumberII{
    public static int[] singleNum(int[] arr) {

        int xor = 0;
        for(int num : arr){
            xor ^= num;
        }
        
        int rightmostSetBit = (xor & (xor - 1)) ^ xor;
        int x = 0;
        int y = 0;
        for(int num : arr){
            if((num & rightmostSetBit) != 0){
                x ^= num;
            }
            else{
                y ^= num;
            }
        }
        
        int[] res = {x, y};
        Arrays.sort(res);
        return res;       
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,2,1,4};
        int [] res = singleNum(arr);

        for(int i:res){
            System.out.println(i);
        }
    }
}