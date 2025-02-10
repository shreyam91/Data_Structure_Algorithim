package shreyam.array;

import java.util.HashMap;

public class ContainsDuplicate {
// <!--- Using sorting ---> TC: O(n log n);
//     static boolean isDuplicate(int[] nums){
//         int len = nums.length;
//         Arrays.sort(nums);
//         for(int i=1;i<len;i++){
//             if(nums[i] == nums[i-1]){
//                 return true;
//             }
//         }
//         return false;
    // }

// <!---- HashSet ---->
    // static boolean isDuplicate(int[] nums){
    //     HashSet<Integer> seen = new HashSet<>();
    //     for (int num : nums) {
    //         if (seen.contains(num)) {
    //             return true; 
    //         }
    //         seen.add(num); 
    //     }
    //     return false; 
    // }

// <!----- HashMap ------>
        static boolean isDuplicate(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    return true; 
                }
                map.put(num, 1); 
            }
                return false;
        }


    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        boolean res = isDuplicate(nums);
        System.out.println(res);
    }
}
