// Question: Merge two 2D Arrays by Summing Values.... 
// You are given two 2D integer arrays nums1 and nums2.
//nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
// nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
// Each array contains unique ids and is sorted in ascending order by id.
// Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:
// Only ids that appear in at least one of the two arrays should be included in the resulting array.
// Each id should be included only once and its value should be the sum of the values of this id in the two arrays. If the id does not exist in one of the two arrays, then assume its value in that array to be 0.
// Return the resulting array. The returned array must be sorted in ascending order by id.

// Example 1:
// Input: nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
// Output: [[1,6],[2,3],[3,2],[4,6]]


package shreyam.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question2570 {
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> res = new ArrayList<>();
        int p1 =0, p2 =0;
        int m = nums1.length, n = nums2.length;

        while(p1 < m && p2 <n){
            if(nums1[p1][0] == nums2[p2][0]){
                res.add(new int[]{nums1[p1][0],nums1[p1][1] + nums2[p2][1]});
                p1++;
                p2++;
            }
            else if(nums1[p1][0] < nums2[p2][0]){
                res.add(nums1[p1]);
                p1++;
            }else{
                res.add(nums2[p2]);
                p2++;
            }
        }

        while(p1<m){
            res.add(nums1[p1]);
            p1++;
        }

        while(p2<n){
            res.add(nums2[p2]);
            p2++;
        }

        int[][] result = new int[res.size()][2];
        for(int i=0; i< res.size();i++){
            result[i] = res.get(i);
        }

        return result;  
    }
    public static void main(String[] args) {
        int [][] nums1 = {{1,2},{2,3},{4,5}};
        int [][] nums2 = {{1,4},{3,2},{4,1}};

        int[][] res = mergeArrays(nums1, nums2);
        for (int[] pair : res) {
            System.out.print(Arrays.toString(pair));
        }


    }
}
