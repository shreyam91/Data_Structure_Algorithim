// Question: Gas Station... 
// There are some gas stations along a circular route. You are given two integer arrays gas[] denoted as the amount of gas present at each station and cost[] denoted as the cost of travelling to the next station. You have a car with an unlimited gas tank. You begin the journey with an empty tank from one of the gas stations. Return the index of the starting gas station if it's possible to travel around the circuit without running out of gas at any station in a clockwise direction. If there is no such starting station exists, return -1.
// Note: If a solution exists, it is guaranteed to be unique.

// Examples:
// Input: gas[] = [4, 5, 7, 4], cost[]= [6, 6, 3, 5]
// Output: 2

package shreyam.gfg;

public class GasStation {
    public static int startStation(int[] gas, int[] cost) {
        int n = gas.length;
        
        int sum = 0;
        int start = 0;
        for(int i=0; i<2*n; i++){
            int ind = i%n;
            sum+=(gas[ind]-cost[ind]);
            if(sum<0){
                sum = 0;
                start = i+1;
            }
            if(i-start==n){
                return start;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int gas[] = {4, 5, 7, 4};
        int cost[] = {6, 6, 3, 5};
        int result = startStation(gas, cost);
        if(result != -1) {
            System.out.println("The starting gas station index is: " + result);
        } else {
            System.out.println("No valid starting gas station found.");
        }
    }
}
