package shreyam.binarySearch;
public class NearlySortedArray {
    public static int search(int arr[],int target){
        int start =0, end = arr.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid] == target){
                return mid;
            }

            if(arr[mid-1] >= arr[start] && arr[mid-1] == target){  //check mid-1 is less than start
                return mid-1;
            }

            else if(arr[mid+1] <= arr[end] && arr[mid+1] == target){ // check mid+1 is less than end
                return mid+1;
            }

            if(arr[start] <= arr[mid]){ // check target value in left part of the array...
                if(arr[start] <= target && target <= arr[mid]){
                    end = mid-2;
                }else{
                    start = mid+2;
                }
            }else{ // check target value in the right part of the array...
                if(arr[mid] <= target && target <= arr[end]){
                    start = mid+2;
                }else{
                    end = mid-2;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] arr = {10,20,40,30,50};{
        int target =30;

        int Result = search(arr, target);

        if(Result == -1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element found at index:" + Result);
        }
        }
    }
}
