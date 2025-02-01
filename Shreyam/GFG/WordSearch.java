// Question: Word Search... 
// You are given a two-dimensional mat[][] of size n*m containing English alphabets and a string word. Check if the word exists on the mat. The word can be constructed by using letters from adjacent cells, either horizontally or vertically. The same cell cannot be used more than once.

// Examples :
// Input: mat[][] = [['T', 'E', 'E'], ['S', 'G', 'K'], ['T', 'E', 'L']], word = "GEEK"
// Output: true

package Shreyam.GFG;

public class WordSearch {
    static public boolean isWordExist(char[][] mat, String word) {
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == word.charAt(0)){
                    boolean[][] visit = new boolean[mat.length][mat[0].length];
                    if(check(mat, i, j, 0, word, visit))
                        return true;
                }
            }
        }
        return false;
    }
    static boolean check(char[][] mat, int i, int j, int ind, String word, boolean[][] visit){
        if(ind == word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=mat.length || j>= mat[0].length || visit[i][j] || mat[i][j] != word.charAt(ind)){
            return false;
        }
        visit[i][j]=true;
        if(check(mat, i, j-1, ind+1, word, visit) ||
           check(mat, i, j+1, ind+1, word, visit) ||
           check(mat, i+1, j, ind+1, word, visit) ||
           check(mat, i-1, j, ind+1, word, visit))
           return true;
           
        visit[i][j]=false;
        return false;
    }
    public static void main(String[] args) {
        char[][] mat = {
            {'T', 'E', 'E'},
            {'S', 'G', 'K'},
            {'T', 'E', 'L'}
        };
        String word = "GEEK";
        boolean result = isWordExist(mat, word);
        System.out.println("Word exists: " + result);

    }
}
