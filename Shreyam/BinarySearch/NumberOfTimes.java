package Shreyam.BinarySearch;

public class NumberOfTimes {
    public static int numberOfTime(int[] arr){
        int start =0, end = arr.length-1;
        int N = arr.length;

        if (arr.length == 0) return 0;
        if (arr[start] < arr[end]) return 0;
        while(start <= end){
            int mid = start + (end - start) /2;

           int prev = (mid+ N -1) %N;
           int next = (mid+1)%N;

            if(arr[mid] <= arr[next] && arr[mid] >= arr[prev] ){
                return mid;
            }
            else if(arr[mid] >= arr[start]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr = {22,27,34,45,5,8,9,10};
        int Result= numberOfTime(arr);

        if(Result == 0){
            System.out.println("array is not rotated");
        }else{
            System.out.println("array is rotated:"+ Result + " times.");
        }
    }
    
}


// Number of times this array is sorted 