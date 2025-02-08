// Question:- Find all numbers Disappeared in an Array... 
package Shreyam.sorting.cycleSort;

import java.util.ArrayList;
import java.util.List;

public class numberDisappearedInArray {
    static List<Integer> numberDisappeared(int[] arr){
        int length = arr.length;
        int i=0;

        while(i < length){
            int correct = arr[i] -1;
            if(arr[i] >= 0 && arr[i] <= length && arr[i] != arr[correct]){
                swap(arr,i,correct);
            }else{
                i++;
            }
        }

        // Search missing number 
        List<Integer> ans = new ArrayList<>();
        for(int index =0; index < length; index++){
            if(arr[index] != index + 1){
                 ans.add(index + 1);
            }
        }

        return ans;
    }
    static void swap (int [] arr, int first, int last){
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }

    public static void main(String[] args) {
        int [] arr = {4,3,2,7,8,2,3,1};
        List<Integer> res = numberDisappeared(arr);

        for(int ele: res){
            System.out.print(ele + " ");
        }
    }
}
