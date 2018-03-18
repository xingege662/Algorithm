package of16;

/**
 * Created by xinchang on 2018/3/17.
 */

/**
 *  /**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
 *
 * @param head1 第一个有序链表
 * @param head2 第二个有序链表
 * @return 合并后的有序链表头
 */

public class of16 {

    static class Node{
        public int data;
        public Node next;
    }



    public static Node merge(Node head1 ,Node head2){
        if (head1 == null) {
            return head2;
        }
        
        if (head2 == null) {
            return head1;
        }

        Node root = new Node();

        Node pointer = root;

        while(head1 != null && head2 != null){
            if (head1.data < head2.data) {
                pointer.next = head1;
                head1 = head1.next;
            }else{
                pointer.next = head2;
                head2 = head2.next;
            }
            pointer = pointer.next;
        }


        if (head1 != null) {
            pointer.next = head1;
        }

        if (head2 != null) {
            pointer.next = head2;
        }
        return root.next;
    }
    /**
     * 输出链表的元素值
     *
     * @param head 链表的头结点
     */
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println("null");
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


        Node head2 = new Node();
        head2.data = 1;

        head2.next = new Node();
        head2.next.data = 3;

        head2.next.next = new Node();
        head2.next.next.data = 5;

        head2.next.next.next = new Node();
        head2.next.next.next.data = 6;

        head2.next.next.next.next = new Node();
        head2.next.next.next.next.data = 7;

//        head = merge(head, head2);
        head = merge(head, head2);
        printList(head);
    }

}
