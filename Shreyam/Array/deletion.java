package Shreyam.array;

import java.util.Arrays;

public class deletion {
    public static void main(String[] args) {
        int[] arr = {12,24,56,76,89,52};
        int dltIndex = 3;
        int length = arr.length;

        int [] newArr = new int[length-1];
        if(dltIndex >= 0 && dltIndex <length){
            for(int i=0,j=0;i<length;i++){
                if(i != dltIndex){
                    newArr[j++] = arr[i];
                }
            }
        }

        System.out.println(" updated array :" + Arrays.toString(newArr));
    }
}
