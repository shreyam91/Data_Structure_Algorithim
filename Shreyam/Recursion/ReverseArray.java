package shreyam.recursion;

public class ReverseArray {

    static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    static void reverseArray(int[] arr, int left, int right) {
        if (left >= right) {
            return; 
        }
        swap(arr, left, right);
        reverseArray(arr, left + 1, right - 1);
    }
    public static void main(String[] args) {
        int arr[] = {5,9,11,14,18,7};
        reverseArray(arr, 0, arr.length-1);

        for(int num:arr){
            System.out.print(num + " ");
        }
    }
}
