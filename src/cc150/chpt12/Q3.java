package cc150.chpt12;

/**
 * 12.3 Given a circular linked list, implement an algorithm which returns node at the begin- ning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an
 * earlier node, so as to make a loop in the linked list.
 * EXAMPLE:
 * input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * output: C
 * Created by zhengxiao on 7/16/14.
 */
public class Q3 {
    public static void main(String[] args) {
        Node e = new Node("E", null);
        Node d = new Node("D", e);
        Node c = new Node("C", d);
        Node b = new Node("B", c);
        Node a = new Node("A", b);
        e.next = c;

        Node circleBegin = findCircularRoot(a);
        System.out.println(circleBegin.data);
    }

    private static Node findCircularRoot(Node a) {
        Node n1 = a, n2 = a;
        while (true) {
            n1 = n1.next;
            if (n1 == null) return null;
            n1 = n1.next;
            n2 = n2.next;
            if (n1 == null || n2 == null) return null;
            if (n1 == n2)
                break;
        }

        n1 = a;
        while (n1.next != n2.next) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1.next;
    }


}
