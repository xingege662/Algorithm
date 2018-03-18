package of13;

/**
 * Created by xinchang on 2018/3/17.
 */

/**
 * /**
 * 给定单向链表的头指针和一个结点指针，定义一个函数在0(1)时间删除该结点,
 * 【注意1：这个方法和文本上的不一样，书上的没有返回值，这个因为JAVA引用传递的原因，
 * 如果删除的结点是头结点，如果不采用返回值的方式，那么头结点永远删除不了】
 * 【注意2：输入的待删除结点必须是待链表中的结点，否则会引起错误，这个条件由用户进行保证】
 *
 * @param head        链表表的头
 * @param toBeDeleted 待删除的结点
 * @return 删除后的头结点
 */

public class of13 {

   

    public static Node delete(Node head,Node node){

        if (node == null || head == null) {
            return head;
        }

        if (node == head) {
            return head.next;
        }

        //尾节点
        if (node.next == null) {
            Node tempNode = head;
            while (tempNode.next != node) {
                tempNode = tempNode.next;
            }
            tempNode.next = null;
        }else{//删除中间的节点
            node.data = node.next.data;
            node.next = node.next.next;
        }

        return head;

    }

    static class  Node{
        public int data;
        public Node next;
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

        Node middle = head.next.next.next.next = new Node();
        head.next.next.next.next.data = 5;

        head.next.next.next.next.next = new Node();
        head.next.next.next.next.next.data = 6;

        head.next.next.next.next.next.next = new Node();
        head.next.next.next.next.next.next.data = 7;

        head.next.next.next.next.next.next.next = new Node();
        head.next.next.next.next.next.next.next.data = 8;

        Node last = head.next.next.next.next.next.next.next.next = new Node();
        head.next.next.next.next.next.next.next.next.data = 9;

        head = delete(head, null); // 删除的结点为空
        printList(head);
        Node node = new Node();
        node.data = 12;

        head = delete(head, head); // 删除头结点
        printList(head);
        head = delete(head, last); // 删除尾结点
        printList(head);
        head = delete(head, middle); // 删除中间结点
        printList(head);
//
        head = delete(head, node); // 删除的结点不在链表中
        printList(head);
    }
}
