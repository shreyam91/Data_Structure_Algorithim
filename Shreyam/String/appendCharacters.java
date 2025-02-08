package shreyam.string;

public class appendCharacters {
    public static void main(String[] args) {
        appendCharacters ac = new appendCharacters();
        String s = "coaching";
        String t = "coding";
        System.out.println(ac.appendCharactersSubsequence(s, t));
        
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
