
public class PalindromicLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromicLL p = new PalindromicLL();
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(2);
		node.next.next.next.next = new ListNode(1);
		boolean b = p.isPalindrome(node); 
	}
	
	public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode rev = null;
        ListNode s = null;
        while(fast!=null && fast.next!=null) {
        	fast = fast.next.next;
        	s = slow.next;
            slow.next = rev;
            rev = slow;
            slow = s;
        }
        if(fast!=null) {
            slow = slow.next;
        }
        while(rev!=null && rev.val == slow.val) {
            rev = rev.next;
            slow = slow.next;
        }
        if(rev == null) return true;
        else return false;
    }

}
