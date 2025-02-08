package Shreyam.slidingWindow.Brute_Force;


public class FirstNegative {
    public static void slidingWindow(int[]arr, int k){
        for(int i=0; i<= arr.length-k;i++){
            int firstNegative = 0;
            for(int j=0; j<k;j++){
                if(arr[i+j] <0){
                    firstNegative = arr[i+j];
                    break;
                }
            }
            System.out.print(firstNegative + " "); 
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,4,-1,5,6,-2,9,8,-3};
        int k = 3;

        slidingWindow(arr, k);
    }
}
