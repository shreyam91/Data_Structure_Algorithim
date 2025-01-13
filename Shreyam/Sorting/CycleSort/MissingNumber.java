package Shreyam.Sorting.CycleSort;

public class MissingNumber {
    static void swap (int [] arr, int first, int last){
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }

    static int sort(int[]arr){
        int length = arr.length;
        int i=0;

        while(i < length){
            int correct = arr[i];
            if(arr[i] >= 0 && arr[i] < length && arr[i] != arr[correct]){
                swap(arr,i,correct);
            }else{
                i++;
            }
        }

        // Search missing number 
        for(int index =0; index < length; index++){
            if(arr[index] != index){
                return index;
            }
        }

        return length;
    }
    public static void main(String[] args) {
        int[] arr = {0,1};
        int missing = sort(arr);

        System.out.println("Missing number is:" + missing);
    }
}
