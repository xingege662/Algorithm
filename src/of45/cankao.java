package of45;

/**
 * Created by xinchang on 2018/3/20.
 */

/**
 * 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class cankao {
    private static void swap(int[] data, int x, int y) {
        int tmp = data[x];
        data[x] = data[y];
        data[y] = tmp;
    }

    public static void main(String[] args) {
        int[] numbers1 = {2, 1, 3, 1, 4};
        System.out.println(duplicate(numbers1));

        int[] numbers2 = {2, 4, 3, 1, 4};
        System.out.println(duplicate(numbers2));

        int[] numbers3 = {2, 4, 2, 1, 4};
        System.out.println(duplicate(numbers3));

        int[] numbers4 = {2, 1, 3, 0, 4};
        System.out.println(duplicate(numbers4));

        int[] numbers5 = {2, 1, 3, 5, 4};
        System.out.println(duplicate(numbers5));
    }

    private static int duplicate(int[] data){
        if(data == null || data.length < 1){
            return  -1;
        }

        for(int i= 0 ; i < data.length ;i++) {
            if (i < 0 || i >= data.length) {
                return -1;
            }
        }

        for(int i = 0  ; i < data.length;i++) {
            while (data[i] != i) {
                if (data[i] == data[data[i]]) {//相等，有重复数字
                    return data[i];
                }else{
                    swap(data,i,data[i]);
                }
            }
        }

        return -1;
    }
}
