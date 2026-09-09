package List;

public class RotateList61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head; // No rotation needed for empty list, single node, or zero rotations
        }

        // First, determine the length of the list and get the last node
        ListNode current = head;
        int length = 1; // Start with 1 to count the head
        while (current.next != null) {
            current = current.next;
            length++;
        }
        ListNode lastNode = current; // This is the last node

        // Calculate effective rotations needed
        k = k % length; // If k is greater than length, reduce it
        if (k == 0) {
            return head; // No rotation needed if k is a multiple of length
        }

        // Find the new tail: (length - k - 1)th node
        current = head;
        for (int i = 0; i < length - k - 1; i++) {
            current = current.next;
        }
        ListNode newHead = current.next; // The new head will be the next node
        current.next = null; // Break the link to form the new tail

        // Connect the old tail to the old head
        lastNode.next = head;

        return newHead; // Return the new head of the rotated list
    }
}
