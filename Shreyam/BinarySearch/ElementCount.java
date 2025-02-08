package Shreyam.binarySearch;

public class ElementCount {
    public static int firstOccurence(int[]arr, int target){
        int start=0,end=arr.length-1;
        int firstOccurence = -1;

        while(start <= end){
            int mid = start + (end-start)/2;
            
            if(arr[mid] == target){
                firstOccurence = mid;
                end = mid-1;
            }
            else if(arr[mid]< target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return firstOccurence;
    }
    public static int laststOccurence(int[]arr, int target){
        int start=0,end=arr.length-1;
        int laststOccurence = -1;

        while(start <= end){
            int mid = start + (end-start)/2;
            
            if(arr[mid] == target){
                laststOccurence = mid;
                start = mid+1;
            }
            else if(arr[mid]< target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return laststOccurence;
    }

    public static int elementCount(int [] arr, int target){
        int firstOccurence = firstOccurence(arr, target);

        if(firstOccurence == -1){
            return 0;
        }
        int laststOccurence = laststOccurence(arr, target);

        return laststOccurence - firstOccurence +1;
    }
    public static void main(String[] args) {
        int [] arr = {4,6,8,9,10,10,10,14};
        int target = 10;

        int Result= elementCount(arr, target);
        if(Result == 0){
            System.out.println("Element not found");
        }
        else{
            System.out.println("Element found at:" + Result + " times");
        }
 
    }
}
