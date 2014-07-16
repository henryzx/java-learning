package cc150.chpt12;

/**
 * Created by zhengxiao on 7/16/14.
 */
public class Node {
    public String data;
    public Node next;

    @Override
    public String toString() {
        return String.format("%s,", data) + (next == null ? "" : next.toString());
    }

    public Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }
}
