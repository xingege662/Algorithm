package of23;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinchang on 2018/3/17.
 */
public class of23 {
    static class BinaryTreeNode {
        BinaryTreeNode left;
        BinaryTreeNode right;
        int data;
    }


    public static void findPath(BinaryTreeNode root, int expectNumber) {

        List<Integer> list = new ArrayList<>();

        if (root != null) {
            findPath(root, 0, expectNumber, list);
        }

    }

    private static void findPath(BinaryTreeNode root, int curnumber, int expectNumber, List<Integer> list) {

        if (root != null) {
            curnumber += root.data;
            list.add(root.data);
            if (curnumber < expectNumber) {
                findPath(root.left, curnumber, expectNumber, list);
                findPath(root.right, curnumber, expectNumber, list);
            } else if (curnumber == expectNumber) {
                if (root.left == null && root.right == null) {
                    System.out.println(list);
                }
            }

            list.remove(list.size() - 1);
        }

    } public static void main(String[] args) {
        //            10
        //         /      \
        //        5        12
        //       /\
        //      4  7
        BinaryTreeNode root = new BinaryTreeNode();
        root.data = 10;
        root.left = new BinaryTreeNode();
        root.left.data = 5;
        root.left.left = new BinaryTreeNode();
        root.left.left.data = 4;
        root.left.right = new BinaryTreeNode();
        root.left.right.data = 7;
        root.right = new BinaryTreeNode();
        root.right.data = 12;

        // 有两条路径上的结点和为22
        System.out.println("findPath(root, 22);");
        findPath(root, 22);

        // 没有路径上的结点和为15
        System.out.println("findPath(root, 15);");
        findPath(root, 15);

        // 有一条路径上的结点和为19
        System.out.println("findPath(root, 19);");
        findPath(root, 19);


        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        BinaryTreeNode root2 = new BinaryTreeNode();
        root2.data = 5;
        root2.left = new BinaryTreeNode();
        root2.left.data = 4;
        root2.left.left = new BinaryTreeNode();
        root2.left.left.data = 3;
        root2.left.left.left = new BinaryTreeNode();
        root2.left.left.left.data = 2;
        root2.left.left.left.left = new BinaryTreeNode();
        root2.left.left.left.left.data = 1;

        // 有一条路径上面的结点和为15
        System.out.println("findPath(root2, 15);");
        findPath(root2, 15);

        // 没有路径上面的结点和为16
        System.out.println("findPath(root2, 16);");
        findPath(root2, 16);

        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        BinaryTreeNode root3 = new BinaryTreeNode();
        root3.data = 1;
        root3.right = new BinaryTreeNode();
        root3.right.data = 2;
        root3.right.right = new BinaryTreeNode();
        root3.right.right.data = 3;
        root3.right.right.right = new BinaryTreeNode();
        root3.right.right.right.data = 4;
        root3.right.right.right.right = new BinaryTreeNode();
        root3.right.right.right.right.data = 5;

        // 有一条路径上面的结点和为15
        System.out.println("findPath(root3, 15);");
        findPath(root3, 15);

        // 没有路径上面的结点和为16
        System.out.println("findPath(root3, 16);");
        findPath(root3, 16);

        // 树中只有1个结点
        BinaryTreeNode root4 = new BinaryTreeNode();

        root4.data = 1;
        // 有一条路径上面的结点和为1
        System.out.println("findPath(root4, 1);");
        findPath(root4, 1);

        // 没有路径上面的结点和为2
        System.out.println("findPath(root4, 2);");
        findPath(root4, 2);

        // 树中没有结点
        System.out.println("findPath(null, 0);");
        findPath(null, 0);
    }
}
