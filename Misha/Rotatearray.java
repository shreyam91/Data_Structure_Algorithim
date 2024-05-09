package Misha;

import java.util.Arrays;

public class Rotatearray {
   static int arr[] = new int[] {3,7,8,9,1};
    static void rotate()
    {
        int i=0,  j=arr.length-1;
        while( i != j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
        }
        
    }
    public static void main(String[] args) {
        System.out.println("given array is");
        System.out.println(Arrays.toString(arr));
        rotate();
        System.out.println("rotated array is");
        System.out.println(Arrays.toString(arr));
    }
}
