package of08; /**
 * Created by xinchang on 2018/3/6.
 */

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾， 我们称之数组的旋转。输入一个递增排序的数组的一个旋转， 输出旋转数组的最小元素。例如数组{3，4, 5, 1, 2 ｝为｛ l1,2,3, 4，5}的一个旋转，该数组的最小值为1
 */
public class of08 {

    public static int min(int[] numbers) {
        if (null == numbers || numbers.length == 0) {
           throw new RuntimeException("输入参数错误");
        }

        int low = 0;
        int high = numbers.length - 1;
        int middle = low;

        while (numbers[low] >= numbers[high]) {

            //如果numbers的长度只有两个
            if (high - low == 1) {
                return numbers[high];
            }

            middle = low + (high - low) / 2;

            //如果3个元素都相等，则循环遍历，找出最小的
            if (numbers[low] == numbers[middle] && numbers[high] == numbers[middle]) {
                return orderMin(numbers, low, high);
            }

            if (numbers[low] <= numbers[middle]) {
                low = middle;
            }

            if(numbers[high] >= numbers[middle]){
                high = middle;
            }


        }

        return numbers[middle];

    }

    private static int orderMin(int[] numbers, int low, int high) {
        int length = numbers.length - 1;
        int result = numbers[0];
        for (int i = 1; i < length; i++) {
            if (result > numbers[i]) {
                result = numbers[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // 典型输入，单调升序的数组的一个旋转
        int[] array1 = {3, 4, 5, 1, 2};
        System.out.println(min(array1));

        // 有重复数字，并且重复的数字刚好的最小的数字
        int[] array2 = {3, 4, 5, 1, 1, 2};
        System.out.println(min(array2));

        // 有重复数字，但重复的数字不是第一个数字和最后一个数字
        int[] array3 = {3, 4, 5, 1, 2, 2};
        System.out.println(min(array3));

        // 有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字
        int[] array4 = {1, 0, 1, 1, 1};
        System.out.println(min(array4));
//
        // 单调升序数组，旋转0个元素，也就是单调升序数组本身
        int[] array5 = {1, 2, 3, 4, 5};
        System.out.println(min(array5));

//        // 数组中只有一个数字
        int[] array6 = {2};
        System.out.println(min(array6));
//
//        // 数组中数字都相同
        int[] array7 = {1, 1, 1, 1, 1, 1, 1};
        System.out.println(min(array7));
//
        // 输入NULL
//        System.out.println(min(null));


    }

}
