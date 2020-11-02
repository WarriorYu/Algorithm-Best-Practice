package exam;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/9/24
 * Describe :
 */
public class RemoveRepeatChar {
    public static void main(String[] args) {
        String s = "abacdcdeeffaegegdaggsadfrdf";
        System.out.println(removeRepeatChar(s));
    }

    private static String removeRepeatChar(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int firstIndex = s.indexOf(s.charAt(i));
            if (firstIndex == i) {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();

    }
   /* public static String quChong(String str){
        ArrayList<Character> ans = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<str.length();i++){
            char cur = str.charAt(i);
            if(!ans.contains(cur)){
                ans.add(cur);
                builder.append(cur);
            }
        }
        return builder.toString();
    }*/
}
