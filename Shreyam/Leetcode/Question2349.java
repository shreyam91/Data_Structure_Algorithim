// Question: Design A Nuber Container System... 
// Design a number container system that can do the following:
// Insert or Replace a number at the given index in the system.
// Return the smallest index for the given number in the system.
// Implement the NumberContainers class:
// NumberContainers() Initializes the number container system.
// void change(int index, int number) Fills the container at index with the number. If there is already a number at that index, replace it.
// int find(int number) Returns the smallest index for the given number, or -1 if there is no index that is filled by number in the system.
 
// Example 1:
// Input
// ["NumberContainers", "find", "change", "change", "change", "change", "find", "change", "find"]
// [[], [10], [2, 10], [1, 10], [3, 10], [5, 10], [10], [1, 20], [10]]
// Output
// [null, -1, null, null, null, null, 1, null, 2]

package shreyam.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Question2349 {
    class NumberContainers {
    private Map<Integer, Integer> indexNumber; 
    private Map<Integer, TreeSet<Integer>> numberIndices; 

    public NumberContainers() {
        indexNumber = new HashMap<>();
        numberIndices = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexNumber.containsKey(index)) {
            int oldNumber = indexNumber.get(index);
            numberIndices.get(oldNumber).remove(index);
            if (numberIndices.get(oldNumber).isEmpty()) {
                numberIndices.remove(oldNumber); 
            }
        }

        indexNumber.put(index, number);
        numberIndices.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        if (!numberIndices.containsKey(number)) {
            return -1; 
        }
        return numberIndices.get(number).first();
    }
}
    public static void main(String[] args) {
        Question2349 question = new Question2349();
        NumberContainers nc = question.new NumberContainers();
        System.out.println(nc.find(10)); 
    
        nc.change(2, 10);  
        nc.change(1, 10);  
        nc.change(3, 10);  
        nc.change(5, 10); 
        System.out.println(nc.find(10)); 
    
        nc.change(1, 20); 
        System.out.println(nc.find(10)); 
    }
}
