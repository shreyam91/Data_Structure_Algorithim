// Question: Longest Span in two Binary Arrays

// Given two binary arrays, a1[] and a2[]. Find the length of longest common span (i, j) where j>= i such that a1[i] + a1[i+1] + .... + a1[j] =  a2[i] + a2[i+1] + ... + a2[j].

// Examples:
// Input: a1[] = [0, 1, 0, 0, 0, 0], a2[] = [1, 0, 1, 0, 0, 1]
// Output: 4

package shreyam.gfg;

import java.util.HashMap;
import java.util.Map;

public class LongestSpanTwoBinaryArrays{
    public static int longestCommonSum(int[] a1, int[] a2) {
         int n = a1.length;
        Map<Integer, Integer> map = new HashMap<>(); 
        int sum1 = 0, sum2 = 0, result = 0;

        for (int i = 0; i < n; i++) {
            sum1 += a1[i];
            sum2 += a2[i];
            int diff = sum1 - sum2;

            if (diff == 0) {
                
                result = i + 1;
            }else if (map.containsKey(diff)) {
                
                result = Math.max(result, i - map.get(diff));
            }else {
                
                map.put(diff, i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int a1[] = {0, 1, 0, 0, 0, 0}, a2[] = {1, 0, 1, 0, 0, 1};
        System.out.println(longestCommonSum(a1, a2));
    }
}