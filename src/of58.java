/**
 * Created by xinchang on 2018/4/8.
 */
public class of58 {
        public void inOrderTraversal()
    {
        Stack<BitNode> stack=new Stack<BitNode>();
        BitNode node=root;
        while(node!=null || stack.size()>0)
        {
            while(node!=null)
            {
                stack.push(node);
                node=node.left;
            }

            if(stack.size()>0)
            {
                node=stack.pop();
                System.out.print(node.val+",");
                node=node.right;
            }
        }
    }

    public void preOrderTraversal()
    {
        Stack<BitNode> stack=new Stack<BitNode>();
        BitNode node;
        if(root!=null)
        {
            stack.push(root);
            while(stack.size()>0)
            {
                node=stack.pop();
                System.out.print(node.val+",");
                if(node.right!=null)
                    stack.push(node.right);
                if(node.left!=null)
                    stack.push(node.left);
            }
        }
    }
public void postOrderTraversal()
{
    Stack<BitNode> stack=new Stack<BitNode>();
    Stack<Integer> valStack=new Stack<Integer>();
    BitNode node=root;
    while(node!=null || stack.size()>0)
    {
        while(node!=null)
        {
            stack.push(node);
            valStack.push(node.val);
            node=node.right;
        }

        node=stack.pop();
        node=node.left;
    }

    while(valStack.size()>0)
    {
        System.out.print(valStack.pop()+",");
    }
}
}
