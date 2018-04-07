/**
 * Created by xinchang on 2018/4/7.
 */
public class of55 {
    static class Node{
        Node left;
        Node right;
        int value;

        public Node(int value){
            this.value =value;
        }
    }


    static int getNodeNum(Node root,int k){
        if (root == null) {
            return 0;
        }
        //这个算k层的叶子节点数
        if (root != null && k == 1) {
            return 1;
        }
        //这个算叶子k层的叶子节点
        if (root != null && k == 1) {
            if(root.left == null && root.right == null) {
                return 1;
            }else{
                return 0;
            }
        }



        int left = getNodeNum(root.left, k - 1);
        int right = getNodeNum(root.right, k - 1);

        return left + right;
    }

    public static void main(String[] args) {
       Node n1 = new Node(1);
       Node n2 = new Node(2);
       Node n3 = new Node(3);
       Node n4 = new Node(4);
       Node n5 = new Node(5);
       Node n6 = new Node(6);
       Node n7 = new Node(7);
       Node n8 = new Node(8);
       Node n9 = new Node(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;


        System.out.println(getNodeNum(n1, 3));
    }
}
