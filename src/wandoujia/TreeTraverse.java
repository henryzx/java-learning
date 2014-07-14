package wandoujia;

import java.util.LinkedList;

/**
 * 深度与广度优先遍历二叉树
 * Created by zhengxiao1127@foxmail.com on 6/24/14.
 */
public class TreeTraverse {

    /**
     * 二叉树节点
     */
    public static class Node {
        public String value;
        public Node left;
        public Node right;

        public Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(String value) {
            this.value = value;
        }
    }

    /**
     * 深度优先
     *
     * @param root
     */
    public static void traverseD(Node root) {
        if (root == null)
            return;

        System.out.println(root.value);
        traverseD(root.left);
        traverseD(root.right);
    }

    private static LinkedList<Node> queue = new LinkedList<Node>();

    /**
     * 广度优先
     *
     * @param root
     */
    public static void traverseB(Node root) {
        queue.clear();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            Node node = queue.removeFirst();
            System.out.println(node.value); // visit
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
    }

    /**
     * 测试主程序
     *
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node("0",
                new Node("1",
                        new Node("1.1",
                                new Node("1.1.1"),
                                new Node("1.1.2")
                        ),
                        new Node("1.2",
                                new Node("1.2.1"),
                                new Node("1.2.2"))
                ),
                new Node("2",
                        new Node("2.1"),
                        new Node("2.2"))
        );
        System.out.println("Deep:");
        traverseD(root);
        System.out.println("Broad:");
        traverseB(root);
    }
}
