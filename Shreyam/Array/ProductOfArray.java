// Question: Product Of Array Except Self... 
package shreyam.array;

public class ProductOfArray {

    // <!--- Brute Force Approach -----> TC: O(n2)
    // static int[] product(int[] nums){
    //     int n = nums.length;
    //     int[] res = new int[n];
    //     for(int i=0; i<n;i++){
    //         int mul = 1;
    //         for(int j=0; j<n;j++){
    //             if(i==j) continue;
    //             mul = mul * nums[j];
    //         }
    //         res[i] =  mul;
    //     }
    //     return res;
    // }

    // <!-- Optimal Approach --> TC:O(n)
    static int[] product(int[] nums){
        int n = nums.length;
        int ans [] = new int [n];
        ans[0] = 1;

        for(int i=1; i<n;i++){
            ans[i] = ans[i-1] * nums[i-1];
        }
        int suffix = 1;
        for(int j = n-1; j>= 0; j--){
            ans[j] = ans[j] * suffix;
            suffix = suffix * nums[j];
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        int [] res = product(nums);

        for(int num: res){
            System.out.print(num + " ");
        }
    }
}
