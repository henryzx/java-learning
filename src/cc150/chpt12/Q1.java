package cc150.chpt12;

/**
 * 12.1 Implement an algorithm to find the nth to last element of a singly linked list.
 * Created by zhengxiao on 7/16/14.
 */
public class Q1 {
    public static void main(String[] args) {
        Node node = new Node("a", new Node("b", new Node("c", new Node("d", new Node("f", null)))));
        Node last = findNthToLastByOffset(node, 4);
        System.out.println(last.data);
    }

    private static Node findNthToLastByRevert(Node root, int n) {
        Node revert = null;
        Node node = root;
        while (node != null) {
            Node copy = new Node(node.data, revert);
            revert = copy;
            node = node.next;
        }
        while (--n > 0 && revert != null) {
            revert = revert.next;
        }
        return revert;
    }

    private static Node findNthToLastByOffset(Node root, int n) {
        Node tail = root;
        while (n-- > 0) {
            if (tail == null) return null;
            tail = tail.next;
        }

        while (tail.next != null) {
            root = root.next;
            tail = tail.next;
        }

        return root;
    }
}
