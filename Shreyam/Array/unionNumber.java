package Shreyam.array;

import java.util.ArrayList;
import java.util.List;

public class unionNumber {
    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5};
        int arr2[]= {5,5,6,7,8};

        int left=0;
        int right=0;

        // union 
        List<Integer> res = new ArrayList<>();

        while(left< arr1.length || right< arr2.length){

            // Skip duplicate 
            while(left>0 && left<arr1.length && arr1[left]==arr1[left-1]){
                left++;
            }
            while(right>0 && right<arr2.length && arr2[right]==arr2[right-1]){
                right++;
            }

            // one array exhaust 
            if(left>=arr1.length){
                res.add(arr2[right]);
                right++;
                continue;
            }
            if(right>=arr2.length){
                res.add(arr1[left]);
                left++;
                continue;
            }

            // Comparison 
            if(arr1[left]<arr2[right]){
                res.add(arr1[left]);    
                left++;
            }else if(arr1[left]>arr2[right]){
                res.add(arr2[right]);
                right++;    
            }else{
                res.add(arr1[left]);
                right++;
                left++;
            }
        }
        System.out.println(res);
    }
}
