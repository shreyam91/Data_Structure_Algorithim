// Question: Solving Questions With Brainpower.... 

// You are given a 0-indexed 2D integer array questions where questions[i] = [pointsi, brainpoweri].

// The array describes the questions of an exam, where you have to process the questions in order (i.e., starting from question 0) and make a decision whether to solve or skip each question. Solving question i will earn you pointsi points but you will be unable to solve each of the next brainpoweri questions. If you skip question i, you get to make the decision on the next question.

// For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
// If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
// If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be unable to solve questions 2 and 3.
// Return the maximum points you can earn for the exam.

 

// Example 1:

// Input: questions = [[3,2],[4,3],[4,4],[2,5]]
// Output: 5


package shreyam.leetCode;

import java.util.Arrays;

public class Question2140 {
    private static long findMaxPoints(int[][] questions, int pos, long[] mem) {
        if (pos >= questions.length) {
            return 0;
        }
        if (mem[pos] != -1) {
            return mem[pos];
        }
        
        long exclude = findMaxPoints(questions, pos + 1, mem);
        long include = questions[pos][0] + findMaxPoints(questions, pos + questions[pos][1] + 1, mem);
        mem[pos] = Math.max(exclude, include);
        return mem[pos];
    }
    
    public static long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] mem = new long[n];
        Arrays.fill(mem, -1);
        return findMaxPoints(questions, 0, mem);
    }
    public static void main(String[] args) {
        int questions[][] = {{3,2},{4,3},{4,4},{2,5}};
        System.out.println(mostPoints(questions));
    }
}
