// Question: Sorted and Rotated Minimum.... 

// A sorted array of distinct elements arr[] is rotated at some unknown point, the task is to find the minimum element in it. 

// Examples:
// Input: arr[] = [5, 6, 1, 2, 3, 4]
// Output: 1
// Explanation: 1 is the minimum element in the array.

package shreyam.GFG160;

public class SortedRotatedMinimum {
    public static int findMin(int[] arr) {
        int n = arr.length;
        if(arr[0]<arr[n-1])
        return arr[0];
        int beg=0;
        int end=n-1;
        
        while(beg<=end)
        {
            int mid=(beg+end)/2;
            if(mid>0&&arr[mid]<arr[mid-1])
            return arr[mid];
            if(arr[beg]<=arr[mid]&&arr[mid]>arr[end])
            beg=mid+1;
            else 
            end=mid-1;
        }
        return arr[beg];
    }
    public static void main(String[] args) {
        int arr[] = {5,6,1,2,3,4};
        int res = findMin(arr);
        System.out.println(res);
    }
}
