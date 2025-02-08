// Question:- N-Queen Problem... 
// The n-queens puzzle is the problem of placing n queens on a (n × n) chessboard such that no two queens can attack each other. Note that two queens attack each other if they are placed on the same row, the same column, or the same diagonal.
// Given an integer n, find all distinct solutions to the n-queens puzzle.
// You can return your answer in any order but each solution should represent a distinct board configuration of the queen placements, where the solutions are represented as permutations of [1, 2, 3, ..., n]. In this representation, the number in the ith position denotes the row in which the queen is placed in the ith column.
// For eg. below figure represents a chessboard [3 1 4 2].

// Examples:
// Input: n = 1
// Output: [1]
// Explaination: Only one queen can be placed in the single cell available.

package Shreyam.gfg;

import java.util.ArrayList;

public class NQueenProblem {
    public static ArrayList<ArrayList<Integer>> nQueen(int n) {
        boolean[] col = new boolean[n];
        boolean[] ndiag = new boolean[2*n-1];
        boolean[] rdiag = new boolean[2*n-1];
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        ArrayList<Integer> tmp = new ArrayList();
        solve(n, 0, col, ndiag, rdiag, res, tmp);
        return res;
    }
    static void solve(int n, int currR, boolean[] col, boolean[] ndiag, boolean[] rdiag, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp){
        if(currR == n){
            res.add(new ArrayList(tmp));
            return;
        }
        for(int i=0;i<n;i++){
            if(col[i]==false && ndiag[currR+i] == false && rdiag[currR-i+n-1] == false){
                tmp.add(i+1);
                col[i]=true;
                ndiag[currR+i] =true;
                rdiag[currR-i+n-1] = true;
                solve(n, currR+1, col,  ndiag, rdiag, res, tmp);
                tmp.remove(tmp.size()-1);
                col[i]=false;
                ndiag[currR+i] =false;
                rdiag[currR-i+n-1] = false;
            }
        }
    }
    public static void main(String[] args) {
        int num = 1;
        ArrayList<ArrayList<Integer>> solutions = nQueen(num);
    
        for (ArrayList<Integer> solution : solutions) {
        printBoard(solution, num);
        System.out.println();
        }
    }

    public static void printBoard(ArrayList<Integer> solution, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (solution.get(i) == j + 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
}
}
