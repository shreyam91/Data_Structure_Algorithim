package Shreyam.SlidingWindow;

public class MaximumSubArray {
    public static int slidingWindow(int[]arr, int k){
        int len = arr.length;
        int max = Integer.MIN_VALUE;
        int i;
        int sum =0;

        for(i=0; i<k; i++){
            sum = sum + arr[i];
        }
        max = sum;

        for(i=k;i<len;i++){
            sum += arr[i] - arr[i-k];
            max = Math.max(max,sum); 
        }

        return max;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,5,1,3,6,3};
        int k = 3;

        int result = slidingWindow(arr, k);
        System.out.println("maximum sum " + k + "is: " + result);

    }
}
