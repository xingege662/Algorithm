package of44;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinchang on 2018/3/20.
 */
public class of44 {


    /**
     * 树的结点定义
     */
    private  static class TreeNode {
        int val;

        List<TreeNode> children = new LinkedList<>();


        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }


    public static TreeNode  findCommonNode(TreeNode root ,TreeNode p1 ,TreeNode p2){
        if (root == null || p1 == null || p2 == null) {
            return null;
        }

        List<TreeNode> path1 = new LinkedList();
        findNodePath(root , p1,path1);

        List<TreeNode> path2 = new LinkedList<>();
        findNodePath(root , p2 ,path2);

        return getCommonNode(path1,path2);

    }

    private static TreeNode getCommonNode(List<TreeNode> path1, List<TreeNode> path2) {

        Iterator<TreeNode> ite1 = path1.iterator();
        Iterator<TreeNode> ite2 = path2.iterator();

        TreeNode last = null;
        while (ite1.hasNext() && ite2.hasNext()) {
            TreeNode temp = ite1.next();
            if (temp == ite2.next()) {
                last = temp;
            }
        }
        return last;

    }

    private static void findNodePath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) {
            return;
        }

        path.add(root);

        List<TreeNode> childrean = root.children;

        for (TreeNode node : childrean) {
            if (node == target) {
                path.add(node);
                return;
            }else{
                findNodePath(node,target,path);
            }
        }

        path.remove(path.size() - 1);
    }

    // 形状普通的树
    //             1
    //           /   \
    //         2      3
    //        /         \
    //      4            5
    //     / \        /  |  \
    //    6   7      8   9  10
    public static void test01() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);

        n1.children.add(n2);
        n1.children.add(n3);

        n2.children.add(n4);

        n4.children.add(n6);
        n4.children.add(n7);

        n3.children.add(n5);

        n5.children.add(n8);
        n5.children.add(n9);
        n5.children.add(n10);

        System.out.println(findCommonNode(n1, n6, n8));
    }

    // 树退化成一个链表
    //               1
    //              /
    //             2
    //            /
    //           3
    //          /
    //         4
    //        /
    //       5
    private static void test02() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.children.add(n2);
        n2.children.add(n3);
        n3.children.add(n4);
        n4.children.add(n5);

        System.out.println(findCommonNode(n1, n4, n5));
    }

    // 树退化成一个链表，一个结点不在树中
    //               1
    //              /
    //             2
    //            /
    //           3
    //          /
    //         4
    //        /
    //       5
    private static void test03() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.children.add(n2);
        n2.children.add(n3);
        n3.children.add(n4);
        n4.children.add(n5);

        System.out.println(findCommonNode(n1, n5, n6));
    }

    public static void main(String[] arg) {
        test01();
        test02();
        test03();
    }
}
