package Misha;
public class UnionAndIntersectionOfTwSortedArrays {
    public static int Union(int arr1[], int arr2[] , int m, int n)
    
    {

    
    int i=0;int j=0;
    while(i<m && j<n){
        if(arr1[i]<arr2[j]){
            System.out.println(arr1[i++]+ " ");
        }
        else if(arr2[j]<arr1[i]){
            System.out.println(arr2[j++]+ " ");
        }
        else{
            System.out.println(arr2[j++]+ " ");
            i++;
        }
    }
    while (i<m) {
        System.out.println(arr1[i++]);
        
    }
    while (j<n) {
        System.out.println(arr2[j++]);
        
    }

    return(0);
}

public static void main(String[] args) {
    int arr1[] = new int[]{1,3,5,7,9};
    int arr2[] = new int[]{2,3,5,6};
    int m = arr1.length;
    int n = arr2.length;
    System.out.println("union of array is " + Union(arr1,arr2,m,n));
}
}
