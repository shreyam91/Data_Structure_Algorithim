// Question: Duplicate number in Array... 
package shreyam.sorting.cycleSort;

import java.util.ArrayList;
import java.util.List;

public class duplicateNumberInArray {
    static void swap (int [] arr, int first, int last){
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }

    static List<Integer> duplicateNumber(int[]arr){
        int length = arr.length;
        int i=0;

        while(i < length){
            int correct = arr[i] -1;
            if(arr[i] > 0 && arr[i] <= length && arr[i] != arr[correct]){
                swap(arr,i,correct);
            }else{
                i++;
            }
        }

        // Search missing number 
        List<Integer> ans = new ArrayList<>();
        for(int index =0; index < length; index++){
            if(arr[index] != index+1){
                ans.add(arr[index]);
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> missing = duplicateNumber(arr);
        for(int res:missing){
            System.out.println("Duplicate number is:" + res);
        }
    }
}
