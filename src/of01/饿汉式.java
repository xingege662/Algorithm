package of01;

/**
 * Created by xinchang on 2017/12/25.
 */
public class 饿汉式 {
    private static 饿汉式 e = new 饿汉式();

    private 饿汉式(){

    }

    public static 饿汉式 getInstance(){
        return  e;
    }

    public static void main(String[] args) {
        System.out.println(饿汉式.getInstance());
        System.out.println(饿汉式.getInstance());
        System.out.println(饿汉式.getInstance());
        System.out.println(饿汉式.getInstance());

    }
}
