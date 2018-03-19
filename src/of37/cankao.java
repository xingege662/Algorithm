package of37;

/**
 * Created by xinchang on 2018/3/19.
 */

import java.util.ArrayList;
import java.util.List;


public class cankao {

    /**
     * * 题目一：输入一个递增排序的数组和一个数字s，在数组中查找两个数，得它们的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
     * 举例说明
     * 例如输入数组｛1 、2 、4、7 、11 、15 ｝和数字15. 由于4+ 11 = 15 ，因此输出4 和11 。
     *
     * @param data
     * @param sum
     * @return
     */
    public static List<Integer> findNumberWithSum(int data[], int sum) {

        List<Integer> list = new ArrayList<>();

        if (data == null || data.length < 2) {
            return list;
        }

        int start = 0;
        int end = data.length - 1;

        while (start < end) {
            long currentSum = data[start] + data[end];
            if (currentSum == sum) {
                list.add(data[start]);
                list.add(data[end]);
                return list;
            } else if (currentSum < sum) {
                start++;
            } else {
                end--;
            }
        }
        return list;
    }


    /**
     * 题目二：输入一个正数s，打印出所有和为s 的连续正数序列（至少两个数）。
     * 举例说明
     * 例如输入15，由于1+2+3+4+5=4＋5+6＝7+8=15，所以结果打出3 个连续序列1～5、4～6 和7～8。
     */


    public static List<List<Integer>> findContinuousSequence(int sum) {

        List<List<Integer>> lists = new ArrayList<>();

        if (sum < 3) {
            return lists;
        }

        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        int curSum = small + big;

        while (small < middle) {
            if (curSum == sum) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = small; i <=big; i++) {
                    arrayList.add(i);
                }
                lists.add(arrayList);
            }

            while (curSum > sum && small < middle) {
                curSum -= small;
                small++;
                if (curSum == sum) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int i = small; i <=big; i++) {
                        arrayList.add(i);
                    }
                    lists.add(arrayList);
                }
            }
            big++;
            curSum += big;
        }
        return  lists;
    }

    public static void main(String[] args) {
        test01();
        System.out.println("---------------");
        test02();
    }

    private static void test01() {
        int[] data1 = {1, 2, 4, 7, 11, 15};
        System.out.println(findNumberWithSum(data1, 15));

        int[] data2 = {1, 2, 4, 7, 11, 16};
        System.out.println(findNumberWithSum(data2, 17));

        int[] data3 = {1, 2, 4, 7, 11, 16};
        System.out.println(findNumberWithSum(data3, 10));
    }

    public static void test02(){
        System.out.println(findContinuousSequence(1));
        System.out.println(findContinuousSequence(3));
        System.out.println(findContinuousSequence(4));
        System.out.println(findContinuousSequence(9));
        System.out.println(findContinuousSequence(15));
        System.out.println(findContinuousSequence(100));
    }
}
