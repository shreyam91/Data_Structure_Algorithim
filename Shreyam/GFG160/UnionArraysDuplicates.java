// Question: Union of Arrays with Duplicates.... 
// Given two arrays a[] and b[], the task is to find the number of elements in the union between these two arrays.
// The Union of the two arrays can be defined as the set containing distinct elements from both arrays. If there are repetitions, then only one element occurrence should be there in the union.
// Note: Elements of a[] and b[] are not necessarily distinct.

// Examples
// Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3]
// Output: 5

package shreyam.GFG160;

import java.util.HashSet;
import java.util.Set;

public class UnionArraysDuplicates {
    public static int findUnion(int a[], int b[]) {
        Set<Integer> set = new HashSet<>();
        for(int num:a){
            set.add(num);
        }
        for(int num:b){
            set.add(num);
        }
        return set.size();
    }
    public static void main(String[] args) {
       int a[] = {1, 2, 3, 4, 5}, b[] = {1, 2, 3};
        System.out.println(findUnion(a, b));
    }
}
