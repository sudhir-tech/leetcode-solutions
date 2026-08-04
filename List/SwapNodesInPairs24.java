public class SwapNodesInPairs24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head; // No need to swap if there are less than 2 nodes
        }

        ListNode newHead = head.next; // The new head will be the second node
        ListNode prev = null; // To keep track of the previous node for linking

        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            // Swap the nodes
            first.next = second.next;
            second.next = first;

            // Link the previous pair to the current swapped pair
            if (prev != null) {
                prev.next = second;
            }

            // Move to the next pair
            prev = first;
            head = first.next;
        }

        return newHead; // Return the new head of the swapped list
    }
}
