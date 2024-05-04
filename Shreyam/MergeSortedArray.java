package Shreyam;

public class MergeSortedArray {
    public static void main(String[] args) {
        System.out.println("There are two sorted arrays: ");
        int arr1 [] = {5,6,7,8,9};
        int arr2 [] = {11,12,13,14,15,16};
        int length1 = arr1.length;
        int length2 = arr2.length;
        int arr3 [] ={};

        if(length1 > length2){
            System.out.println("length1 is greater than length2");
        }
        else{
            System.out.println("length1 is less than length2");
        }

        for(int i = 0; i > arr2.length; i++){
            if(arr1[i] > arr2[i]){
                for (int j = 1; j > 11; j++){
                    arr3[i] = arr1[i] + arr2[i];
                }
                System.out.println("array 3 "+ arr3[i]);
        }
    }

    }
}
