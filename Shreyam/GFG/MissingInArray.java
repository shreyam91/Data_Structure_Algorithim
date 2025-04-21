// Question: Missing in Array... 
// You are given an array arr[] of size n - 1 that contains distinct integers in the range from 1 to n (inclusive). This array represents a permutation of the integers from 1 to n with one element missing. Your task is to identify and return the missing element.

// Examples:
// Input: arr[] = [1, 2, 3, 5]
// Output: 4


package shreyam.gfg;

public class MissingInArray {
    static int missingNum(int arr[]) {
        int n=arr.length+1;
        long sum=(long) n*(n+1)/2;
        for(long num:arr){
            sum-=num;
        }
        return (int) sum;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,5};
        int res = missingNum(arr);
        System.out.println(res);
    }
}
