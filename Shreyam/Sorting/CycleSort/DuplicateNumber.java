// Question:- Find the Duplicate number in an Array... 
package shreyam.sorting.cycleSort;

public class DuplicateNumber {
    static int findDuplicate(int[] arr){
        int length = arr.length;
        int i=0;

        while(i < length){
            if(arr[i] != i+1){
                int correct = arr[i]-1;
                if(arr[i] != arr[correct]){
                    swap(arr,i,correct);
                }else{
                    return arr[i];
                }
            }else{
                i++;
            }
        }

        return -1;
    }
    static void swap (int [] arr, int first, int last){
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }
    public static void main(String[] args) {
        int [] arr = {1,3,4,2,2};
        int res = findDuplicate(arr);
        System.out.println(res);
    }
}
