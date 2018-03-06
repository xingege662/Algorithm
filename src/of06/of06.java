package of06;

/**
 * Created by xinchang on 2018/3/6.
 */


import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 */
public class of06<T> {

    private Stack<T> stack1 = new Stack<T>();

    private Stack<T> stack2 = new Stack<T>();

    public void appendTail(T data){
        stack1.push(data);
    }


    public T deleteHead(){


        if (!stack2.isEmpty()) {
            return stack2.pop();
        }


        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // 如果弹出栈中还没有数据就抛出异常
        if (stack2.isEmpty()) {
            throw new RuntimeException("No more element.");
        }

        return stack2.pop();
    }


    public static void main(String[] args) {

    }

}
