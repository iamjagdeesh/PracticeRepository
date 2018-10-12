import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Lock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> events = new ArrayList<String>();
		events.add("ACQUIRE 364");
		events.add("RELEASE 364");
		events.add("RELEASE 420");
		System.out.println(check_log_history(events));
	}
	
	public static int check_log_history(List<String> events) {
		
		Stack<Integer> st = new Stack<>();
		Set<Integer> set = new HashSet<>();
		int n = events.size();
		for(int i=1; i<=n; i++) {
			String event = events.get(i-1);
			String[] comps = event.split("\\s+");
			Integer lock = Integer.valueOf(comps[1]);
			if(comps[0].equals("ACQUIRE")) {
				st.push(lock);
				if(set.contains(lock)) {
					return i;
				}
				set.add(lock);
			} else {
				if(st.empty()) {
					return i;
				}
				Integer poppedLock = st.pop();
				if(poppedLock.intValue() != lock.intValue()) {
					return i;
				}
				set.remove(lock);
			}
		}
		if(st.isEmpty()) {
			return 0;
		} else {
			return n+1;
		}
    }

}
