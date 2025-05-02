// Question: Bitonic Point... 
// Given an array of integers arr[] that is first strictly increasing and then maybe strictly decreasing, find the bitonic point, that is the maximum element in the array.
// Bitonic Point is a point before which elements are strictly increasing and after which elements are strictly decreasing.
// Note: It is guaranteed that the array contains exactly one bitonic point.

// Examples:
// Input: arr[] = [1, 2, 4, 5, 7, 8, 3]
// Output: 8

package shreyam.gfg;

public class BitonicPoint {
    public static  int findMaximum(int[] arr) {
        int ans=-1;
        int low=0, high=arr.length-1;
        while(low<=high){
            int mid=low + (high-low)/2;
            if(arr[mid]>arr[mid+1]){
                ans=arr[mid];
                high = mid-1;
            }
            else if(arr[mid]<=arr[mid+1]){
                low=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5, 7, 8, 3};
        System.out.println(findMaximum(arr));
    }
}
