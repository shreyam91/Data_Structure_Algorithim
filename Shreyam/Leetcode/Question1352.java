// Question: Product of the Last k Numbers... 
// Design an algorithm that accepts a stream of integers and retrieves the product of the last k integers of the stream. Implement the ProductOfNumbers class:
// ProductOfNumbers() Initializes the object with an empty stream. void add(int num) Appends the integer num to the stream. int getProduct(int k) Returns the product of the last k numbers in the current list. You can assume that always the current list has at least k numbers. The test cases are generated so that, at any time, the product of any contiguous sequence of numbers will fit into a single 32-bit integer without overflowing.

// Example:
// Input:- ["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
// [[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]
// Output:- [null,null,null,null,null,null,20,40,0,null,32]

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Question1352 {
    private final List<Integer> stream;
    private int n;
    private int lastZeroIdx;

    public Question1352(){
        stream = new ArrayList<>();
        stream.add(1);
        n =1;
        lastZeroIdx = -1;
    }

    public void add(int num){
        if(num == 0){
            lastZeroIdx = n;
        }
        if(stream.get(stream.size()-1)==0){
            stream.add(num);
        }else{
            stream.add(stream.get(stream.size()-1)*num);
        }
        n++;
    }

    public int getProduct(int k){
        if(lastZeroIdx >= n-k){
            return 0;
        }

        if(stream.get(n-k-1)==0){
            return stream.get(n-1);
        }else{
            return stream.get(n-1)/stream.get(n-k-1);
        }
    }
    public static void main(String[] args) {
        Question1352 productOfNumbers = new Question1352();
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);

        System.out.println(productOfNumbers.getProduct(2));  
        System.out.println(productOfNumbers.getProduct(3));  
        System.out.println(productOfNumbers.getProduct(4));  

        productOfNumbers.add(8);
        System.out.println(productOfNumbers.getProduct(2));
    }
}
