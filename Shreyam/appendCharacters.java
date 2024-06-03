package Shreyam;

public class appendCharacters {
    public static void main(String [] args){
        String s = "coaching";
        String t = "coding";

        // char[] appendCharacters;
        System.out.println(appendCharactersSubsequence);
        
    }

    public int appendCharactersSubsequence(String s, String t){
        int i=0;

        for(final char c :s.toCharArray())
            if(c == t.charAt(i))
                if(++i == t.length())
                return 0;

        return t.length() - i;
    }
    
}
