package of51;

/**
 * Created by xinchang on 2018/3/21.
 */

import java.util.LinkedList;

/**
 * 题目：从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印一行。
 解题思路
 　　用一个队列来保存将要打印的结点。为了把二叉树的每一行单独打印到一行里，我们需要两个变量：一个变量表示在当前的层中还没有打印的结点数，另一个变量表示下一次结点的数目。
 */
public class cankao {

    private static class BinaryTreeNode {
        private int val;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        public BinaryTreeNode() {
        }

        public BinaryTreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }


    public static void printNode(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return;
        }

        LinkedList<BinaryTreeNode> linkedList = new LinkedList<>();

        BinaryTreeNode node = null;
        int curCount = 1;

        int nextCount = 0;

        linkedList.add(binaryTreeNode);

        while (linkedList.size() > 0) {

             node = linkedList.remove();
            System.out.print(node.val+"  ");
            curCount--;

            if (node.left != null) {
                linkedList.add(node.left);
                nextCount++;
            }

            if (node.right != null) {
                linkedList.add(node.right);
                nextCount++;
            }

            if (curCount == 0) {
                System.out.println();
                curCount = nextCount;
                nextCount = 0;
            }
        }
    }
    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(7);
        BinaryTreeNode n8 = new BinaryTreeNode(8);
        BinaryTreeNode n9 = new BinaryTreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;

        printNode(n1);

    }
}
