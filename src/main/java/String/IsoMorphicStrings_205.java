package String;

import java.util.HashMap;
import java.util.Map;

public class IsoMorphicStrings_205 {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        int i =0;
        Map<Character,Character> mp = new HashMap<>();
        Map<Character,Character> mp_t = new HashMap<>();

        while(i<s.length()){
            if(mp.containsKey(s.charAt(i))){
                if(t.charAt(i)!=mp.get(s.charAt(i)))return false;
            }else if(mp_t.containsKey(t.charAt(i))){
                if(s.charAt(i)!=mp_t.get(t.charAt(i)))return false;
            }else{
                mp.put(s.charAt(i),t.charAt(i));
                mp_t.put(t.charAt(i),s.charAt(i));
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc","baba"));
    }
}
