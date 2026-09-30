package List;

public class PartitionList86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode beforeHead = new ListNode(0); // Dummy node for the "before" list
        ListNode before = beforeHead; // Pointer to build the "before" list
        ListNode afterHead = new ListNode(0); // Dummy node for the "after" list
        ListNode after = afterHead; // Pointer to build the "after" list

        while (head != null) {
            if (head.val < x) {
                before.next = head; // Add to the "before" list
                before = before.next;
            } else {
                after.next = head; // Add to the "after" list
                after = after.next;
            }
            head = head.next; // Move to the next node
        }

        after.next = null; // Terminate the "after" list
        before.next = afterHead.next; // Connect the two lists

        return beforeHead.next; // Return the head of the new partitioned list
    }
}
