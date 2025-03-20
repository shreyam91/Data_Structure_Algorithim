// Question: Second Largest... 
// Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1.

// Note: The second largest element should not be equal to the largest element.

// Examples:

// Input: arr[] = [12, 35, 1, 10, 34, 1]
// Output: 34

package shreyam.GFG160;

public class SecondLargest {
    public static int getSecondLargest(int[] arr) {
        int n = arr.length;
        int max1 = arr[0];
        int max2 = -1;
        
        for(int i=0; i<n; i++){
            if(arr[i] > max1){
                max1 = arr[i];
            }
        }
        
        for(int i=0; i<n;i++){
            if(arr[i] > max2 && arr[i] != max1){
                max2 = arr[i];
            }
        }
        return max2;
    }
    public static void main(String[] args) {
        int arr[] = {12, 35, 1, 10, 34, 1};
        int res = getSecondLargest(arr);
        System.out.println(res);
    }
}
