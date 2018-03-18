package of12;

/**
 * Created by xinchang on 2018/3/7.
 */

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

/**
 * 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3 一直到最大的3位数即999。
 *
 * @param n 数字的最大位数
 */
public class of12 {

    public static int caculateMaxNumber(int  n){

        int[] arr = new int[n];

        for(int i = 0 ; i < n ;i++) {
            arr[i] = 9;
        }

        int  maxNumber = 0 ;
        int  temp = n - 1;

        for(int i = 0  ; i < n ; i++ ,temp--) {
            maxNumber = (int) (maxNumber + arr[i] * Math.pow(10,temp));
        }


        for(int j = 1 ; j <= maxNumber ; j++) {
            System.out.println(j);
        }

        return maxNumber;

    }

    public static void main(String[] args) {
        caculateMaxNumber(2);
    }
}
