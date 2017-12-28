package of04;

/**
 * Created by xinchang on 2017/12/28.
 */
public class Node {
    private Node next;
    private String data;

    public Node(String data) {
        this.data = data;
    }
    public Node getNext() {
        return next;
    }

    public String getData() {
        return data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", data='" + data + '\'' +
                '}';
    }
}
