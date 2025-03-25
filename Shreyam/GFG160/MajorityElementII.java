// Question: Majority Element II... 
// You are given an array of integer arr[] where each number represents a vote to a candidate. Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return an empty array. 
// Note: The answer should be returned in an increasing format.

// Examples:
// Input: arr[] = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
// Output: [5, 6]

package shreyam.GFG160;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MajorityElementII {
    public static List<Integer> findMajority(int[] arr) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        
        if (n == 1) {
            ans.add(arr[0]);
            return ans;
        }
        
        int ele1 = arr[0], ele2 = arr[1], c1 = 0, c2 = 0;
        
        for (int i = 2; i < n; i++) {
            if (arr[i] == ele1) {
                c1++;
            } else if (arr[i] == ele2) {
                c2++;
            } else if (c1 == 0) {
                ele1 = arr[i];
                c1++;
            } else if (c2 == 0) {
                ele2 = arr[i];
                c2++;
            } else {
                c1--;
                c2--;
            }
        }
        
        c1 = 0;
        c2 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == ele1) {
                c1++;
            } else if (arr[i] == ele2) {
                c2++;
            }
        }
        
        if (c1 > n / 3) {
            ans.add(ele1);
        }
        if (c2 > n / 3) {
            ans.add(ele2);
        }
        
        Collections.sort(ans);
        
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
        List<Integer> result = findMajority(arr);
        System.out.println(result);
    }
}
