package Shreyam.binarySearch;

public class NextAlphabetElement {

    public static char nextAlphabet(char[]arr,char target){
        int start =0, end = arr.length-1;
        char res = '#';

        while(start <= end){
            int mid = (start + (end-start)/2);

            if(arr[mid] == target)
                start = mid+1;
            
            if(arr[mid] >= target){
                res = arr[mid];
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        char[] arr = {'a','b','d','r','u','z'};
        char target = 'e';

        char Result = nextAlphabet(arr, target);

        if(Result == '#'){
            System.out.println("not found");
        }else{
            System.out.println("Next alphabet character is: " + Result);
        }
        
    }
}
