// Question: Move All Zeroes to End... 
// You are given an array arr[] of non-negative integers. Your task is to move all the zeros in the array to the right end while maintaining the relative order of the non-zero elements. The operation must be performed in place, meaning you should not use extra space for another array.

// Examples:
// Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
// Output: [1, 2, 4, 3, 5, 0, 0, 0]

package shreyam.GFG160;

public class MoveAllZeroes {
    static void pushZerosToEnd(int[] arr) {
            int j =0;
            for(int i=0; i< arr.length;i++){
                if(arr[i] != 0){
                    arr[j] = arr[i];
                    j++;
                }
            }
            for(;j<arr.length;j++){
                arr[j] = 0;
            }
        }
    public static void main(String[] args) {
           int arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
           pushZerosToEnd(arr);  
        
       for (int num : arr) {
           System.out.print(num + " ");
       }
    }
}
