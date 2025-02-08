package shreyam.array;
import java.util.*;
// <!-- Brute Force Approach --> Time Complexity- O(n^4),Space Complexity- O(1)
// public class Sum4 {
//     static List<List<Integer>> Sum(int[] arr, int target){
//         int n = arr.length;
//         List<List<Integer>> result = new ArrayList<>();

//         for(int i=0; i<n-3;i++){
//             for(int j=i+1;j<n-2;j++){
//                 for( int k = j+1; k<n-1;k++){
//                     for(int l = k+1; l<n ;l++){
//                         long sum = arr[i] + arr[j];
//                         sum += arr[k] + arr[l];

//                         if (arr[i] + arr[j] + arr[k] + arr[l] == target){
//                             List<Integer> quadruplet = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
//                                 if (!result.contains(quadruplet)) {
//                                     result.add(quadruplet);
//                                 }
//                         }
//                     }
//                 }
//             }
//         }
//         return result;
        
//     }
//     public static void main(String[] args) {
//         int [] arr = {1,2,3,4,5,6,7,8,9,0};
//         int target = 12;

//         List<List<Integer>> quadruples = Sum(arr, target);

//         if (quadruples.isEmpty()) {
//             System.out.println("No quadruples found.");
//         } else {
//             for (List<Integer> quadruple : quadruples) {
//                 System.out.println(quadruple);
//             }
//         }
//     }
// }

// <!-- Better Approach --> Time Complexity- O(n^3), Space Complexity- O(n^2)
// public class Sum4 {
//     public static List<List<Integer>> fourSum(int[] nums, int target) {
//             Arrays.sort(nums);
//             List<List<Integer>> result = new ArrayList<>();
//             Set<List<Integer>> seen = new HashSet<>();
            
//             int n = nums.length;
//             for (int i = 0; i < n - 3; i++) {
//                 for (int j = i + 1; j < n - 2; j++) {
//                     int left = j + 1, right = n - 1;
//                     while (left < right) {
//                         int sum = nums[i] + nums[j] + nums[left] + nums[right];
//                         if (sum == target) {
//                             List<Integer> quadruplet = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
//                             // Add to set to avoid duplicates
//                             if (!seen.contains(quadruplet)) {
//                                 result.add(quadruplet);
//                                 seen.add(quadruplet);
//                             }
//                             left++;
//                             right--;
//                         } else if (sum < target) {
//                             left++;
//                         } else {
//                             right--;
//                         }
//                     }
//                 }
//             }
//             return result;
//         }
    
//         public static void main(String[] args) {
//             int [] arr = {1,2,3,4,5,6,7,8,9,0};
//             int target = 12;
//             List<List<Integer>> quadruples = fourSum(arr, target);

//         if (quadruples.isEmpty()) {
//             System.out.println("No quadruples found.");
//         } else {
//             for (List<Integer> quadruple : quadruples) {
//                 System.out.println(quadruple);
//             }
//         }
//     }
// }


// <!-- Optimal Approach --> Time Complexity- O(n^3), Space Complexity- O(log n)
public class Sum4 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
    
            int n = nums.length;
            for (int i = 0; i < n - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;  
    
                for (int j = i + 1; j < n - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;  
    
                    int left = j + 1, right = n - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            left++;
                            right--;
                            while (left < right && nums[left] == nums[left - 1]) left++;
                            while (left < right && nums[right] == nums[right + 1]) right--;
                        } else if (sum < target) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }
            return result;
        }
        public static void main(String[] args) {
            int [] arr = {1,2,3,4,5,6,7,8,9,0};
                int target = 12;
                List<List<Integer>> quadruples = fourSum(arr, target);

        if (quadruples.isEmpty()) {
            System.out.println("No quadruples found.");
        } else {
            for (List<Integer> quadruple : quadruples) {
                System.out.println(quadruple);
            }
        }
    }
}