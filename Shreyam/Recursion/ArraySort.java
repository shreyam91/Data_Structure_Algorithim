package Shreyam.recursion;

import java.util.Arrays;
// Using Merge Sort 

public class ArraySort {
    public static void recursiveArray(int [] arr){
        if(arr.length<2){
            return;
        }

        int mid = arr.length/2;

        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        recursiveArray(left);
        recursiveArray(right);

        mergeArray(arr, left, right);
    }

    public static void mergeArray(int[] arr, int[] left, int[] right){
        int i=0,j=0,k=0;

        while(i<left.length && j<right.length){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }

        while(i<left.length){
            arr[k++] = left[i++];
        }

        while(j<right.length){
            arr[k++] = right[j++];
        }

    }

    public static void printArray(int[] arr){
        for(int i:arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int [] arr = {12,11,13,5,6,7};
        System.out.println("Original Array:");
        printArray(arr);

        recursiveArray(arr);
        System.out.println("Sorted Array:");
        printArray(arr);
    }
}
