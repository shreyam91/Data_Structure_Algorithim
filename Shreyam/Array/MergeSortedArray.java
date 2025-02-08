package shreyam.array;

public class MergeSortedArray {
    public static void mergeArrays(int arr1[], int arr2[]){
        int m = arr1.length;
        int n = arr2.length;
        int j;

        for (int i=n-1; i>=0; i--) {
            int last = arr1[m-1];
            for( j = m-2; j>=0 && arr1[j] > arr2[i]; j-- ) {
                arr1[j+1] = arr1[j];
            }
            if(j!= m-2 || last > arr2[i]){
                arr1[j+1] = arr2[i];
                arr2[i] = last;
            }
        }
    }
    public static void main(String[] args) {
        int arr1[] = {1,5,7,9};
        int arr2[] = {2,6,8,};
        int arr3[] = {};

        int m = arr1.length;
        int n = arr2.length;

        int k = m+n;
        System.out.println("k"+k);

        mergeArrays(arr1,arr2);

        System.out.println("Merged arr1:");
        for(int num:arr1){
            System.out.print(num +" ");
        }
        System.out.println();

        System.out.println("Merged arr2:");
        for(int num:arr2){
            System.out.print(num +" ");
        }

        System.out.println("All arrays are merged");
        for(int i=1; i<k; i++){
            System.out.println("arr3"+ arr3[i]);
        }

        
    }
    
}
