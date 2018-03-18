package of22;

/**
 * Created by xinchang on 2018/3/17.
 */
public class of22 {

    public static boolean virify(int[] arr){
        if (arr == null || arr.length == 0) {
            return  false;
        }
        return virify(arr, 0, arr.length - 1);
    }

    private static boolean virify(int[] arr, int start, int end) {

        if (start >= end) {
            return true;
        }

        int index = start ;

        //找左边的子树
        while(index < end - 1 && arr[index] < arr[end]){
            index++;
        }

        int right = index;

        while (index < end - 1 && arr[index] > arr[end]) {
            index++;
        }

        if (index != end - 1) {
            return false;
        }

        index = right;

        return virify(arr, start, index - 1) && virify(arr, index, end-1);

    }
    public static void main(String[] args) {
        //           10
        //         /   \
        //        6     14
        //       /\     /\
        //      4  8  12  16
        int[] data = {4, 8, 6, 12, 16, 14, 10};
        System.out.println("true: " + virify(data));

        //           5
        //          / \
        //         4   7
        //            /
        //           6
        int[] data2 = {4, 6, 7, 5};
        System.out.println("true: " + virify(data2));

        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        int[] data3 = {1, 2, 3, 4, 5};
        System.out.println("true: " + virify(data3));

        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        int[] data4 = {5, 4, 3, 2, 1};
        System.out.println("true: " + virify(data4));

        // 树中只有1个结点
        int[] data5 = {5};
        System.out.println("true: " + virify(data5));

        int[] data6 = {7, 4, 6, 5};
        System.out.println("false: " + virify(data6));

        int[] data7 = {4, 6, 12, 8, 16, 14, 10};
        System.out.println("false: " + virify(data7));
    }
}
