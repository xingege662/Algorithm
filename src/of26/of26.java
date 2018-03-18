package of26;

/**
 * Created by xinchang on 2018/3/18.
 */
public class of26 {

    public static int moreThanHalfNum(int[] num) {
        if (num == null || num.length == 0) {
            throw new RuntimeException("num不能为0");
        }

        int result = num[0];
        int count = 1;

        for(int i = 1 ; i < num.length ; i++) {
            if (count == 0) {
                result = num[i];
                count = 1;
            } else if (result == num[i]) {
                count++;
            }else{
                count--;
            }
        }

        count = 0 ;

        for(int number : num){
            if (number == result) {
                count++;
            }
        }

        if (count > num.length / 2) {
            return result;
        }else{
            throw new RuntimeException("输入有误");
        }

    }

    public static void main(String[] args) {
        // 存在出现次数超过数组长度一半的数字
        int numbers[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(moreThanHalfNum(numbers));

        // 出现次数超过数组长度一半的数字都出现在数组的前半部分
        int numbers2[] = {2, 2, 2, 2, 2, 1, 3, 4, 5};
        System.out.println(moreThanHalfNum(numbers2));

        // 出现次数超过数组长度一半的数字都出现在数组的后半部分
        int numbers3[] = {1, 3, 4, 5, 2, 2, 2, 2, 2};
        System.out.println(moreThanHalfNum(numbers3));

        // 只有一个数
        int numbers4[] = {1};
        System.out.println(moreThanHalfNum(numbers4));

        // 输入空指针
        moreThanHalfNum(null);
        // 不存在出现次数超过数组长度一半的数字
        int numbers5[] = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        moreThanHalfNum(numbers5);
    }
}
