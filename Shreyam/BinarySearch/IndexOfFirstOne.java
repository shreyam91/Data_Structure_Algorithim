package Shreyam.BinarySearch;

public class IndexOfFirstOne {
    public static int findLength(int[] arr,int target){
        if (arr.length == 0) return -1;
        int start = 0, end = 1;
        
        while(end < arr.length && arr[end] < target){
            int mid = start + (end-start)/2;
            start = end;
            end = Math.min(end*2,arr.length-1);

        }
        return binarySearch(arr,start,end,target);
    }

    public static int binarySearch (int[] arr, int start,int end, int target){
        int firstOccurence = -1;
        while(start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid] == target){
                firstOccurence = mid;
                end = mid-1;
            }
            if(arr[mid] <= target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return firstOccurence;
    }
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,0,1,1,1,1,1,2,2,2,2};
        int target =1;

        int Result = findLength(arr, target);
        if(Result == -1){
            System.out.println("Not found");
        }else{
            System.out.println("At index:" + Result);
        }

    }
}
