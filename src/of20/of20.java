package of20;

import java.util.Stack;

/**
 * Created by xinchang on 2018/3/17.
 */
public class of20 {

    public static boolean isPopOrder(int[] push, int[] pop) {

        if (push == null || pop == null || push.length == 0 || pop.length == 0 || push.length != pop.length) {
            return false;
        }


        int popIndex = 0;

        int pushIndex = 0;

        Stack<Integer> stack = new Stack<>();

        while (popIndex < pop.length) {

            while (pushIndex < push.length && (stack.isEmpty() || stack.peek() != pop[popIndex])) {

                stack.push(push[pushIndex]);
                pushIndex++;
            }

            if (stack.peek() == pop[popIndex]) {
                stack.pop();
                popIndex++;
            } else {
                return false;
            }


        }

        return true;
    }


    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {3, 5, 4, 2, 1};
        int[] pop3 = {4, 3, 5, 1, 2};
        int[] pop4 = {3, 5, 4, 1, 2};

        System.out.println("true: " + isPopOrder(push, pop1));
        System.out.println("true: " + isPopOrder(push, pop2));
        System.out.println("false: " + isPopOrder(push, pop3));
        System.out.println("false: " + isPopOrder(push, pop4));

        int[] push5 = {1};
        int[] pop5 = {2};
        System.out.println("false: " + isPopOrder(push5, pop5));

        int[] push6 = {1};
        int[] pop6 = {1};
        System.out.println("true: " + isPopOrder(push6, pop6));

        System.out.println("false: " + isPopOrder(null, null));

        // 测试方法2
        System.out.println();
        System.out.println("true: " + isPopOrder(push, pop1));
        System.out.println("true: " + isPopOrder(push, pop2));
        System.out.println("false: " + isPopOrder(push, pop3));
        System.out.println("false: " + isPopOrder(push, pop4));
        System.out.println("false: " + isPopOrder(push5, pop5));
        System.out.println("true: " + isPopOrder(push6, pop6));
        System.out.println("false: " + isPopOrder(null, null));
    }
}
