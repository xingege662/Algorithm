package of46;

/**
 * Created by xinchang on 2018/3/20.
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 题目：请实现一个函数用来找出字符流中第一个只出现一次的字符
 * 例如，当从字符流中只读出前两个字符“go”时，第一个只出现一次的字符是‘g’。当从该字符流中读出前六个字符“google”时，第一个只出现1次的字符是”l”。
 */
public class cankao {

    public static String getFirstOnlyCharCode(String data){

        if (data == null || data.length() == 0) {
            return null;
        }
        Map<Character, Integer> map = new LinkedHashMap<>();

        for(int i = 0 ; i < data.length();i++) {
            if (map.containsKey(data.charAt(i))) {
                map.remove(data.charAt(i));
            }else{
                map.put(data.charAt(i), 1);
            }
        }

        if(map.size() > 0){
            return map.keySet().iterator().next().toString();
        }else{
            return "不存在";
        }

    }
    public static void main(String[] args) {
//        System.out.println( getFirstOnlyCharCode("")); // '\0'
        System.out.println( getFirstOnlyCharCode("g")); // 'g'
        System.out.println( getFirstOnlyCharCode("go")); // 'g'
        System.out.println( getFirstOnlyCharCode("goo")); // 'g'
//        System.out.println( getFirstOnlyCharCode("goog")); // '\0'
        System.out.println( getFirstOnlyCharCode("googl")); // l
        System.out.println( getFirstOnlyCharCode("google")); // l
    }
}
