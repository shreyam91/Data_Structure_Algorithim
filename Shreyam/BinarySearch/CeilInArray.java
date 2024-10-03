package Shreyam.BinarySearch;

public class CeilInArray {
    public static int ceilElement(int[] arr,int target){
        int res=0;
        int start=0,end =arr.length-1;

        while(start <= end){
            int mid= start + (end-start)/2;

            if(arr[mid] == target)
            return mid;

            else if(arr[mid] >= target){
                res = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int [] arr = {3,8,11,14,19,21,24};
        int target = 8;

        int Result = ceilElement(arr, target);

        if(Result == -1){
            System.out.println("Not found");
        }else{
            System.out.println("Ceil of the Element:" + Result + "value: " + arr[Result]);
        }
    }
}
