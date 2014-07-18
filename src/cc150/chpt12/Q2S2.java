package cc150.chpt12;

/**
 * 12.2 Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UPS & COMPLICATIONS
 * How would you solve this problem if a temporary buffer is not allowed?pg 42
 * Created by zhengxiao on 7/17/14.
 */
public class Q2S2 {
    public static void main(String[] args) {
        Node node = new Node("a", new Node("b", new Node("a", null)));
        delDups(node);
        System.out.println(node);
    }

    private static void delDups(Node node) {
        Node n = node;
        while (n != null) {
            Node r = n;
            while (r != null) {
                if (r.data != null && r.data.equals(n.data)) {
                    // found dup, remove r
                    if (r.next != null) {
                        Node next = r.next;
                        r.data = next.data;
                        r.next = next.next;
                    } else {
                        r.data = null;
                        r = r.next;
                    }
                } else {
                    r = r.next;
                }
            }
            n = n.next;
        }
    }
}
