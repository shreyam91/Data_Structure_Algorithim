// Question: Count all triplets with given sum in sorted array... 
// Given a sorted array arr[] and a target value, the task is to count triplets (i, j, k) of valid indices, such that arr[i] + arr[j] + arr[k] = target and i < j < k.

// Examples:

// Input: arr[] = [-3, -1, -1, 0, 1, 2], target = -2
// Output: 4
// Explanation: Two triplets that add up to -2 are:
// arr[0] + arr[3] + arr[4] = (-3) + 0 + (1) = -2
// arr[0] + arr[1] + arr[5] = (-3) + (-1) + (2) = -2
// arr[0] + arr[2] + arr[5] = (-3) + (-1) + (2) = -2
// arr[1] + arr[2] + arr[3] = (-1) + (-1) + (0) = -2
package Shreyam.gfg;

public class countTripletsInSortedArray {
    public static int countTriplet(int arr[],int target){
        int len = arr.length;
        int count = 0;

        // Brute-force approach
        // for(int i=0;i<len;i++){
        //     for(int j=i+1;j<len;j++){
        //         for(int k=j+1;k<len;k++){
        //             if(arr[i]+arr[j]+arr[k] == target){
        //                 count++;
        //             }
        //         }
        //     }
        // }
                // Optimal approach 
        for(int i=0;i<len-2;i++){
            int j=i+1,k=len-1;
            
            while(j<k){
                int sum = arr[i]+arr[j]+arr[k];
                if(sum >target){
                    k--;}
                else if(sum<target){
                    j++;}
                else if(sum == target){
                    count++;
                    int temp = j+1;
                    while(temp<k && arr[temp]==arr[temp-1]){
                        count++;
                        temp++;
                    }
                    k--;
                }
            }
        }

        return count;
    }
 public static void main(String[] args) {
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
    int target = 12;
    int result = countTriplet(arr, target);

    System.out.println("There are " + result+ " triplets for the given sum.");
 }   
}
