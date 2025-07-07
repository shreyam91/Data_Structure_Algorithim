// Question: Next Greater Element in Circular Array

// Given a circular integer array arr[], the task is to determine the next greater element (NGE) for each element in the array.
// The next greater element of an element arr[i] is the first element that is greater than arr[i] when traversing circularly. If no such element exists, return -1 for that position.
// Circular Property:
// Since the array is circular, after reaching the last element, the search continues from the beginning until we have looked at all elements once.

// Examples: 
// Input: arr[] = [1, 3, 2, 4]
// Output: [3, 4, 4, -1]

package shreyam.gfg;

import java.util.ArrayList;

public class NextGreaterElementCircularArray {
    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;                           

        ArrayList<Integer> result = new ArrayList<>(); 

        for (int k = 0; k < n; k++) {
            result.add(-1);
        }

        for (int i = 0; i < n; i++) {               
            for (int j = 1; j < n; j++) {            
                
                if (arr[i] < arr[(i + j) % n]) {     
                    result.set(i, arr[(i + j) % n]); 
                    break;                           
                }
            }
        }

        return result; 
    }
    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 4};
        System.out.println(nextLargerElement(arr));
    }
}




// public ArrayList<Integer> nextLargerElement(int[] arr) {
//         int n = arr.length;                        
//         ArrayList<Integer> result = new ArrayList<>();

//         for (int k = 0; k < n; k++) {              
//             result.add(-1);
//         }

//         Stack<Integer> st = new Stack<>();      

//         for (int i = 0; i < 2 * n; i++) {          
//             int idx = i % n;                       
//             int num = arr[idx];                    

//             while (!st.isEmpty() && num > arr[st.peek()]) {
//                 result.set(st.pop(), num);         
//             }

//             if (i < n) {                           
//                 st.push(idx);                      
//             }
//         }
//         return result; 
//     }