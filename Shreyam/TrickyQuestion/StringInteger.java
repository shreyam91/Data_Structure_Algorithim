// Question :- Convert String into Integer... 
// Example:- 
// Input:- Three Thousand 
// Output:- 3000 
package Shreyam.TrickyQuestion;

import java.util.*;

public class StringInteger {
    private static final Map<String, Integer> numMap = new HashMap<>();
    static{
        numMap.put("zero", 0);
        numMap.put("one", 1);
        numMap.put("two", 2);
        numMap.put("three", 3);
        numMap.put("four", 4);
        numMap.put("five", 5);
        numMap.put("six", 6);
        numMap.put("seven", 7);
        numMap.put("eight", 8);
        numMap.put("nine", 9);
        numMap.put("ten", 10);
        numMap.put("eleven", 11);
        numMap.put("twelve", 12);
        numMap.put("thirteen", 13);
        numMap.put("fourteen", 14);
        numMap.put("fifteen", 15);
        numMap.put("sixteen", 16);
        numMap.put("seventeen", 17);
        numMap.put("eighteen", 18);
        numMap.put("nineteen", 19);
        numMap.put("twenty", 20);
        numMap.put("thirty", 30);
        numMap.put("forty", 40);
        numMap.put("fifty", 50);
        numMap.put("sixty", 60);
        numMap.put("seventy", 70);
        numMap.put("eighty", 80);
        numMap.put("ninety", 90);
        numMap.put("hundred", 100);
        numMap.put("thousand", 1000);
    }

    public static int convertToIntgere(String input){
        String [] words = input.toLowerCase().split(" ");
        int result = 0;
        int currentNumber = 0;

        for(String word: words){
            if(numMap.containsKey(word)){
                int value = numMap.get(word);

                if(value == 1000){
                    currentNumber *= value;
                    result += currentNumber;
                    currentNumber = 0;
                } else if(value == 100){
                    currentNumber *= value;
                }else {
                    currentNumber += value;
                }
            }
        }
        result += currentNumber;
        return result;
    }

    public static void main(String[] args) {
        String input = "twenty three thousand";
        int output = convertToIntgere(input);
        System.out.println("Output: " + output);
    }
}
