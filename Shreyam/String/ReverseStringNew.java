package Shreyam.string;

public class ReverseStringNew {

    public static void main(String[] args) {
        String original = "Structure";
        String reverse = reverseString(original);

        System.out.println("Original: " + original);
        System.out.println("Reverse: " + reverse);
    }
    public static String reverseString(String str){
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while(right > left){
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
    }
    return new String(charArray);
}
}