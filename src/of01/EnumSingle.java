package of01;

/**
 * Created by xinchang on 2017/12/25.
 */
public enum  EnumSingle {
    EnumSingleLeton;

    public static EnumSingle getInstance(){
        return EnumSingleLeton;
    }

    public static void main(String[] args){
        System.out.println(EnumSingle.getInstance().toString());
        System.out.println(EnumSingle.getInstance().toString());
        System.out.println(EnumSingle.getInstance().toString());
        System.out.println(EnumSingle.getInstance().toString());
    }

}
