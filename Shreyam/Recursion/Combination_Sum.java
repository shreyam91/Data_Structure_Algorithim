package Shreyam.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {
    static List<List<Integer>> combination(int[] num, int target){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();

        backtrack( num,target,0,currentCombination,result);
        return result;
    }

    private static void backtrack(int[] num, int target,int start,List<Integer> currentCombination, List<List<Integer>>result){

        if(target == 0){
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        if(target <0) return;

        for(int i= start;i<num.length;i++){
            currentCombination.add(num[i]);
            backtrack(num, target-num[i], i, currentCombination, result);
            currentCombination.remove(currentCombination.size()-1);
        }
    }
    public static void main(String[] args) {
        int [] num = {2,3,6,7};
        int target = 6;
        List<List<Integer>> result = combination(num, target);
        System.out.println("Combinations that sum to " + target + " are: " + result);
    }
}
