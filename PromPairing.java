// package Shreyam;

// import java.util.ArrayDeque;
// import java.util.Arrays;
// import java.util.Deque;
// import java.util.Scanner;

// public class PromPairing {
//     public static void solve(int N, String S) {
//         int[] results = new int[N];
//         Arrays.fill(results, -1);  // Initialize the result array with -1
//         Deque<Integer> girlsQueue = new ArrayDeque<>();  // Queue to keep track of indices of girls

//         for (int i = 0; i < N; i++) {
//             if (S.charAt(i) == '0') {
//                 girlsQueue.add(i + 1);  // Store the 1-based index of the girl
//             } else if (S.charAt(i) == '1') {
//                 if (!girlsQueue.isEmpty()) {
//                     results[i] = girlsQueue.poll();  // Pair the boy with the front girl in the queue
//                 }
//             }
//         }

//         // Print the results as space-separated values
//         for (int i = 0; i < N; i++) {
//             System.out.print(results[i]);
//             if (i < N - 1) {
//                 System.out.print(" ");
//             }
//         }
//     }

//     public static void main(String[] args) {
//         // Example usage
//         Scanner scanner = new Scanner(System.in);
//         int N = scanner.nextInt();
//         String S = scanner.next();
//         solve(N, S);
//     }
// }

package Shreyam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PromPairing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        
        int N = Integer.parseInt(br.readLine().trim());
        String S = br.readLine();
        
        int[] out = solve(N, S);
        
        System.out.print(out[0]);
        for(int i = 1; i < out.length; i++) {
            System.out.print(" " + out[i]);
        }
        
        wr.close();
        br.close();
    }

    static int[] solve(int N, String S) {
        List<Integer> girls = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char gender = S.charAt(i);
            if (gender == '0') {
                girls.add(i + 1);  // Store the 1-based index of the girl
            } else {
                if (!girls.isEmpty()) {
                    result.add(girls.remove(0));  // Match the boy with the earliest girl
                } else {
                    result.add(-1);  // No girl available
                }
            }
        }

        // Convert the result list to an array
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}