package shreyam.binarySearch;

public class PeakElement {

    public static int binarySearch(int [] arr){
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = start +(end - start)/2;

            if ((mid == start || arr[mid] > arr[mid - 1]) && (mid == end || arr[mid] > arr[mid + 1])) {
                return mid; 
            }

            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                end = mid - 1;
            } 
            else {
                start = mid + 1;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        int[] arr = {5,10,20,15,40,25};

        int result = binarySearch(arr);

        if(result == -1)
            System.out.println("no element found");
        else
            System.out.println("element found " + result + " " + arr[result]);
    }
    
}
