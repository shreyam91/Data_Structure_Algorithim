// Question: Finding 3-digit Even Numbers

// You are given an integer array digits, where each element is a digit. The array may contain duplicates.
// You need to find all the unique integers that follow the given requirements:
// The integer consists of the concatenation of three elements from digits in any arbitrary order.
// The integer does not have leading zeros.
// The integer is even.
// For example, if the given digits were [1, 2, 3], integers 132 and 312 follow the requirements.
// Return a sorted array of the unique integers.

// Example 1:
// Input: digits = [2,1,3,0]
// Output: [102,120,130,132,210,230,302,310,312,320]

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question2094{
    public static int[] findEvenNumbers(int[] digits) {

        List<Integer> ans = new ArrayList<>();
    int[] count = new int[10];

    for (final int digit : digits)
      ++count[digit];

    for (int a = 1; a <= 9; ++a)
      for (int b = 0; b <= 9; ++b)
        for (int c = 0; c <= 8; c += 2)
          if (count[a] > 0 && count[b] > (b == a ? 1 : 0) &&
              count[c] > (c == a ? 1 : 0) + (c == b ? 1 : 0))
            ans.add(a * 100 + b * 10 + c);

    return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        int[] digits = {2, 1, 3, 0};
        System.out.println(Arrays.toString(findEvenNumbers(digits)));
    }
}