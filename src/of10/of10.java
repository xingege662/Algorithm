package of10;

/**
 * Created by xinchang on 2018/3/7.
 */
public class of10 {


    public static int numberForOne(int n){
        int reult = 0;
        for(int i = 0 ; i < 32 ; i++){
            reult = reult + (n & 1);
            n >>>= 1;
        }
        return reult;
    }


    public static int numberForTwo(int n){
        int result = 0 ;

        while (n != 0) {
            result ++ ;
            n = n & (n - 1);
        }

        return result;
    }



    public static void main(String[] args) {
        System.out.println(numberForOne(0B00000000_00000000_00000000_00000000)); // 0
        System.out.println(numberForOne(0B00000000_00000000_00000000_00000001)); // 1
        System.out.println(numberForOne(0B11111111_11111111_11111111_11111111)); // -1


        System.out.println(numberForTwo(0B00000000_00000000_00000000_00000000)); // 0
        System.out.println(numberForTwo(0B00000000_00000000_00000000_00000001)); // 1
        System.out.println(numberForTwo(0B11111111_11111111_11111111_11111111)); // -1

        System.out.println(-2 >> 1);
    }
}
