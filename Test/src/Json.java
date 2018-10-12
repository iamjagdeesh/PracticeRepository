import java.util.Stack;

public class Json {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "";
		System.out.println(isValidJson(test));
	}

	public static boolean isValidJson(String str) {
		Stack<Character> stack = new Stack<>();
		for (char c : str.toCharArray()) {
			switch (c) {
				case '{':
					stack.push(c);
					break;
				case '}':
					if (stack.isEmpty()) {
						return false;
					}
					Character last1 = stack.pop();
					if (last1 != '{') {
						return false;
					}
					break;
				case '\"':
					if (stack.isEmpty()) {
						return false;
					}
					Character last2 = stack.peek();
					if (last2 == '\"') {
						// It's a closing quote
						stack.pop();
					} else {
						// It's an opening quote
						stack.push(c);
					}
					break;
				case '[':
					stack.push(c);
					break;
				case ']':
					if (stack.isEmpty()) {
						return false;
					}
					Character last3 = stack.pop();
					if (last3 != '[') {
						return false;
					}
					break;
				/*
				case ',':
					if (stack.isEmpty()) {
						return false;
					}
					Character last4 = stack.peek();
					if (last4 != '[' || last4 != '\"' || last4 != '{' || last4 != '(') {
						return false;
					}
					break;
				*/
				case '(':
					stack.push(c);
					break;
				case ')':
					if (stack.isEmpty()) {
						return false;
					}
					Character last5 = stack.pop();
					if (last5 != '(') {
						return false;
					}
					break;
			}
		}
		return stack.isEmpty();
	}

}
