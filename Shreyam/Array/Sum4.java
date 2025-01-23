// <!--- Brute Force Approach --->

// package Shreyam.Array;

// import java.util.ArrayList;
// import java.util.List;

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

//                         if(sum == target){
//                             List<Integer> quadruple = new ArrayList<>();
//                             quadruple.add(arr[i]);
//                             quadruple.add(arr[j]);
//                             quadruple.add(arr[k]);
//                             quadruple.add(arr[l]);
//                             result.add(quadruple);
//                         }
//                     }
//                 }
//             }
//         }
//             return result;
        
//     }
//     public static void main(String[] args) {
//         int [] arr = {1,2,3,4,5,6,7,8,9,0};
//         int target = 2;

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

// <!--- Better Approach --->
package Shreyam.Array;

public class Sum4 {
    static 

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,0};
        int target = 2;
    }
}