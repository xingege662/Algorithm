package of17;

/**
 * Created by xinchang on 2018/3/17.
 *   * 输入两棵二叉树A和B，判断B是不是A的子结构。
 * 该方法是在A树中找到一个与B树的根节点相等的元素的结点，
 * 从这个相等的结点开始判断树B是不是树A的子结构，如果找到其的一个就返回，
 * 否则直到所有的结点都找完为止。
 */
public class of17 {

    static class BinaryTree{
        BinaryTree left ;
        BinaryTree right;
        int data;
    }


    public static boolean hasSubTree(BinaryTree treeA ,BinaryTree treeB){
        if (treeA == treeB) {
            return true;
        }

        if (treeB == null) {
            return true;
        }

        if (treeA == null) {
            return false;
        }

        boolean result = false;

        if (treeA.data == treeB.data) {
            result = match(treeA, treeB);
        }

        if (result) {
            return true;
        }

        return hasSubTree(treeA.left, treeB) || hasSubTree(treeA.right, treeB);


    }

    private static boolean match(BinaryTree node1, BinaryTree node2) {
        if (node1 == node2) {
            return true;
        }

        if (node2 == null) {
            return true;
        }

        if (node1 == null) {
            return false;
        }

        if(node1.data == node2.data){
            return match(node1.left, node2.left) && match(node1.right, node2.right);
        }

        return false;

    }

    public static void main(String[] args) {
        BinaryTree root1 = new BinaryTree();
        root1.data = 8;
        root1.right = new BinaryTree();
        root1.right.data = 7;
        root1.left = new BinaryTree();
        root1.left.data = 8;
        root1.left.left = new BinaryTree();
        root1.left.left.data = 9;
        root1.left.right = new BinaryTree();
        root1.left.right.data = 2;
        root1.left.right.left = new BinaryTree();
        root1.left.right.left.left = new BinaryTree();
        root1.left.right.left.left.data = 4;
        root1.left.right.left.right = new BinaryTree();
        root1.left.right.left.right.data = 7;

        BinaryTree root2 = new BinaryTree();
        root2.data = 8;
        root2.left = new BinaryTree();
        root2.left.data = 9;
        root2.right = new BinaryTree();
        root2.right.data = 2;

        System.out.println(hasSubTree(root1, root2));
        System.out.println(hasSubTree(root2, root1));
        System.out.println(hasSubTree(root1, root1.left));
        System.out.println(hasSubTree(root1, null));
        System.out.println(hasSubTree(null, root2));
        System.out.println(hasSubTree(null, null));
    }
    
    


}
