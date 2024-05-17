package Misha;

import java.util.PriorityQueue;

public class KthMaxMinElement {
public static int kthSmallest(int arr[], int k)
{
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i=0;i<arr.length;i++){
        pq.add(arr[i]);
    }
    int i=0;
    while(i<k-1){
        pq.poll();
        i++;
    }
    return pq.poll();
}



  public static void main(String[] args) {
    int arr[] = new int[] { 12,3,5,7,19};
    int k=3;
    System.out.println("kth smallest element is " + kthSmallest(arr, k));
    
  }  
  
}
