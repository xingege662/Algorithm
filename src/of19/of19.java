package of19;

import java.util.Stack;

/**
 * Created by xinchang on 2018/3/17.
 */
public class of19 {
    public static class StackWithMin {
        Stack<Integer> dataStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();


        public void push(int item) {
            dataStack.push(item);
            if (minStack.size() == 0|| minStack.peek() >(int)item) {
                minStack.push((int)item);
            }else{
                minStack.push(minStack.peek());
            }
        }


        public Integer pop(){
            if (dataStack != null && !dataStack.isEmpty()) {
                minStack.pop();
                return dataStack.pop();
            }
            return null;
        }

        public Integer min(){
            if (minStack != null && !minStack.isEmpty()) {
                return (int)minStack.peek();
            }
            return null;
        }



    }

    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(3);
        System.out.println(stack.min() == 3);
        stack.push(4);
        System.out.println(stack.min() == 3);
        stack.push(2);
        System.out.println(stack.min() == 2);
        stack.push(3);
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 3);
        stack.push(0);
        System.out.println(stack.min() == 0);
    }

}
