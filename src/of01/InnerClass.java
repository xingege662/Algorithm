package of01;

/**
 * Created by xinchang on 2017/12/25.
 */
public class InnerClass {


    private InnerClass() {

    }

    public static class InstanceClass {
        private static InnerClass innerClass = new InnerClass();
    }

    public static InnerClass getInstance(){
        return InstanceClass.innerClass;
    }


    public static void main(String[] args) {
        System.out.println(InnerClass.getInstance());
        System.out.println(InnerClass.getInstance());
        System.out.println(InnerClass.getInstance());
        System.out.println(InnerClass.getInstance());
        System.out.println(InnerClass.getInstance());
        System.out.println(InnerClass.getInstance());

    }
}
