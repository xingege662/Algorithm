package of35;

/**
 * Created by xinchang on 2018/3/18.
 */
public class of35 {

    public static int getNumberOfK(int[] data, int k ){


        int number = 0;
        if (data != null && data.length > 0) {
            int first = getNumberOfFirstK(data, k, 0, data.length - 1);
            int last = getNumberOfEndK(data, k, 0, data.length - 1);

            if (first > -1 && last > -1) {
                number = last - first + 1;
            }
        }

        return number;

    }

    private static int getNumberOfEndK(int[] data, int k, int start, int end) {

        if (data == null || data.length < 1 || start > end) {
            return -1;
        }

        int midIdx = start + (end - start) / 2;
        int midData = data[midIdx];

        if (midData == k) {
            if (midIdx + 1 < data.length && data[midIdx + 1] != k || midIdx == data.length - 1) {
                return midIdx;
            } else {
                start = midIdx + 1;
            }
        } else if (midData < k) {
            start = midIdx + 1;
        } else {
            end = midIdx - 1;
        }
        return getNumberOfEndK(data, k, start, end);
    }

    private static int getNumberOfFirstK(int[] data, int k, int start, int end) {
        if (data == null || data.length < 1 || start > end) {
            return -1;
        }

        int midIdx = start + (end - start) / 2;
        int midData = data[midIdx];

        if (midData == k) {
            if (midIdx > 0 && data[midIdx - 1] != k || midIdx == 0) {
                return midIdx;
            } else {
                end = midIdx - 1;
            }
        } else if (midData > k) {
            end = midIdx - 1;
        } else {
            start = midIdx + 1;
        }


        return getNumberOfFirstK(data, k, start, end);
    }

    public static void main(String[] args) {
        // 查找的数字出现在数组的中间
        int[] data1 = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data1, 3)); // 4

        // 查找的数组出现在数组的开头
        int[] data2 = {3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data2, 3)); // 4

        // 查找的数组出现在数组的结尾
        int[] data3 = {1, 2, 3, 3, 3, 3};
        System.out.println(getNumberOfK(data3, 3)); // 4

        // 查找的数字不存在
        int[] data4 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data4, 2)); // 0

        // 查找的数字比第一个数字还小，不存在
        int[] data5 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data5, 0)); // 0

        // 查找的数字比最后一个数字还大，不存在
        int[] data6 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data6, 0)); // 0

        // 数组中的数字从头到尾都是查找的数字
        int[] data7 = {3, 3, 3, 3};
        System.out.println(getNumberOfK(data7, 3)); // 4

        // 数组中的数字从头到尾只有一个重复的数字，不是查找的数字
        int[] data8 = {3, 3, 3, 3};
        System.out.println(getNumberOfK(data8, 4)); // 0

        // 数组中只有一个数字，是查找的数字
        int[] data9 = {3};
        System.out.println(getNumberOfK(data9, 3)); // 1

        // 数组中只有一个数字，不是查找的数字
        int[] data10 = {3};
        System.out.println(getNumberOfK(data10, 4)); // 0
    }
}
