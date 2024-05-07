package Misha;

import java.util.Arrays;

public class Sort_arrayWithoutSortingAlgo {
    

       public static  void sortArray(int[] arr) {
      
          int start = 0;
          int mid = 0;
          int end = arr.length - 1;
          
      
          while (mid <= end) {
      
            switch (arr[mid]) {
              case 0:
                
                swap(arr, start, mid);
                mid++;
                start++;
                break;
      
              case 1:
                mid++;
                break;
      
              case 2:
                
                swap(arr, mid, end);
                end--;
                break;
            }
          }
      
        }
      
        private static void swap(int[] arr, int pos1, int pos2) {
          int temp = arr[pos1];
          arr[pos1] = arr[pos2];
          arr[pos2] = temp;
        }
        public static void main(String[] args) {
            int[] arr = {0,1,2,1,0,2,2,2,1,0,1};
            sortArray(arr);
            System.out.println(Arrays.toString(arr));

        }
      
      }


