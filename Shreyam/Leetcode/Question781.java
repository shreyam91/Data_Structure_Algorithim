// Question: Rabbits in Forest... 
// There is a forest with an unknown number of rabbits. We asked n rabbits "How many rabbits have the same color as you?" and collected the answers in an integer array answers where answers[i] is the answer of the ith rabbit.
// Given the array answers, return the minimum number of rabbits that could be in the forest.

// Example 1:
// Input: answers = [1,1,2]
// Output: 5

package shreyam.leetCode;

import java.util.HashMap;

public class Question781 {
    public static int numRabbits(int[] answers) {
        HashMap<Integer, Integer> groupFreq = new HashMap<>();
        int count = 0;
        
        for (int ele : answers) {
            if (ele == 0) {
                count += 1;
            } else {
                groupFreq.put(ele, groupFreq.getOrDefault(ele, 0) + 1);
                if (groupFreq.get(ele) == ele + 1) {
                    count += ele + 1;
                    groupFreq.put(ele, 0);
                }
            }
        }
        
        for (int key : groupFreq.keySet()) {
            int freq = groupFreq.get(key);
            if (freq > 0) {
                count += key + 1;
            }
        }
        
        return count;
    }
    public static void main(String[] args) {
        int[] n = {1,1,2};

        int res = numRabbits(n);
        System.out.println(res);

    }
}
