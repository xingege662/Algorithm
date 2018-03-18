package of09;

/**
 * Created by xinchang on 2018/3/7.
 */

/**
 * 斐波那契序列  O（n）时间O（1）空间实现：
 */
public class of09 {
    public static int fibonaqie(int n){


        if (n <= 0) {
            return 0;
        }

        if(n == 1 || n == 2){
            return  1;
        }

        int prepre = 1 ;

        int pre = 1 ;

        int current = 2;

        for(int i = 3 ; i <= n ; i++) {
            current = pre + prepre;
            prepre = pre;
            pre = current;
        }

        return current;

    }

    public static void main(String[] args) {
        System.out.println(fibonaqie(0));
        System.out.println(fibonaqie(1));
        System.out.println(fibonaqie(2));
        System.out.println(fibonaqie(3));
        System.out.println(fibonaqie(4));
        System.out.println(fibonaqie(5));
        System.out.println(fibonaqie(6));
        System.out.println(fibonaqie(7));
    }

}
