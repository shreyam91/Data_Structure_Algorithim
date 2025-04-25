// Question: Majority Element.... 
// Given an array arr[]. Find the majority element in the array. If no majority element exists, return -1.
// Note: A majority element in an array is an element that appears strictly more than arr.size()/2 times in the array.

// Examples:
// Input: arr[] = [1, 1, 2, 1, 3, 5, 1]
// Output: 1


package shreyam.gfg;

public class MajorityElement {
    static int majorityElement(int arr[]) {
        int count = 0, candidate = -1;
    
        // Step 1: Find candidate
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
    
        // Step 2: Verify candidate
        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }
    
        if (count > arr.length / 2) {
            return candidate;
        }
    
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 1, 3, 5, 1};
        int res = majorityElement(arr);
        System.out.println(res);
    }
}
