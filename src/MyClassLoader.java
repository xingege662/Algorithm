import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by xinchang on 2018/3/1.
 */
public class MyClassLoader extends ClassLoader {

    public String path;

    public MyClassLoader(String path) {
        this . path = path;
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        byte[] classData = loadClassData(name);//1
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            clazz= defineClass(name, classData, 0, classData.length);//2
        }
        return clazz;
    }

    private byte[] loadClassData(String name) {
        String fileName = getFileName(name);
        File file = new File(path,fileName);
        InputStream in=null;
        ByteArrayOutputStream out=null;
        try {
            in = new FileInputStream(file);
            out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length=0;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(in!=null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try{
                if(out!=null) {
                    out.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }
    private String getFileName(String name) {
        int index = name.lastIndexOf('.');
        if(index == -1){//如果没有找到'.'则直接在末尾添加.class
            return name+".class";
        }else{
            return name.substring(index+1)+".class";
        }
    }

    public static void main(String[]args) {

        MyClassLoader classLoader = new MyClassLoader("/Users/xinchang/job");
        try {
            Class<?> aClass = classLoader.loadClass("Job");
            if (null != aClass) {
                Object obj = aClass.newInstance();
                ClassLoader classLoader1 = obj.getClass().getClassLoader();
                System.out.println(classLoader1);

                Method method = obj.getClass().getDeclaredMethod("say");
                method.setAccessible(true);
                method.invoke(obj, null);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
