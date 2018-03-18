package of24;

/**
 * Created by xinchang on 2018/3/18.
 */
public class of24 {

    static class BinaryTreeNdde{
        BinaryTreeNdde leftNode;
        BinaryTreeNdde rightNode;
        int data;
    }

    public static BinaryTreeNdde convertNodeNode(BinaryTreeNdde node) {
        BinaryTreeNdde[] BinaryTreeNddes = new BinaryTreeNdde[1];
        convertNodeNode(node, BinaryTreeNddes);


        BinaryTreeNdde head = BinaryTreeNddes[0];
        while (head != null && head.leftNode != null) {
            head = head.leftNode;
        }

        return head;
    }

    private static void convertNodeNode(BinaryTreeNdde node, BinaryTreeNdde[] BinaryTreeNddes) {
        if (node != null) {

            if(node.leftNode!=null) {
                convertNodeNode(node.leftNode, BinaryTreeNddes);
            }


            node.leftNode = BinaryTreeNddes[0];

            if (BinaryTreeNddes[0] != null) {
                BinaryTreeNddes[0].rightNode = node;
            }


            BinaryTreeNddes[0] = node;

            if (node.rightNode != null) {
                convertNodeNode(node.rightNode, BinaryTreeNddes);
            }

        }


    }

    public static void main(String[] args) {
        test01();
        test02();
        test03();
        test04();
        test05();
    }

    private static void printList(BinaryTreeNdde head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.rightNode;
        }

        System.out.println("null");
    }

    private static void printTree(BinaryTreeNdde root) {
        if (root != null) {
            printTree(root.leftNode);
            System.out.print(root.data + "->");
            printTree(root.rightNode);
        }
    }


    //            10
    //         /      \
    //        6        14
    //       /\        /\
    //      4  8     12  16
    private static void test01() {
        BinaryTreeNdde node10 = new BinaryTreeNdde();
        node10.data = 10;

        BinaryTreeNdde node6 = new BinaryTreeNdde();
        node6.data = 6;

        BinaryTreeNdde node14 = new BinaryTreeNdde();
        node14.data = 14;

        BinaryTreeNdde node4 = new BinaryTreeNdde();
        node4.data = 4;

        BinaryTreeNdde node8 = new BinaryTreeNdde();
        node8.data = 8;

        BinaryTreeNdde node12 = new BinaryTreeNdde();
        node12.data = 12;

        BinaryTreeNdde node16 = new BinaryTreeNdde();
        node16.data = 16;

        node10.leftNode = node6;
        node10.rightNode = node14;

        node6.leftNode = node4;
        node6.rightNode = node8;

        node14.leftNode = node12;
        node14.rightNode = node16;

        System.out.print("Before convertNode: ");
        printTree(node10);
        System.out.println("null");
        BinaryTreeNdde head = convertNodeNode(node10);
        System.out.print("After convertNode : ");
        printList(head);
        System.out.println();

    }

    //               5
    //              /
    //             4
    //            /
    //           3
    //          /
    //         2
    //        /
    //       1
    private static void test02() {
        BinaryTreeNdde node1 = new BinaryTreeNdde();
        node1.data = 1;

        BinaryTreeNdde node2 = new BinaryTreeNdde();
        node2.data = 2;

        BinaryTreeNdde node3 = new BinaryTreeNdde();
        node3.data = 3;

        BinaryTreeNdde node4 = new BinaryTreeNdde();
        node4.data = 4;

        BinaryTreeNdde node5 = new BinaryTreeNdde();
        node5.data = 5;

        node5.leftNode = node4;
        node4.leftNode = node3;
        node3.leftNode = node2;
        node2.leftNode = node1;

        System.out.print("Before convertNode: ");
        printTree(node5);
        System.out.println("null");
        BinaryTreeNdde head = convertNodeNode(node5);
        System.out.print("After convertNode : ");
        printList(head);
        System.out.println();
    }

    // 1
    //  \
    //   2
    //    \
    //     3
    //      \
    //       4
    //        \
    //         5
    private static void test03() {
        BinaryTreeNdde node1 = new BinaryTreeNdde();
        node1.data = 1;

        BinaryTreeNdde node2 = new BinaryTreeNdde();
        node2.data = 2;

        BinaryTreeNdde node3 = new BinaryTreeNdde();
        node3.data = 3;

        BinaryTreeNdde node4 = new BinaryTreeNdde();
        node4.data = 4;

        BinaryTreeNdde node5 = new BinaryTreeNdde();
        node5.data = 5;

        node1.rightNode = node2;
        node2.rightNode = node3;
        node3.rightNode = node4;
        node4.rightNode = node5;

        System.out.print("Before convertNode: ");
        printTree(node1);
        System.out.println("null");
        BinaryTreeNdde head = convertNodeNode(node1);
        System.out.print("After convertNode : ");
        printList(head);
        System.out.println();
    }

    // 只有一个结点
    private static void test04() {
        BinaryTreeNdde node1 = new BinaryTreeNdde();
        node1.data = 1;

        System.out.print("Before convertNode: ");
        printTree(node1);
        System.out.println("null");
        BinaryTreeNdde head = convertNodeNode(node1);
        System.out.print("After convertNode : ");
        printList(head);
        System.out.println();
    }

    // 没有结点
    private static void test05() {
        System.out.print("Before convertNode: ");
        printTree(null);
        System.out.println("null");
        BinaryTreeNdde head = convertNodeNode(null);
        System.out.print("After convertNode : ");
        printList(head);
        System.out.println();
    }
}
