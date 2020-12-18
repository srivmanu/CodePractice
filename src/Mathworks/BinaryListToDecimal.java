package Mathworks;

/**
 * Bianry Linked List to Decimal
 */
public class BinaryListToDecimal {

    public class Node {

        int data;

        Node next;
    }

    public int decimal(Node head) {
        int res = 0;
        while (head != null) {
            res = (res << 1) + head.data;
            head = head.next;
        }
        return res;
    }
}
