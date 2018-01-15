package chapter3;

/**
 * Created by xinchang on 2018/1/15.
 */
public class MyLinkedList<AnyType> {

    private int theSize;
    private Node<AnyType> beginer;
    private Node<AnyType> laster;

    public MyLinkedList() {
        beginer = new Node<AnyType>(null, null, null);
        laster = new Node<AnyType>(null, beginer, null);
        beginer.next = laster;
        theSize = 0;
    }

    public int size() {
        return theSize;
    }

    public void add(AnyType anyType) {
        add(anyType, size());
    }

    private void add(AnyType anyType, int idx) {
        addBefore(getNode(idx, 0, size()), anyType);
    }

    private void addBefore(Node<AnyType> node, AnyType anyType) {
        Node<AnyType> newNode = new Node<AnyType>(anyType, node.pre, node);
        node.pre.next = newNode;
        node.pre = newNode;
        theSize++;
    }

    private Node<AnyType> getNode(int idx, int lower, int upper) {

        if (idx < lower || idx > upper) {
            throw new IndexOutOfBoundsException("index越界");
        }
        // 在前半段，从前往后找
        if (idx < size() / 2) {
            Node<AnyType> p = beginer.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
            return p;

        } else {  //在后半段，从后往前找
            Node<AnyType> p = laster;
            for (int i = theSize; i > idx; i--) {
                p = p.pre;
            }
            return p;
        }

    }

    public void remove(int idx) {
        Node<AnyType> node = getNode(idx, 0, size());
        Node<AnyType> pre = node.pre;
        if (pre == null) {
            beginer = node;
        }
        Node next = node.next;
        if (node == null) {
            laster = node;
        }

        pre.next = next;
        next.pre = pre;
        theSize--;

    }

    public void set(int idx, AnyType anyType) {
        Node node = getNode(idx, 0, size());
        node.data = anyType;
    }

    public AnyType get(int idx) {
        return getNode(idx, 0, size()).data;
    }


    private static class Node<AnyType> {
        AnyType data;
        Node<AnyType> pre;
        Node<AnyType> next;

        public Node() {

        }

        public Node(AnyType anyType, Node<AnyType> pre, Node<AnyType> next) {
            this.data = anyType;
            this.pre = pre;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");
        for (int i = 0; i < theSize; i++) {
            buffer.append(get(i));
            if (i != theSize) {
                buffer.append(", ");
            }
        }
        buffer.append("}");
        return buffer.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList();
        for (int i = 0; i < 20; i++) {
            myLinkedList.add(i);
        }
        System.out.println(myLinkedList.toString());

        myLinkedList.remove(2);
        System.out.println(myLinkedList.toString());

        myLinkedList.add(21, 2);
        System.out.println(myLinkedList.toString());



        myLinkedList.set(2,31);
        System.out.println(myLinkedList.toString());


        System.out.println(myLinkedList.get(2));

    }

}
