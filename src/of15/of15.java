package of15;

/**
 * Created by xinchang on 2018/3/17.
 */

/**
 * 输入一个键表，输出该链表中倒数第k 个结点．为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾结点是倒数第1个结点．例如一个链表有6个结点，
 * 从头结点开始它们的值依次是1、2、3、4、5 6。这个链表的倒数第3个结点是值为4的结点．
 *
 * @param head 链表的头结点
 * @param k    倒数第k个结点
 * @return 倒数第k个结点
 */
public class of15 {

    static class  Node{
        private int data;
        private Node next;
    }


    public static Node findKthToTail(Node head, int k) {

        if (head == null || k < 1) {
            return null;
        }

        Node pointer = head;

        for(int i = 1 ; i < k; i++) {
            if (pointer.next != null) {
                pointer = pointer.next;
            }else{
                return null;
            }
        }


        while (pointer.next != null) {
            head = head.next;
            pointer = pointer.next;
        }

        return head;
    }


    public static void main(String[] args) {
        Node head = new Node();
        head.data = 1;

        head.next = new Node();
        head.next.data = 2;

        head.next.next = new Node();
        head.next.next.data = 3;

        head.next.next.next = new Node();
        head.next.next.next.data = 4;

        head.next.next.next.next = new Node();
        head.next.next.next.next.data = 5;

        head.next.next.next.next.next = new Node();
        head.next.next.next.next.next.data = 6;

        head.next.next.next.next.next.next = new Node();
        head.next.next.next.next.next.next.data = 7;

        head.next.next.next.next.next.next.next = new Node();
        head.next.next.next.next.next.next.next.data = 8;

        head.next.next.next.next.next.next.next.next = new Node();
        head.next.next.next.next.next.next.next.next.data = 9;

        System.out.println(findKthToTail(head, 1).data); // 倒数第一个
        System.out.println(findKthToTail(head, 5).data); // 中间的一个
        System.out.println(findKthToTail(head, 9).data); // 倒数最后一个就是顺数第一个

        System.out.println(findKthToTail(head, 10));
    }

}
