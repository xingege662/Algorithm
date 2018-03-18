package of14;

/**
 * Created by xinchang on 2018/3/17.
 */

/**
 *  /**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
 *
 * @param arr 输入的数组
 */

public class of14 {

    public static int[] reorderOddEven(int[] arr){

        if (null == arr || arr.length == 0) {
            return arr;
        }

        int start = 0 ;
        int end = arr.length - 1;

        while (start < end) {

            while (start < end && arr[start] % 2 != 0) {
                start++;
            }

            while (start < end && arr[end] % 2 == 0) {
                end--;
            }

            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }

        return arr;
    }

    public static void printArr(int[] arr) {
        for(int i = 0 ; i < arr.length ;i++) {
            System.out.print(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
       printArr(reorderOddEven(arr));
    }
}
