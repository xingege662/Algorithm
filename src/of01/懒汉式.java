package of01;

/**
 * 构建单例模式
 */
public class 懒汉式 {
    // 懒汉式
    private static volatile 懒汉式 main = null;

    private 懒汉式(){

    }

    public static 懒汉式 getInstance(){
        if (main == null) {
            synchronized (懒汉式.class) {
                if (main == null) {
                    main = new 懒汉式();
                }
            }
        }
        return main;
    }

    public static void main(String[] args) {
        System.out.println(懒汉式.getInstance().toString());
        System.out.println(懒汉式.getInstance().toString());
        System.out.println(懒汉式.getInstance().toString());
    }
}
