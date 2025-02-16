package shreyam.trickyQuestion;

public class MergedTwoString {
    static String merge(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int length = Math.min(m, n);

        StringBuilder mergedString = new StringBuilder();

        for(int i =0; i<length;i++){
            mergedString.append(str1.charAt(i));
            mergedString.append(str2.charAt(i));
        }

        if(n>m){
            mergedString.append(str1.substring(length));
        }else{
            mergedString.append(str2.substring(length));

        }

        return mergedString.toString();
    }
    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "123";

        System.out.println(merge(str1, str2));
    }
}

// String 1 = "abcdef";
// String 2 = "123"
// o/p: a1b2c3def