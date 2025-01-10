// Question:- Count distinct elements in every window... 

// Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.

// Examples:
// Input: arr[] = [1, 2, 1, 3, 4, 2, 3], k = 4
// Output:  [3, 4, 4, 3]
// Explanation: Window 1 of size k = 4 is 1 2 1 3. Number of distinct elements in this window are 3.  Window 2 of size k = 4 is 2 1 3 4. Number of distinct elements in this window are 4. Window 3 of size k = 4 is 1 3 4 2. Number of distinct elements in this window are 4. Window 4 of size k = 4 is 3 4 2 3. Number of distinct elements in this window are 3.

package Shreyam.GFG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class countDistinctElementsInEveryWindow {
    static ArrayList<Integer> countDistinct(int [] arr, int k){
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < k; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        ans.add(mp.size());
        for (int i = k; i < arr.length; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);

            mp.put(arr[i - k], mp.get(arr[i - k]) - 1);
            if (mp.get(arr[i - k]) == 0) {
                mp.remove(arr[i - k]);
            }

            ans.add(mp.size());
        }

        return ans;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,1,3,4,2,3};
        int target = 4;
        ArrayList<Integer> result = countDistinct(arr, target);
        System.out.println(result);
    }
}
