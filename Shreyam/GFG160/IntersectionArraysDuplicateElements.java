// Question: Intersection of Two arrays with Duplicate Elements... 
// Given two integer arrays a[] and b[], you have to find the intersection of the two arrays. Intersection of two arrays is said to be elements that are common in both arrays. The intersection should not have duplicate elements and the result should contain items in any order.
// Note: The driver code will sort the resulting array in increasing order before printing.

// Examples:
// Input: a[] = [1, 2, 1, 3, 1], b[] = [3, 1, 3, 4, 1]
// Output: [1, 3]

package shreyam.GFG160;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class IntersectionArraysDuplicateElements {
    public static  ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
       Set<Integer> setA = new HashSet<>();
        for(int num:a){
            setA.add(num);
        }
        
        Set<Integer> resultSet = new HashSet<>();
        for(int num:b){
            if(setA.contains(num)){
                resultSet.add(num);
            }
        }
        
        return new ArrayList<>(resultSet);
        
    }
    public static void main(String[] args) {
        int a[] = {1, 2, 1, 3, 1}, b[] = {3, 1, 3, 4, 1};
        System.out.println(intersectionWithDuplicates(a, b));
    }
}
