package Shreyam;

public class DuplicateNumber {
    public static int duplicateNumber(int [] numbers){
        int n = numbers.length - 1;
        int actualSum = n*(n+1)/2;
        int arraySum = 0;

        for(int num : numbers){
            arraySum += num;
        }

        return arraySum - actualSum;
        
    }

    public static void main(String[] args) {
        int [] numbers = {1,2,3,4,5,6,7,8,3};
        int duplicate = duplicateNumber(numbers);

        System.out.println("Duplicate number: " + duplicate);
    }
    
}
