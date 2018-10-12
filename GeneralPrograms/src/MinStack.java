import java.util.Stack;

public class MinStack {
	
	Stack<Integer> stack;
    Integer min;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        Integer popped = stack.pop();
        if(popped == min) {
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return (int)min;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Your MinStack object will be instantiated and called as such:
		 */
		 MinStack obj = new MinStack();
		 obj.push(512);
		 obj.push(-1024);
		 obj.push(-1024);
		 obj.push(512);
		 obj.pop();
		 int param_4 = obj.getMin();
		 obj.pop();
		 int param_3 = obj.getMin();
		 obj.pop();
		 int param_2 = obj.getMin();
	}

}
