package Shreyam.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II {
    private static void findCombination(int index, int[] arr, int target,List<List<Integer>>ans, List<Integer>result){
        if(target == 0){
            ans.add(new ArrayList<>(result));
            return;
        }
        for(int i= index; i<arr.length;i++){
            if(i>index && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;

            result.add(arr[i]);
            findCombination(i+1, arr, target-arr[i], ans, result);
            result.remove(result.size()-1);
        }
    }
    public static void main(String[] args) {
        int [] num = {1,2,4,6,3,8,10};
        int target = 10;
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<>();
        findCombination(0, num, target, result, new ArrayList<>());
        System.out.println("Combinations that sum to " + target + ": " + result);

    }
}
