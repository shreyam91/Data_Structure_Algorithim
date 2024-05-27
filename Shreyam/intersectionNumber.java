package Shreyam;

import java.util.ArrayList;
import java.util.List;

public class intersectionNumber {
    
    public static void main(String[] args) {
        int arr1[] ={1,2,3,4,4,5};
        int arr2[] ={4,5,6,7,7,8};

        int left=0;
        int right=0;

        List<Integer> res = new ArrayList<>();

        while(left<arr1.length || right<arr2.length){

            //duplicate number 
            while(left>0 &&left<arr1.length && arr1[left]==arr1[left-1]){
                left++;
            }
            while(right>0 &&right<arr2.length && arr2[right]==arr2[right-1]){
                right++;
            }

            //one array exhaust 
            if(left>=arr1.length || right>=arr2.length){
                break;
            }

            //comparison 
            if(arr1[left]<arr2[right]){
                left++;
            }else if(arr1[left]>arr2[right]){
                right++;
            }else{
                res.add(arr1[left]);
                left++;
                right++;
            }

        }
        System.out.println(res);
    }
}
