// Question: Search in an almost Sorted Array... 
// Given a sorted integer array arr[] consisting of distinct elements, where some elements of the array are moved to either of the adjacent positions, i.e. arr[i] may be present at arr[i-1] or arr[i+1].
// Given an integer target.  You have to return the index ( 0-based ) of the target in the array. If target is not present return -1.

// Examples:
// Input: arr[] = [10, 3, 40, 20, 50, 80, 70], target = 40
// Output: 2

package shreyam.gfg;

public class SearchAlmostSortedArray {
    public static int findTarget(int arr[], int target) {
        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid = low + (high-low) / 2;

            if(arr[mid]==target) 
                return mid;

            if(mid>low && arr[mid-1]==target) 
                return mid-1;

            if(mid<high && arr[mid+1]==target) 
                return mid+1;

            if(arr[mid]>target){
                high = mid - 2;
            } 
            else{
                low = mid + 2;
            }
        }

        return -1;
        
    }
    public static void main(String[] args) {
        int arr[] = {10, 3, 40, 20, 50, 80, 70};
        int target = 40;

        System.out.println(findTarget(arr, target));
    }
}
