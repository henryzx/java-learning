package cc150.chpt12;

import java.util.HashSet;

/**
 * 12.2 Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UPS & COMPLICATIONS
 * How would you solve this problem if a temporary buffer is not allowed?
 * Created by zhengxiao on 7/16/14.
 */
public class Q2 {
    public static void main(String[] args) {
        Node node = new Node("a", new Node("b", new Node("a", null)));
        deleteDups(node);
        System.out.println(node);

    }

    private static void deleteDups(Node node) {
        HashSet<String> hashTable = new HashSet<String>();
        while (node != null) {
            if (hashTable.contains(node.data)) {
                // delete current node
                Node next = node.next;
                if (next != null) {
                    node.data = next.data;
                    node.next = next.next;
                }else{
                    // 重新回退 或 标记为已删除
                    node.data = null;
                    node.next = null;
                }
                node = node.next;
            } else {
                hashTable.add(node.data);
                node = node.next;
            }
        }
    }


}
