// Question: Longest Continuous Sequence... 

// Given an array of Os and 1s, write a function/method to return the position of 0 followed by (preceding) the longest continuous sequence of 1s.
// Longest continuous sequence of 1s: 1,1,1
// The position count starts from 0.
// The position of 0 preceding the longest continuous sequence of 1s is: 5 (Your function should return this)

// Examples

// Input: new int = [0,1,0,1,1,0,1,1,1,0,1]
// Output: 5

// Input: new int= [1,1,1,0,1]
// Output: 3

package shreyam.misc;

public class LongestContinuousSequence{
    public static int LongestContinuousSequences(int[] arr) {
        int maxCount = 0;
        int maxIndex = -1;
    
        int n = arr.length;
    
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                int left = i - 1;
                int right = i + 1;
                int count = 1; 
    
                while (left >= 0 && arr[left] == 1) {
                    count++;
                    left--;
                }
    
                while (right < n && arr[right] == 1) {
                    count++;
                    right++;
                }
    
                if (count > maxCount) {
                    maxCount = count;
                    maxIndex = i;
                }
            }
        }
    
        return maxIndex;
    }
    
    public static void main(String[] args) {
        int[] arr ={1,1,1,0,1};
        int res = LongestContinuousSequences(arr);
        System.out.println(res);
    }
}

