package of25;

/**
 * Created by xinchang on 2018/3/18.
 */
public class of25 {

    public static void premutaion(char[] chars) {
        if (chars == null && chars.length == 0) {
            return;
        }

        premutaion(chars, 0);
    }

    private static void premutaion(char[] chars, int begin) {
        if (begin == chars.length - 1) {
            System.out.println(new String(chars));
        } else {
            for (int i = begin; i < chars.length; i++) {
                char temp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = temp;

                premutaion(chars, begin + 1);
            }
        }
    }

    public static void main(String[] args) {
        char[] c1 = {'a', 'b', 'c'};
        premutaion(c1);
        System.out.println();

        char[] c2 = {'a', 'b', 'c', 'd'};
        premutaion(c2);
    }
}
