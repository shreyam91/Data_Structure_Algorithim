package shreyam.string;

public class checkCharacter {
    public static void main(String[] args) {
        // char ch = 'A';

        // if(ch=='a'||ch=='e'||ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E'||ch=='I' || ch=='O'|| ch=='U'){
        //     System.out.println(ch + " is vowel");
        // }
        // else{
        //     System.out.println(ch + " is consonant");
        // }

        String st = "hello world java!";
        int vowel=0;
        int consonant=0;
        int spacialChar =0;
        // char ch ='';

        for(int i=0;i<st.length();i++){

            char ch = st.charAt(i);

        if(ch=='a'||ch=='e'||ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E'||ch=='I' || ch=='O'|| ch=='U'){
                // System.out.println(ch + " is vowel");
                vowel++;
            }
            else if (ch == ' '||ch=='!'){
                spacialChar++;
            }
            else{
                // System.out.println(ch + " is consonant");
                consonant++;
            }
        }


        // System.out.println("string to character " + ch);   
        System.out.println("vowel "+vowel);
        System.out.println("consonant "+consonant); 
        System.out.println("special character "+spacialChar);
    }
}
