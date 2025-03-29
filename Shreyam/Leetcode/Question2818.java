// Question: Apply Operations to Maximize Score... 
// You are given an array nums of n positive integers and an integer k.
// Initially, you start with a score of 1. You have to maximize your score by applying the following operation at most k times:
// Choose any non-empty subarray nums[l, ..., r] that you haven't chosen previously.
// Choose an element x of nums[l, ..., r] with the highest prime score. If multiple such elements exist, choose the one with the smallest index.
// Multiply your score by x.
// Here, nums[l, ..., r] denotes the subarray of nums starting at index l and ending at the index r, both ends being inclusive.
// The prime score of an integer x is equal to the number of distinct prime factors of x. For example, the prime score of 300 is 3 since 300 = 2 * 2 * 3 * 5 * 5.
// Return the maximum possible score after applying at most k operations.
// Since the answer may be large, return it modulo 109 + 7.

// Example 1:
// Input: nums = [8,3,9,3,8], k = 2
// Output: 81


package shreyam.leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question2818 {
    private final static int mod = (int) 1e9 + 7;

    public static int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        int[][] arr = new int[n][0];
        for (int i = 0; i < n; ++i) {
            arr[i] = new int[] {i, primeFactors(nums.get(i)), nums.get(i)};
        }
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int[] e : arr) {
            int i = e[0], f = e[1];
            while (!stk.isEmpty() && arr[stk.peek()][1] < f) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                left[i] = stk.peek();
            }
            stk.push(i);
        }
        stk.clear();
        for (int i = n - 1; i >= 0; --i) {
            int f = arr[i][1];
            while (!stk.isEmpty() && arr[stk.peek()][1] <= f) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                right[i] = stk.peek();
            }
            stk.push(i);
        }
        Arrays.sort(arr, (a, b) -> b[2] - a[2]);
        long ans = 1;
        for (int[] e : arr) {
            int i = e[0], x = e[2];
            int l = left[i], r = right[i];
            long cnt = (long) (i - l) * (r - i);
            if (cnt <= k) {
                ans = ans * qpow(x, cnt) % mod;
                k -= cnt;
            } else {
                ans = ans * qpow(x, k) % mod;
                break;
            }
        }
        return (int) ans;
    }

    private static int primeFactors(int n) {
        int i = 2;
        Set<Integer> ans = new HashSet<>();
        while (i <= n / i) {
            while (n % i == 0) {
                ans.add(i);
                n /= i;
            }
            ++i;
        }
        if (n > 1) {
            ans.add(n);
        }
        return ans.size();
    }

    private static int qpow(long a, long n) {
        long ans = 1;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
        }
        return (int) ans;
    }
    public static void main(String[] args) {
        int[] nums = {8,3,9,3,8};
        int k = 2 ;
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        int result = maximumScore(numsList, k);
        System.out.println("Maximum Score: " + result);
    }
}
