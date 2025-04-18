// Question: Search in Rotated Sorted Array... 
// Given a sorted and rotated array arr[] of distinct elements, the task is to find the index of a target key. Return -1 if the key is not found.

// Examples :
// Input: arr[] = [5, 6, 7, 8, 9, 10, 1, 2, 3], key = 3
// Output: 8
// Explanation: 3 is found at index 8.

package shreyam.GFG160;

public class SearchRotatedSortedArray {
    static int search(int[] arr, int key) {
        int low=0,high=arr.length-1,mid;
        while(low<=high){
            mid=(low+high)/2;
            if(arr[mid]==key)return mid;
            else if(arr[mid]<arr[0]){
                if(key<=arr[high] && key>arr[mid])low=mid+1;
                else high=mid-1;
            }
            else{
                if(key<arr[mid] && key>=arr[low])high=mid-1;
                else low=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;

        int res = search(arr, key);
        System.out.println(res);

    }
}
