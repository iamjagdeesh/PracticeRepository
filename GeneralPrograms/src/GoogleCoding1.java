import java.util.HashMap;
import java.util.Map;

public class GoogleCoding1 {
	
	public static int solution(String[] L) {
        // write your code in Java SE 8
		Map<String, Integer> mapString = new HashMap<String, Integer>();
		int count = 0;
        for(String str: L) {
        	String[] comps = str.split("@");
        	String localName = comps[0];
        	localName = localName.replaceAll("\\.", "");
        	String[] localArr = localName.split("\\+");
        	localName = localArr[0];
        	String domain = comps[1];
        	String email = localName + domain;
        	mapString.put(email, mapString.getOrDefault(email, 0) + 1);
        }
        for (String key : mapString.keySet()) {
			if(mapString.get(key) > 1) {
				count++;
			}
		}
		return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] L = {"d.u.p.l.i.c.a+t.e@example.com", };
		System.out.println(solution(L));

	}

}
