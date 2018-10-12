
public class PopulatingNextRightPointersInEachNode116 {
	
	static public void connect(TreeLinkNode root) {
        link(root, null);
    }
    
    static public void link(TreeLinkNode node1, TreeLinkNode node2) {
        if(node1 != null) {
            node1.next = node2;
        }
        if(node1 != null) {
            link(node1.left, node1.right);
        }
        if(node2 != null) {
            link(node2.left, node2.right);
        }
        if(node1 != null && node2 != null) {
            link(node1.right, node2.left);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode root = new TreeLinkNode(0);
		TreeLinkNode node1 = new TreeLinkNode(1);
		TreeLinkNode node2 = new TreeLinkNode(2);
		TreeLinkNode node3 = new TreeLinkNode(3);
		TreeLinkNode node4 = new TreeLinkNode(4);
		TreeLinkNode node5 = new TreeLinkNode(5);
		TreeLinkNode node6 = new TreeLinkNode(6);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		node3.left = node3.right = node4.left = node4.right = node5.left = node5.right = node6.left = node6.right = null;
		connect(root);
	}

}
