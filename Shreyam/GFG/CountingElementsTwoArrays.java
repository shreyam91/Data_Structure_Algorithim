// Question: Counting elements in two arrays 

// You are given two unsorted arrays a[] and b[]. Both arrays may contain duplicate elements. For each element in a[], your task is to count how many elements in b[] are less than or equal to that element.

// Examples:
// Input: a[] = [4, 8, 7, 5, 1], b[] = [4, 48, 3, 0, 1, 1, 5]
// Output: [5, 6, 6, 6, 3]

package shreyam.gfg;

import java.util.ArrayList;

public class CountingElementsTwoArrays {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        int n = a.length, m = b.length;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(0);
        }
        int[] cnt = new int[100001];
        for (int i = 0; i < 100001; i++) {
            cnt[i] = 0;
        }
        for (int i = 0; i < m; i++) {
            cnt[b[i]]++;
        }
        for (int i = 1; i < 100001; i++) {
            cnt[i] += cnt[i - 1];
        }
        for (int i = 0; i < n; i++) {
            res.set(i, cnt[a[i]]);
        }

        return res;
        
    }
    public static void main(String[] args) {
        int a[] = {4, 8, 7, 5, 1}, b[] = {4, 48, 3, 0, 1, 1, 5} ;
        System.out.println(countLessEq(a, b));
    }
}
