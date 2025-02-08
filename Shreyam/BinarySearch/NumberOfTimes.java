package shreyam.binarySearch;

// Number of times this array is sorted 
public class NumberOfTimes {
    public static int numberOfTimes(int[] arr) {
        int start = 0, end = arr.length - 1;
        int index =-1;
        int ans = Integer.MAX_VALUE;

        if (arr.length == 0) return 0;
        if (arr[start] < arr[end]) return 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[start] <= arr[end]) {
                if (arr[start] < ans) {
                    index = start;
                    // ans = arr[start];
                }
                break;
            }

            if (arr[start] <= arr[mid]) {
                if (arr[start] < ans) {
                    index = start;
                    ans = arr[start];
                }

                start = mid + 1;
            } else { 
                if (arr[mid] < ans) {
                    index = mid;
                    ans = arr[mid];
                }

                end = mid - 1;
            }
        }
        return index;  
    }
    public static void main(String[] args) {
        int[] arr = {12,24,45,7,8,9};
        int Result= numberOfTimes(arr);

        if(Result == 0){
            System.out.println("array is not rotated");
        }else{
            System.out.println("array is rotated:"+ Result + " times.");
        }
    }
    
}


