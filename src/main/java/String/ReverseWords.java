package String;

public class ReverseWords {

    //Function to reverse words in a given string.
    static String reverseWords(String S)
    {
        String s[] = S.split("\\.");
        StringBuilder str = new StringBuilder();
        for(int i=s.length-1; i>=0  ; i--){
            str.append(s[i]);
            if (i!=0){
                str.append(".");
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("i.like.this.program.very.much"));
    }
}
