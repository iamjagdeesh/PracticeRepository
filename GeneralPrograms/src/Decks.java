import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Decks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Decks d = new Decks();
		/*String A = "A586QK";
		String B = "JJ653K";
		int n = d.solution(A, B);
		System.out.println(n);*/
		
		//int[] ar = {7,3,7,3,1,3,4,1};
		int[] ar = {7,5,2,7,2,7,4,7};
		//int[] ar = {2,1,1,3,2,1,1,3};
		int m = d.solution2(ar);
		System.out.println(m);
	}
	
	public int solution(String A, String B) {
        // write your code in Java SE 8
		HashMap<Character, Integer> cards = new HashMap<Character, Integer>();
		cards.put('A', 1);
		cards.put('K', 2);
		cards.put('Q', 3);
		cards.put('J', 4);
		cards.put('T', 5);
		cards.put('9', 6);
		cards.put('8', 7);
		cards.put('7', 8);
		cards.put('6', 9);
		cards.put('5', 10);
		cards.put('4', 11);
		cards.put('3', 12);
		cards.put('2', 13);
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		int count = 0;
		for(int i=0; i<a.length; i++) {
			if(cards.get(a[i]) < cards.get(b[i])) {
				count++;
			}
		}
		return count;
    }
	
	public int solution2(int[] A) {
        // write your code in Java SE 8
		HashMap<Integer, Integer> aAll = new HashMap<Integer, Integer>();
		
		Set<Integer> set = Arrays.stream(A).boxed().collect(Collectors.toSet());
		HashMap<Integer, Integer> hUnique = new HashMap<Integer, Integer>();
		
		for (Integer ele : set) {
			hUnique.put(ele, 1);
			aAll.put(ele, 0);
		}
		
		int i=0;
		int distictValsFromA = 0;
		int minLength = Integer.MAX_VALUE;
		for(int j=0; j<A.length; j++) {
			if( aAll.get(A[j])==0 && hUnique.containsKey(A[j])) {
				distictValsFromA++;
			}
			if(aAll.containsKey(A[j])) {
				aAll.put(A[j], aAll.get(A[j])+1);
			}else {
				aAll.put(A[j], 1);
			}
			if(distictValsFromA == set.size()) {
				while(aAll.get(A[i])>1 || !hUnique.containsKey(A[i])) {
					aAll.put(A[i], aAll.get(A[i])-1);
					i++;
				}
				if((j-i+1) < minLength) {
					minLength = j-i+1;
				}
			}
			
		}
		
		
		return minLength;
    }

}
