// Question:- Container With Most Water.. 
// Given an array arr[] of non-negative integers, where each element arr[i] represents the height of the vertical lines, find the maximum amount of water that can be contained between any two lines, together with the x-axis.

// Note: In the case of a single vertical line it will not be able to hold water.

// Examples:
// Input: arr[] = [1, 5, 4, 3]
// Output: 6
// Explanation: 5 and 3 are 2 distance apart. So the size of the base is 2. Height of container = min(5, 3) = 3. So, total area to hold water = 3 * 2 = 6.

package shreyam.gfg;

public class containerWithMostWater {
    static int maxWater(int [] arr){
        int length = arr.length;
        int start =0, end = length-1;
        int maxArea =0,area =0;

        while(start <end){
            area = Math.min(arr[start], arr[end]) * (end-start);
            maxArea = Math.max(maxArea, area);
            if(arr[start] < arr[end]){
                start++;
            }
            else{
                end--;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int [] arr = {1,5,4,3};
        int result = maxWater(arr);
        System.out.println("Total area to hold water is: " + result);
    }
}
