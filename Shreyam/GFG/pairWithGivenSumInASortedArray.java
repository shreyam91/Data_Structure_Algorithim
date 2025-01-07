// Question:- Pair with given sum in a sorted array.... 
// You are given an integer target and an array arr[]. You have to find number of pairs in arr[] which sums up to target. It is given that the elements of the arr[] are in sorted order.
// Note: pairs should have elements of distinct indexes. 

// Examples :

// Input: arr[] = [-1, 1, 5, 5, 7], target = 6
// Output: 3
// Explanation: There are 2 pairs which sum up to 6 : {1, 5}, {1, 5} and {-1, 7}.

package Shreyam.GFG;

public class pairWithGivenSumInASortedArray {
    public static int pairSum(int[] arr, int target){

        // <!--- Brute force approach --->
        // int length = arr.length;
        // int count = 0;

        // for(int i=0;i<length;i++){
        //     for(int j=i+1;j<length;j++){
        //         if(target == arr[i] + arr[j] ){
        //             count++;
        //         }
        //     }
        // }
        // return count ;

        // <!--- Optimal Approach --->
        int length = arr.length;
        int count = 0;
        int start =0,end = length-1;

        while(start < end){
            int sum = arr[start] + arr[end];
            if(sum > target){
                end-- ;
            }else if(sum < target){
                start++;
            }else if(sum == target){
                int ele1 =arr[start], ele2 = arr[end];
                int c1 =0, c2=0;

                while(start <= end && arr[start] == ele1){
                    c1++;
                    start++;
                }
                while(start <= end && arr[end] == ele2){
                    c2++;
                    end--;
                }
                if(ele1 == ele2){
                    count += c1*(c1-1)/2;
                }
                else {
                    count += c1*c2;
                }
            }
        }
        return count;
        

    }
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 1};
        int target = 2;

        int result = pairSum(arr, target);
        System.out.println(result);
    }
}

// if start and end element are same then use  N(N-1)/2. 
// if start and end element are different then use A*B. 