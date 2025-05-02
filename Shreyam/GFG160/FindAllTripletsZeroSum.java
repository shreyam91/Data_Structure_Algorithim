// Question: Find All Triplets with Zero Sum... 
// Given an array arr[], find all possible triplets i, j, k in the arr[] whose sum of elements is equals to zero. 
// Returned triplet should also be internally sorted i.e. i<j<k.

// Examples:
// Input: arr[] = [0, -1, 2, -3, 1]
// Output: [[0, 1, 4], [2, 3, 4]]


package shreyam.GFG160;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FindAllTripletsZeroSum {
    public static List<List<Integer>> findTriplets(int[] arr) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>> mm = new HashMap<>();
        for(int i=0;i<n;i++){
            mm.putIfAbsent(arr[i],new ArrayList<>());
            mm.get(arr[i]).add(i);
        }
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                int rem = 0-(arr[i]+arr[j]);

                if(mm.get(rem)!=null){
                    int size=mm.get(rem).size();
                    for(int k=size-1;k>=0;k--){
                        if(mm.get(rem).get(k)<=j)break;
                        ans.add(new ArrayList<>(List.of(i,j,mm.get(rem).get(k))));
                    }
                }
            }
        }
        Collections.sort(ans,(o1, o2) -> o1.get(2).compareTo(o2.get(2)));
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{0, -1, 2, -3, 1};
        List<List<Integer>> triplets = findTriplets(arr);

        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }
    }
}
