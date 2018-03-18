package of21;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xinchang on 2018/3/17.
 */
public class of21 {

    
    static class BinaryTreeNode{
        BinaryTreeNode left;
        BinaryTreeNode right;
        int data;
    }
    
    public static void printFromToBottom(BinaryTreeNode node){

        if (node != null) {
            Queue<BinaryTreeNode> queue = new LinkedList<>();
            queue.add(node);
            BinaryTreeNode curNode;
            while (!queue.isEmpty()) {
                curNode = queue.remove();
                System.out.print(curNode.data+"   ");
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
        }
        
    }

    public static void main(String[] args) {

        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        BinaryTreeNode root = new BinaryTreeNode();
        root.data = 8;
        root.left = new BinaryTreeNode();
        root.left.data = 6;
        root.left.left = new BinaryTreeNode();
        root.left.left.data = 5;
        root.left.right = new BinaryTreeNode();
        root.left.right.data = 7;
        root.right = new BinaryTreeNode();
        root.right.data = 10;
        root.right.left = new BinaryTreeNode();
        root.right.left.data = 9;
        root.right.right = new BinaryTreeNode();
        root.right.right.data = 11;
        printFromToBottom(root);

        //         1
        //        /
        //       3
        //      /
        //     5
        //    /
        //   7
        //  /
        // 9
        BinaryTreeNode root2 = new BinaryTreeNode();
        root2.data = 1;
        root2.left = new BinaryTreeNode();
        root2.left.data = 3;
        root2.left.left = new BinaryTreeNode();
        root2.left.left.data = 5;
        root2.left.left.left = new BinaryTreeNode();
        root2.left.left.left.data = 7;
        root2.left.left.left.left = new BinaryTreeNode();
        root2.left.left.left.left.data = 9;
        System.out.println("\n");
        printFromToBottom(root2);

        // 0
        //  \
        //   2
        //    \
        //     4
        //      \
        //       6
        //        \
        //         8
        BinaryTreeNode root3 = new BinaryTreeNode();
        root3.data = 0;
        root3.right = new BinaryTreeNode();
        root3.right.data = 2;
        root3.right.right = new BinaryTreeNode();
        root3.right.right.data = 4;
        root3.right.right.right = new BinaryTreeNode();
        root3.right.right.right.data = 6;
        root3.right.right.right.right = new BinaryTreeNode();
        root3.right.right.right.right.data = 8;
        System.out.println("\n");
        printFromToBottom(root3);

        // 1
        BinaryTreeNode root4 = new BinaryTreeNode();
        root4.data = 1;
        System.out.println("\n");
        printFromToBottom(root4);

        // null
        System.out.println("\n");
        printFromToBottom(null);

    }
}
