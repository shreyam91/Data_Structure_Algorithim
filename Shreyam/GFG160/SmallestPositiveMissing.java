// Question: Smallest Positive Missing... 
// You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.
// Note: Positive number starts from 1. The array can have negative integers too.

// Examples:
// Input: arr[] = [2, -3, 4, 1, 1, 7]
// Output: 3

package shreyam.GFG160;

import java.util.Arrays;

public class SmallestPositiveMissing {
    public static int missingNumber(int[] arr) {
         int n = arr.length;
       
       int x = 1;//smallest positive number
       
       Arrays.sort(arr);
       
       for(int i=0;i<n;i++){
           if(x ==arr[i]){
               x++;
           }else if( arr[i]>x){
               break;
               
           }
       }
       return x;
    }

    public static void main(String[] args) {
        int arr[] = {2, -3, 4, 1, 1, 7};
        int res = missingNumber(arr);
        System.out.println(res);  
    }
}
