package Misha;

public class largestSumContiguousSubArray {
   static  long maxSubArraySum(int arr[]){
        long maxSum = Integer.MIN_VALUE;
        long currentSum = 0;
        for(int i=0;i<arr.length;i++){
            currentSum = currentSum + arr[i];
            if(currentSum>=maxSum){
                maxSum=currentSum;
            }
            if(currentSum<0){
                currentSum=0;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int arr[] = {5,3,-2,1,4};
        long result = maxSubArraySum(arr);

        System.out.println(" sum is " + result);
    }
}
