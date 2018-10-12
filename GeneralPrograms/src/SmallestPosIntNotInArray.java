import java.util.HashMap;

public class SmallestPosIntNotInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		int[] A = {1, 3, 6, 4, 1, 2};
		for (int i : A) {
			h.put(i, 1);
		}
		for(int i=1; i<=100001; i++) {
			if(!h.containsKey(i)) {
				System.out.println(i);
				break;
			}
		}
	}

}
