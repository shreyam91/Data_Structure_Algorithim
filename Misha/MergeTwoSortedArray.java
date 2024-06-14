package Misha;
import java.util.Arrays;

class MergeTwoSortedArray{
    static int arr1[] = new int[] {1,5,9,10};
        static int arr2[] = new int[] {2,3,8,13};
    static void merge( int n, int m)
    {
        int i=0;
        int j=0;
        int k=arr1.length-1;
        while(i<n && j<m){
            if(arr1[i]<arr2[j]){
                i++;
                continue;
            }else{
                int temp=arr1[k];
                arr1[k]=arr2[j];
                arr2[j]=temp;
                k--;
                j++;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }



    public static void main(String[] args) {
        
      merge(arr1.length, arr2.length);
     System.out.println("after merging \n First array: ");
     System.out.println(Arrays.toString(arr1));
     System.out.println("Second array: ");
     System.out.println(Arrays.toString(arr2));
    }
}