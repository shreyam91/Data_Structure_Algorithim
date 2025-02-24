// Question: Stock span problem...
// The stock span problem is a financial problem where we have a series of daily price quotes for a stock and we need to calculate the span of stock price for all days. The span arr[i] of the stocks price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the given day is less than or equal to its price on the current day.

// Examples:
// Input: arr[] = [100, 80, 60, 70, 60, 75, 85]
// Output: [1, 1, 1, 2, 1, 4, 6]

package shreyam.gfg;

import java.util.ArrayList;
import java.util.Stack;


public class StockSpanProblem {
    public static ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        s.push(0);
        ArrayList<Integer> S = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            S.add(0);
        }
        S.set(0, 1);

        for (int i = 1; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            int span = s.isEmpty() ? (i + 1) : (i - s.peek());
            S.set(i, span);
            s.push(i);
        }
        return S;
    }

    public static void main(String[] args) {
        int arr[] = {100, 80, 60, 70, 60, 75, 85};
        ArrayList<Integer> res = calculateSpan(arr);
        System.out.println(res);
    }
}
