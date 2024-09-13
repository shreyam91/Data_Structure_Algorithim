package Shreyam.Array;

import java.util.Arrays;

public class insertion {
    
    public static void main(String[] args) {
        int arr[] = {23,12,45,67,87,11};
        int index = 3;
        int element = 10;

        int[] newarr = new int[arr.length+1];
        for(int i=0;i<index;i++){
            newarr[i] = arr[i];
        }
        newarr[index] = element;

        for (int i = index; i < arr.length; i++) {
            newarr[i + 1] = arr[i];
        }

        System.out.println("new array:" + Arrays.toString(newarr) );

    }
}
