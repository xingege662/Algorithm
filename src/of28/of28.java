package of28;

/**
 * Created by xinchang on 2018/3/18.
 */
public class of28 {

    public static int findGreatestSumOfSubArray(int[] arr){

        if (arr == null || arr.length == 0) {
            throw new RuntimeException("入参不正确");
        }

        int maxSum = Integer.MIN_VALUE ;
        int curSum = 0 ;

        for(int i=0 ; i<arr.length ;i++) {
            if (curSum <= 0) {
                curSum = arr[i];
            }else{
               curSum = curSum + arr[i];
            }

            if (maxSum < curSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] data = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] data2 = {-2, -8, -1, -5, -9};
        int[] data3 = {2, 8, 1, 5, 9};

        System.out.println(findGreatestSumOfSubArray(data));
        System.out.println(findGreatestSumOfSubArray(data2));
        System.out.println(findGreatestSumOfSubArray(data3));
    }
}
