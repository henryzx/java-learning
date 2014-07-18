package cc150.chpt12;

import java.util.LinkedList;

/**
 * 12.4 Imagine you have an unbalanced binary search tree. Design an algorithm which creates a linked list of all the nodes at each depth (eg, if you have a tree with depth D, you'll have D linked lists).
 * <p/>
 * Created by gerald on 7/18/14.
 */
public class Q4 {
    public static class TreeNode {
        public String data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(String data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode("1", new TreeNode("1.1", new TreeNode("1.1.1", null, null), new TreeNode("1.1.2", null, null)), new TreeNode("1.2", new TreeNode("1.2.1", null, null), new TreeNode("1.2.2", null, null)));
        LinkedList<LinkedList<String>> results = new LinkedList<LinkedList<String>>();
        traverse(root, results, 0);
        System.out.println(results);
    }

    public static void traverse(TreeNode root, LinkedList<LinkedList<String>> results, int level) {
        if (root == null) return;
        LinkedList<String> list;
        if (level < results.size()) {
            list = results.get(level);
        } else {
            list = new LinkedList<String>();
            results.addLast(list);
        }
        list.add(root.data);
        int nextLevel = level + 1;
        traverse(root.left, results, nextLevel);
        traverse(root.right, results, nextLevel);
    }
}
