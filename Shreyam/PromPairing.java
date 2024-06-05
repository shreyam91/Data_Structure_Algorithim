package Shreyam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class PromPairing {
    public static void solve(int N, String S) {
        int[] results = new int[N];
        Arrays.fill(results, -1);  // Initialize the result array with -1
        Deque<Integer> girlsQueue = new ArrayDeque<>();  // Queue to keep track of indices of girls

        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == '0') {
                girlsQueue.add(i + 1);  // Store the 1-based index of the girl
            } else if (S.charAt(i) == '1') {
                if (!girlsQueue.isEmpty()) {
                    results[i] = girlsQueue.poll();  // Pair the boy with the front girl in the queue
                }
            }
        }

        // Print the results as space-separated values
        for (int i = 0; i < N; i++) {
            System.out.print(results[i]);
            if (i < N - 1) {
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String S = scanner.next();
        solve(N, S);
    }
}
