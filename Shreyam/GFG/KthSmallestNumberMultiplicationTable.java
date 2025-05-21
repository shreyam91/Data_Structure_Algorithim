// Question: Kth Smallest Number in Multiplication Table 
// Given three integers m, n and k. Consider a grid of m * n, where mat[i][j] = i * j (1 based index). The task is to return the kth smallest element in the m * n multiplication table.

// Examples :
// Input: m = 3, n = 3, k = 5
// Output: 3

package shreyam.gfg;

public class KthSmallestNumberMultiplicationTable {
    public static int count(int mid, int m, int n) {
        int countSum = 0;

        for (int i = 1; i <= m; i++) {
            countSum += Math.min(mid / i, n); 
        }
        return countSum;
    }
    
    public static int kthSmallest(int m, int n, int k) {
        int l = 1;
        int h = m * n;

        while (l < h) {
            int mid = (l + h) / 2;

            if (count(mid, m, n) >= k) {
                h = mid;     
            } else {
                l = mid + 1; 
            }
        }

        return l; 
    }
    public static void main(String[] args) {
        int m = 3, n = 3, k = 5;
        System.out.println(kthSmallest(m, n, k));
    }
}

// -------- Using PriorityQueue
// public int kthSmallest(int m, int n, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 
//         for (int i = 1; i <= m; i++) {
//             for (int j = 1; j <= n; j++) {
//                 int val = i * j;
//                 if (pq.size() < k) {
//                     pq.add(val); 
//                 } else if (val < pq.peek()) {
//                     pq.poll();   
//                     pq.add(val); 
//                 }
//             }
//         }
//         return pq.peek(); 
//     }

// -------- Brute Force Approach
// public int kthSmallest(int m, int n, int k) {
//         List<Integer> result = new ArrayList<>(); 
//         for (int i = 1; i <= m; i++) {            
//             for (int j = 1; j <= n; j++) {       
//                 result.add(i * j);                
//             }
//         }
//         Collections.sort(result); 
//         return result.get(k - 1); 
//     }
