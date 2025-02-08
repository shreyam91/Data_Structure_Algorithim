package Shreyam.stack;

public class RainWaterTrapping {
    public static int waterTrapping(int[] arr){
        int length = arr.length;

        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];

        // find left max 
        maxLeft[0] = arr[0];
        for(int i=1;i<length;i++){
            maxLeft[i] = Math.max(maxLeft[i-1], arr[i]);
        }

        // find right max 
        maxRight[length-1] = arr[length-1];
        for(int i=length-2;i>= 0; i--){
            maxRight[i] = Math.max(maxRight[i+1], arr[i]);
        }

        // sum of trap water 
        int sum=0;
        for(int i=0;i<length;i++){
           int water = Math.min(maxLeft[i], maxRight[i])- arr[i];
           if(water > 0){
               sum = sum + water;
           }
        }

        return sum;
    }
    public static void main(String[] args) {
        int arr[] = {3,0,0,2,0,4};
        int res = waterTrapping(arr);

        System.out.println("Sum of all water traps:" + res);
    }
}
