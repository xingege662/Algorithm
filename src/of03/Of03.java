package of03;

/**
 * Created by xinchang on 2017/12/27.
 * <p>
 * <p>
 * 在一个二维数组中，每一行都按照从左到右递增
 * 的顺序排序，每一列都按照从上到下递增的顺序排序。 * 请完成一个函数，输入这样的一个二维数组
 * 和一个整数，判断数组中是否含有该整数。
 */
public class Of03 {

    public static void main(String[] args) {
        int[][] arr={{1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}};
        System.out.println(isInclude(arr,16));
    }

    /**
     * 思路，先确定行，再确定列，先通过移动i来确定行，再通过移动j来确定列
     * @param arr
     * @param value
     * @return
     */
    public static boolean isInclude(int[][] arr, int value) {

        int rowLenth = arr.length; //行的长度

        int columnLent = arr[0].length; //列的长度

        int i = 0;

        int j = columnLent - 1;

        while (i <= rowLenth - 1 && j >= 0) {
            if (arr[i][j] == value) {
                return true;
            }

            if (arr[i][j] > value) {
                j--;
            } else {
                i++;
            }
        }

        return  false;
    }
}
