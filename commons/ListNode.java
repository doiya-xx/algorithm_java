package commons;

import java.util.Arrays;

public class ListNode {
    
    public int val;
    public ListNode next;
    
    public ListNode() {}
    
    public ListNode(int val) {
        this.val = val;
    }
    
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    
    public static ListNode link(int[] array) {
        int[] sortedArray = Arrays.stream(array).sorted().toArray();
        ListNode preHead = new ListNode();
        ListNode p = preHead;
        for (int v : sortedArray) {
            p.next = new ListNode(v);
            p = p.next;
        }
        return preHead.next;
    }

    public static ListNode[] links(int[][] arrays) {
        int length = arrays.length;
        ListNode[] links = new ListNode[length];
        for (int i = 0; i < length; i++) {
            links[i] = ListNode.link(arrays[i]);
        }
        return links;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode p = this;
        while (p != null) {
            sb.append(p.val);
            if (p.next != null) {
                sb.append("->");
            }
            p= p.next;
        }
        return sb.toString();
    }

    public static String toListString(ListNode p) {
        StringBuilder sb = new StringBuilder("[");
        while (p != null) {
            sb.append(p.val);
            if (p.next != null) {
                sb.append(",");
            }
            p= p.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
