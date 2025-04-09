// Question: Sort 0s, 1s and 2s.... 
// Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.
// You need to solve this problem without utilizing the built-in sort function.

// Examples:
// Input: arr[] = [0, 1, 2, 0, 1, 2]
// Output: [0, 0, 1, 1, 2, 2]


package shreyam.GFG160;

import java.util.Arrays;

public class Sort {
    public void sort012(int[] arr) {
        int zeros =0, ones=0;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                zeros++;
            }else if(arr[i] ==1){
                ones++;
            }
        }
        
        for(int i=0; i<arr.length;i++){
            if(zeros>0){
                arr[i]=0;
                zeros--;
            }else if(ones >0){
                arr[i]=1;
                ones--;
            }else{
                arr[i]=2;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2};
        Sort sort = new Sort();
        sort.sort012(arr);
        
        System.out.println(Arrays.toString(arr));    
    }
}
