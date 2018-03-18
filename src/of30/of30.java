package of30;

/**
 * Created by xinchang on 2018/3/18.
 */
public class of30 {

    public static boolean isUgly(int num){

        while (num % 2 == 0) {
            num /= 2;
        }

        while (num % 3 == 0) {
            num /= 3;
        }

        while (num % 5 == 0) {
            num/=5;
        }

        return num == 1;

    }


    public static int getUglyNmber(int index) {
        if (index == 0) {
            return 0 ;
        }
        
        int uglyFound = 0 ;
        
        int num = 0 ;

        while (uglyFound < index) {
            num ++ ;

            if (isUgly(num)) {
                uglyFound++;
            }
        }
        
        return num;
        
        
    }
    public static void main(String[] args) {
        System.out.println("Solution 1:");
        test1();
        System.out.println();

//        System.out.println("Solution 2:");
//        test2();
    }

    private static void test1() {
        System.out.println(getUglyNmber(1)); // 1
        System.out.println(getUglyNmber(2)); // 2
        System.out.println(getUglyNmber(3)); // 3
        System.out.println(getUglyNmber(4)); // 4
        System.out.println(getUglyNmber(5)); // 5
        System.out.println(getUglyNmber(6)); // 6
        System.out.println(getUglyNmber(7)); // 8
        System.out.println(getUglyNmber(8)); // 9
        System.out.println(getUglyNmber(9)); // 10
        System.out.println(getUglyNmber(10)); // 12
        System.out.println(getUglyNmber(11)); // 15
        System.out.println(getUglyNmber(1500)); // 859963392
        System.out.println(getUglyNmber(0)); // 0
    }

//    private static void test2() {
//        System.out.println(getUglyNmber2(1)); // 1
//        System.out.println(getUglyNmber2(2)); // 2
//        System.out.println(getUglyNmber2(3)); // 3
//        System.out.println(getUglyNmber2(4)); // 4
//        System.out.println(getUglyNmber2(5)); // 5
//        System.out.println(getUglyNmber2(6)); // 6
//        System.out.println(getUglyNmber2(7)); // 8
//        System.out.println(getUglyNmber2(8)); // 9
//        System.out.println(getUglyNmber2(9)); // 10
//        System.out.println(getUglyNmber2(10)); // 12
//        System.out.println(getUglyNmber2(11)); // 15
//        System.out.println(getUglyNmber2(1500)); // 859963392
//        System.out.println(getUglyNmber2(0)); // 0
//    }
}
