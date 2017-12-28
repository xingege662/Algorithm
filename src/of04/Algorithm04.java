package of04;

/**
 * Created by xinchang on 2017/12/28.
 */

/**
 * 链表反转
 */
public class Algorithm04 {
    public static void main(String[] args) {
        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("E");

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        Node node = node1;
        while (node != null) {
            System.out.print(node.getData() + "      ");
            node = node.getNext();
        }

        System.out.println();

        Node newNode1 = reverseNodeList(node1);
        while (newNode1 != null) {
            System.out.print(newNode1.getData() + " ");
            newNode1 = newNode1.getNext();
        }
        System.out.println();


//        Node newNode = revserseNodeList2(node1);
//        while (newNode != null) {
//            System.out.print(newNode.getData() + " ");
//            newNode = newNode.getNext();
//        }
    }

    /**
     * 递归翻转
     *
     * @param
     * @return
     */
    public static Node reverseNodeList(Node head) {
        if (head.getNext() == null) {
            return head;
        }

        Node reverseHead = reverseNodeList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return reverseHead;
    }

    /**
     * 非递归   一个一个的移位，然后指向改变，最后把首个节点换了
     * @param node
     * @return
     */
    public static Node revserseNodeList2(Node node) {

        if (node == null) {
            return new Node("错误");
        }

        if (node.getNext() == null) {
            return node;
        }

        Node pre = node;
        Node cur = node.getNext();
        Node temp;

        while (cur != null) {
            temp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = temp;
        }
        node.setNext(null);
        return pre;
    }
}
