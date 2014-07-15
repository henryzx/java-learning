package cc150.chpt12;

/**
 * 12.1 Implement an algorithm to find the nth to last element of a singly linked list.
 * Created by zhengxiao on 7/16/14.
 */
public class Q1 {
    public static void main(String[] args) {
        Cons<String> node = new Cons<String>("a", new Cons<String>("b", new Cons<String>("c", new Cons<String>("d", new Cons<String>("f", null)))));
        Cons<String> last = findNthToLastByOffset(node, 4);
        System.out.println(last.data);
    }

    private static Cons<String> findNthToLastByRevert(Cons<String> root, int n) {
        Cons<String> revert = null;
        Cons<String> node = root;
        while (node != null) {
            Cons<String> copy = new Cons<String>(node.data, revert);
            revert = copy;
            node = node.next;
        }
        while (--n > 0 && revert != null) {
            revert = revert.next;
        }
        return revert;
    }

    private static Cons<String> findNthToLastByOffset(Cons<String> root, int n) {
        Cons<String> tail = root;
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
