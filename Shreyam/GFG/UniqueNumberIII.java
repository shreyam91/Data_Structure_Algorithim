// Question: Unique Number III... 
// Given an array of integers arr[] where, every element appears thrice except for one which occurs once.
// Find that element which occurs once.

// Examples:

// Input: arr[] = [1, 10, 1, 1]
// Output: 10


package shreyam.gfg;

public class UniqueNumberIII {
    public static int getSingle(int[] arr) {
        int res = 0;
        for(int i = 0; i < 32; ++i){
            int cnt = 0;
            int x = 1 << i;
            for(int j = 0 ; j < arr.length; ++j){
                if((arr[j] & x) != 0){
                    cnt++;
                }
            }
            
            if(cnt % 3 != 0){
                res |= x;
            }
        }
        
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {1, 10, 1, 1};
        int res = getSingle(arr);
        System.out.println(res);
    }
}
