package shreyam.sorting.cycleSort;

public class Basic {
      static void swap (int [] arr, int first, int last){
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }

    static void sort(int[]arr){
        int length = arr.length;
        int i=0;

        while(i < length){
            int correct = arr[i] -1;
            if(arr[i] != arr[correct]){
                swap(arr,i,correct);
            }else{
                i++;
            }
        }
    }
    

    public static void main(String[] args) {
        int [] arr = {3,5,2,1,4};
        sort(arr);
        
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
