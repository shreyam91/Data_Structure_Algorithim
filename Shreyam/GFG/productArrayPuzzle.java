// Question: Product array puzzle... 
// Given an array, arr[] construct a product array, res[] where each element in res[i] is the product of all elements in arr[] except arr[i]. Return this resultant array, res[].
// Note: Each element is res[] lies inside the 32-bit integer range.

// Examples:
// Input: arr[] = [10, 3, 5, 6, 2]
// Output: [180, 600, 360, 300, 900]
// Explanation: For i=0, res[i] = 3 * 5 * 6 * 2 is 180.
// For i = 1, res[i] = 10 * 5 * 6 * 2 is 600.
// For i = 2, res[i] = 10 * 3 * 6 * 2 is 360.
// For i = 3, res[i] = 10 * 3 * 5 * 2 is 300.
// For i = 4, res[i] = 10 * 3 * 5 * 6 is 900.

package Shreyam.GFG;

public class productArrayPuzzle {
    static int [] product(int[] arr){
        // <!--- Brute force Approach --->
        // int len =arr.length;
        //  int[] ans = new int[len];
        // for(int i =0; i<len;i++){
        //     int product =1;
        //     for(int j=0;j<len;j++){
        //         if(i != j){
        //             product *= arr[j];
        //         }
        //     }
        //     ans[i] = product;
        // }
        //         return ans;

        // <!-- Optimal Approach --> 
        int len = arr.length;
        int totalprod = 1, zero =0;
        int [] res = new int[len];

        for(int i:arr){
            if(i == 0){
                zero++;
            }else{
                totalprod *= i;
            }
        }

        if(zero > 1){
            return res;
        }

        if(zero == 1){
            for(int i=0;i<len;i++){
                if(arr[i] == 0){
                    res[i] = totalprod;
                }
            }
            return res;
        }
        for(int i=0; i<len; i++){
            res[i] = totalprod/arr[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int [] arr = {10,3,5,6,2};
        int [] ans = product(arr);
        for(int value: ans){
            System.out.print(value + " ");
        }
    }
}
