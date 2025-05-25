// Question: Pythagorean Triplet

// Given an array arr[], return true if there is a triplet (a, b, c) from the array (where a, b, and c are on different indexes) that satisfies a2 + b2 = c2, otherwise return false.

// Examples:
// Input: arr[] = [3, 2, 4, 6, 5]
// Output: true

package shreyam.gfg;

import java.util.HashSet;

public class PythagoreanTriplet {
    static boolean pythagoreanTriplet(int[] arr) {
        int n=arr.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            int sq=arr[i]*arr[i];
            set.add(sq);
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int k=arr[i]*arr[i]+arr[j]*arr[j];
                if(set.contains(k)) return true;
            }
        }
        return false;
        
    }
    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 6, 5};
        System.out.println(pythagoreanTriplet(arr));
    }   
}
