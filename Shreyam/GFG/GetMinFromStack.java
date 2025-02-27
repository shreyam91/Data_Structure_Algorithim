// Question: Get Min from Stack... 
// Given q queries, You task is to implement the following four functions for a stack:
// push(x) – Insert an integer x onto the stack.
// pop() – Remove the top element from the stack.
// peek() - Return the top element from the stack. If the stack is empty, return -1.
// getMin() – Retrieve the minimum element from the stack in O(1) time. If the stack is empty, return -1.
// Each query can be one of the following:
// 1 x : Push x onto the stack.
// 2 : Pop the top element from the stack.
// 3: Return the top element from the stack. If the stack is empty, return -1.
// 4: Return the minimum element from the stack.

// Examples:
// Input: q = 7, queries = [[1, 2], [1, 3], [3], [2], [4], [1, 1], [4]]
// Output: [3, 2, 1]

package shreyam.gfg;

import java.util.Stack;

public class GetMinFromStack {
    int min;
    Stack<Integer> st = new Stack();
    public void push(int x) {
        if(st.isEmpty()){
            min=x;
        }
        else if(x<=min){
            st.push(min);
            min=x;
        }
        st.push(x);
    }

    public void pop() {
        if(st.isEmpty())
            return;
        int tmp = st.pop();
        if(tmp == min){
            if(!st.isEmpty()){
                min=st.pop();
            }
        }
    }

    public int peek() {
        if(st.isEmpty())
            return -1;
        return st.peek();
    }

    public int getMin() {
        if(st.isEmpty())
            return -1;
        return min;
    }
    public static void main(String[] args) {
        GetMinFromStack stack = new GetMinFromStack();
        
        int[][] queries = {{1, 2},{1, 3},{3},{2},{4},{1, 1},{4}};
        
        for (int[] query : queries) {
            if (query[0] == 1) {
                stack.push(query[1]);  
                System.out.println("Pushed: " + query[1]);
            } else if (query[0] == 2) {
                stack.pop();  
                System.out.println("Popped");
            } else if (query[0] == 3) {
                System.out.println("Min: " + stack.getMin());  
            }
        }
    }
    }