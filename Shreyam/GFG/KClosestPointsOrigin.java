// Question: K Closest Points to Origin... 
// Given an array of points where each point is represented as points[i] = [xi, yi] on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
// The distance between two points on the X-Y plane is the Euclidean distance, defined as: sqrt( (x2 - x1)2 + (y2 - y1)2 )
// Note: You can return the k closest points in any order, driver code will sort them before printing.

// Examples:
// Input: k = 2, points[] = [[1, 3], [-2, 2], [5, 8], [0, 1]]
// Output: [[-2, 2], [0, 1]]
// Explanation: The Euclidean distances from the origin are:
// Point (1, 3) = sqrt(10)
// Point (-2, 2) = sqrt(8)
// Point (5, 8) = sqrt(89)
// Point (0, 1) = sqrt(1)
// The two closest points to the origin are [-2, 2] and [0, 1].

package shreyam.gfg;

import java.util.PriorityQueue;

public class KClosestPointsOrigin {

    static int[][] kCloset(int[][]points,int k){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(distance(b), distance(a)));
        
                for(int[] pt: points){
                    pq.add(pt);
                    if(pq.size()>k){
                        pq.poll();
                    }
                }
                int[][] ans = new int[k][2];
                for(int i=0;i<k;i++){
                    ans[i] = pq.poll();
                }
                return ans;
            }
            static int distance(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
    public static void main(String[] args) {
        int k = 2;
        int points[][] = {{1,3},{-2,2},{5,8},{0,1}};
        int[][] result = kCloset(points, k);
        for (int[] res : result) {
            System.out.println("[" + res[0] + ", " + res[1] + "]");
        }
    }
}
