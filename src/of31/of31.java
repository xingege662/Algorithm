package of31;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by xinchang on 2018/3/18.
 */
public class of31 {

    public static char findFirstCode(String s) {

        if (s == null || s.length() == 0) {
            throw new RuntimeException("入参错误");
        }

        Map<Character, Integer> map = new LinkedHashMap<>();

        for(int i = 0 ; i < s.length() ;i++) {
            char indexAt = s.charAt(i);
            if (map.containsKey(indexAt)) {
                map.put(indexAt, -1);
            }else{
                map.put(indexAt, 1);
            }
        }

        Set<Map.Entry<Character, Integer>> entries =
                map.entrySet();
        char result = '\0';
        for(Map.Entry<Character,Integer> entry :entries){
            if (entry.getValue() >= 0) {
                result = entry.getKey();
                break;
            }
        }
        return result;

    }
    public static void main(String[] args) {
        System.out.println(findFirstCode("google")); // l
        System.out.println(findFirstCode("aabccdbd")); // '\0'
        System.out.println(findFirstCode("abcdefg")); // a
        System.out.println(findFirstCode("gfedcba")); // g
        System.out.println(findFirstCode("zgfedcba")); // g
    }

}
