package shreyam.binarySearch;

public class FloorInArray {
    public static int floorElemment(int[]arr,int target){
        int start = 0, end = arr.length-1;
        int res =-1;

        while(start <= end){
            int mid= start + (end-start)/2;

            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] <= target){
                res = mid;
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {2,5,7,9,11,14,18,20};
        int target = 8;

        int Result = floorElemment(arr, target);

        if(Result == -1){
            System.out.println("no floor found");
        }else{
            System.out.println("Floor of element found at:" + Result + "value:" + arr[Result]);
        }
    }
}
