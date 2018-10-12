import java.util.*;

public class Solution {
	
	Stack<TreeNode> stack;
    int max;
    
    public Solution() {
        stack = new Stack<TreeNode>();
        max = 0;
    }
    
    public int maxDepth(TreeNode root) {
        this.stack.push(root);
        this.dfs();
        return this.max;
    }
    
    public void dfs() {
        while(!this.stack.empty()) {
            TreeNode node = this.stack.pop();
            if(node.right != null) {
                if (this.max < node.len + 1) this.max = node.len + 1;
                node.right.len = node.len + 1;
                this.stack.push(node.right);
            }
            if(node.left != null) {
                if (this.max < node.len + 1) this.max = node.len + 1;
                node.left.len = node.len + 1;
                this.stack.push(node.left);
            }
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		TreeNode root = new TreeNode(1, 0);
		Integer len = sol.maxDepth(root);
		System.out.println(len);
	}

}
