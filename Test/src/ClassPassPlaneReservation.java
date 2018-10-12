import java.util.HashMap;

public class ClassPassPlaneReservation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "1A 3C 2B 40G 5A";
		System.out.println(solution(40, S));

	}
	
	public static int solution(int N, String S) {
		int[][] matrix = new int[N][10];
		HashMap<Character, Integer> alphaMap = new HashMap<>();
		alphaMap.put('A', 0);
		alphaMap.put('B', 1);
		alphaMap.put('C', 2);
		alphaMap.put('D', 3);
		alphaMap.put('E', 4);
		alphaMap.put('F', 5);
		alphaMap.put('G', 6);
		alphaMap.put('H', 7);
		alphaMap.put('J', 8);
		alphaMap.put('K', 9);
		if(S != null && !S.equals("")) {
			String[] seats = S.split("\\s+");
			for(String seat: seats) {
				int row = Integer.valueOf(seat.substring(0, seat.length()-1))-1;
				int col = alphaMap.get(seat.charAt(seat.length()-1));
				matrix[row][col] = 1;
			}
		}
		int count = 0;
		for(int i=0; i<N; i++) {
			int j = 0;
			for(j=0; j<3; j++) {
				if(matrix[i][j] == 1) {
					break;
				}
			}
			if(j == 3) {
				count ++;
			}
			int tempCount = 0;
			for(j=3; j<7; j++) {
				if(tempCount == 3) {
					break;
				}
				if(matrix[i][j] == 1) {
					tempCount = 0;
				} else if(matrix[i][j] == 0) {
					tempCount++;
				}
			}
			if(tempCount == 3) {
				count++;
			}
			for(j=7; j<10; j++) {
				if(matrix[i][j] == 1) {
					break;
				}
			}
			if(j == 10) {
				count ++;
			}
		}
		return count;
    }

}
