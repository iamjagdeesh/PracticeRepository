
public class IntersectionNode {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        int lenA = 0;
        int lenB = 0;
        while(tempA != null) {
            lenA ++;
            tempA = tempA.next;
        }
        while(tempB != null) {
            lenB ++;
            tempB = tempB.next;
        }
        int diffLen = lenA - lenB;
        if(lenA < lenB){
            tempA = headA;
            headA = headB;
            headB = tempA;
            diffLen = lenB - lenA;
        }
        for(int i=1; i<=diffLen; i++) {
            headA = headA.next;
        }
        while(headA != null) {
            if(headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntersectionNode in = new IntersectionNode();
		ListNode l1 = new ListNode(1);
		ListNode l2 = null;
		ListNode res = in.getIntersectionNode(l1, l2);
	}

}
