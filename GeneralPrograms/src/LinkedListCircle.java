
public class LinkedListCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListCircle l = new LinkedListCircle();
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = node;
		boolean t = l.hasCycle(node);
	}
	
	public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if (fast == null || fast.next != null) {
            return false;
        }
        return true;
    }

}
