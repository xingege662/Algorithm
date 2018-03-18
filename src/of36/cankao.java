package of36;

/**
 * Created by xinchang on 2018/3/18.
 */

/**
 *
 * 题目一：输入一棵二叉树的根结点，求该树的深度。从根结点到叶子点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *题目二：输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树中任意结点的左右子树的深度相差不超过1 ，那么它就是一棵平衡二叉树。
 */
public class cankao {

    static class BinaryTreeNode{
        BinaryTreeNode left;
        BinaryTreeNode right;
        int data;
    }


    static int getDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0 ;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        return left > right ? left + 1 : right +1;
    }


    static boolean isBalance(BinaryTreeNode root){

        if (root == null) {
            return true;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        int diff = left - right;

        if (Math.abs(diff) > 1) {
            return false;
        }

        return true;

    }
}
