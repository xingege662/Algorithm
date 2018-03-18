package of18;

/**
 * Created by xinchang on 2018/3/17.
 * <p>
 * <p>
 * /**
 * 请完成一个函数，输入…个二叉树，该函数输出它的镜像
 *
 * @param node 二叉树的根结点
 */
public class of18 {


    static class BinayTree {
        BinayTree left;
        BinayTree right;
        int data;
    }

    public static void mirror(BinayTree node) {
        if (node != null) {
            BinayTree temp = node.left;
            node.left = node.right;
            node.right = temp;

            mirror(node.left);
            mirror(node.right);
        }
    }

    public static void printTree(BinayTree node) {
        if (node != null) {
            printTree(node.left);
            System.out.print(node.data + " ");
            printTree(node.right);
        }
    }

    public static void main(String[] args) {
        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        BinayTree root = new BinayTree();
        root.data = 8;
        root.left = new BinayTree();
        root.left.data = 6;
        root.left.left = new BinayTree();
        root.left.left.data = 5;
        root.left.right = new BinayTree();
        root.left.right.data = 7;
        root.right = new BinayTree();
        root.right.data = 10;
        root.right.left = new BinayTree();
        root.right.left.data = 9;
        root.right.right = new BinayTree();
        root.right.right.data = 11;
        printTree(root);
        System.out.println();
        mirror(root);
        printTree(root);
        //         1
        //        /
        //       3
        //      /
        //     5
        //    /
        //   7
        //  /
        // 9
        BinayTree root2 = new BinayTree();
        root2.data = 1;
        root2.left = new BinayTree();
        root2.left.data = 3;
        root2.left.left = new BinayTree();
        root2.left.left.data = 5;
        root2.left.left.left = new BinayTree();
        root2.left.left.left.data = 7;
        root2.left.left.left.left = new BinayTree();
        root2.left.left.left.left.data = 9;
        System.out.println("\n");
        printTree(root2);
        System.out.println();
        mirror(root2);
        printTree(root2);

        // 0
        //  \
        //   2
        //    \
        //     4
        //      \
        //       6
        //        \
        //         8
        BinayTree root3 = new BinayTree();
        root3.data = 0;
        root3.right = new BinayTree();
        root3.right.data = 2;
        root3.right.right = new BinayTree();
        root3.right.right.data = 4;
        root3.right.right.right = new BinayTree();
        root3.right.right.right.data = 6;
        root3.right.right.right.right = new BinayTree();
        root3.right.right.right.right.data = 8;
        System.out.println("\n");
        printTree(root3);
        System.out.println();
        mirror(root3);
        printTree(root3);


    }
    
    
    
}
