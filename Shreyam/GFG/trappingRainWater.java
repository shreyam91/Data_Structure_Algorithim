// Question: Trapping Rain Water... 
// Given an array arr[] with non-negative integers representing the height of blocks. If the width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 

// Examples:
// Input: arr[] = [3, 0, 2, 0, 4]
// Output: 7
// Explanation: Total water trapped = 0 + 3 + 1 + 3 + 0 = 7 units.

// Input: arr[] = [1, 2, 3, 4]
// Output: 0
// Explanation: We cannot trap water as there is no height bound on both sides.

package Shreyam.GFG;

public class trappingRainWater {
    static int waterTrapping(int[] arr){

        // <!--- Brute force approach --- >
        int length = arr.length;

        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];

        // find left max 
        maxLeft[0] = arr[0];
        for(int i=1;i<length;i++){
            maxLeft[i] = Math.max(maxLeft[i-1], arr[i]);
        }

        // find right max 
        maxRight[length-1] = arr[length-1];
        for(int i=length-2;i>= 0; i--){
            maxRight[i] = Math.max(maxRight[i+1], arr[i]);
        }

        // sum of trap water 
        int sum=0;
        for(int i=0;i<length;i++){
           int water = Math.min(maxLeft[i], maxRight[i])- arr[i];
           if(water > 0){
               sum = sum + water;
           }
        }

        return sum;

        // <!--- Optimal Approach -->
        // int totalWater = 0;
        // int lmax = 0, rmax = 0;
        // int i = 0, j = arr.length - 1;
        
        // while (i < j) {
        //     lmax = Math.max(lmax, arr[i]);
        //     rmax = Math.max(rmax, arr[j]);
            
        //     if (arr[i] <= arr[j]) {
        //         totalWater += lmax - arr[i];
        //         i++;
        //     } else {
        //         totalWater += rmax - arr[j];
        //         j--;
        //     }
        // }
        
        // return totalWater;
    }
    public static void main(String[] args) {
        int [] arr = {3, 0, 2, 0, 4};
        int waterTrapped = waterTrapping(arr);
        System.out.println("Trapped water is: " + waterTrapped);
    }
}
