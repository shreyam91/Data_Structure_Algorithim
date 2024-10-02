package Shreyam.BinarySearch;

import java.util.Arrays;

// allocate pages of books to every student atleast one student have book......

public class AllocatePagesOfBooks {
    public static int binarySearch(int[]arr, int k){
        int start = Arrays.stream(arr).max().orElse(0);
        int end = Arrays.stream(arr).sum();
        int res = -1;
        int n = arr.length;

        if(n<k) return -1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(isValid(arr, n, k, start) == true){
                res = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return res;
    }

    public static boolean isValid(int []arr, int n, int k, int max){
        int student =1;
        int sum =0;

        for(int i=0;i<n;i++){
            sum = sum + arr[i];
            if(sum > max){
                student++;
                sum = arr[i];
            }
            else if(student >k){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[]arr = {10,20,30,40};
        int k = 2;

        int result = binarySearch(arr, k);

        if(result == -1)
            System.out.println("error");
        else 
            System.out.println("something: " + result);
    }
}
