// Question: Allocate Minimum Pages... 
// You are given an array arr[] of integers, where each element arr[i] represents the number of pages in the ith book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:
// Each student receives atleast one book.
// Each student is assigned a contiguous sequence of books.
// No book is assigned to more than one student.
// The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.
// Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

// Examples:
// Input: arr[] = [12, 34, 67, 90], k = 2
// Output: 113

package shreyam.GFG160;

public class AllocateMinimumPages {
    static boolean isPossible(int arr[],int k,int mid){
        int sum=0,student=1;
        for(int x:arr){
            sum+=x;
            if(sum>mid){
                student++;
                sum=x;
            }
        }
        return student<=k;
    }
    public static int findPages(int[] arr, int k) {
        if(k>arr.length)return -1;
        int sum = 0,mx=Integer.MIN_VALUE;
        for(int x:arr){
            sum+=x;
            mx=Math.max(mx,x);
        }
        int low=mx,high=sum,mid,ans=Integer.MAX_VALUE;
        while(low<=high){
            mid=(low+high)/2;
            if(isPossible(arr,k,mid)){
                high=mid-1;
                ans=Math.min(ans,mid);
            }
            else low=mid+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {12, 34, 67, 90};
        int k = 2;
        int res = findPages(arr, k);
        System.out.println(res);
    }
}
