package Shreyam;

public class Occurance {
    public static void main(String[] args) {
        System.out.println("Find occurance:");           

        String str = "aabbcccdddeeeee";
        int[] count = new int[256];

        for (char c : str.toCharArray()) {
            count[c]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                System.out.println((char) i + ":"+ count[i]);
            }
        }

}
}

