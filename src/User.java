/**
 * Created by xinchang on 2018/3/6.
 */
public class User {

    private String name;

    private String sex;

    private String age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public static class Builder{
        User user = new User();


        public  Builder buildName(String name){
            user.name = name;
            return this;
        }

        public Builder buildSex(String sex){
            user.sex = sex;
            return this;
        }

        public Builder builderAge(String age){
            user.age = age;
            return this;
        }

        public User create(){
            return user;
        }


    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public static void main(String[] args) {
        User user = new User.Builder().builderAge("2").buildName("张三").buildSex("nan").create();

        System.out.println(user.toString());
    }
}
