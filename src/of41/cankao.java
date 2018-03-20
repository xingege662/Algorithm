package of41;

/**
 * Created by xinchang on 2018/3/19.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * 题目：0, 1, … , n-1 这n个数字排成一个圈圈，从数字0开始每次从圆圏里删除第m个数字。求出这个圈圈里剩下的最后一个数字。
 */
public class cankao {

    /**
     * 解题思路
     第一种：经典的解法， 用环形链表模拟圆圈。
     　　创建一个总共有n 个结点的环形链表，然后每次在这个链表中删除第m 个结点。
     */

    public static int lastRemaining(int n ,int m){

        if (n < 1 || m < 1) {
            return -1;
        }

        List<Integer> list = new LinkedList<>();

        for(int i = 0 ; i < n ;i++) {
            list.add(i);
        }

        int idx = 0;

        int start = 0 ;

        while (list.size() > 1) {
            for(int i = 1 ;i < m ; i++) {
                idx = (idx+1) % list.size();
            }

            list.remove(idx);
        }

        return list.get(0);
    }


    public static int lastRemaining2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        int last = 0;
        for (int i = 2; i <=n ; i++) {
            last = (last + m)%i;
        }

        return last;
    }
}
