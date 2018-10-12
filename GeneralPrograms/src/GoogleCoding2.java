
public class GoogleCoding2 {
	
	public static int solution(int[] A) {
        int n = A.length;
		int i = 1;
		Integer b1 = A[0];
		Integer b2 = null;
		int index = 1;
		int count = 1;
		int max = 1;
        while(i < n) {
			if(b1 == null || b2 == null || A[i] == b1 || A[i] == b2) {
				if(b1 == null) {
					b1 = A[i];
				} else if(b2 == null) {
					b2 = A[i];
				}
				if(A[i] != A[i-1]) {
					index = i+1;
				}
				i++;
				count++;
				
				if(count > max) {
					max = count;
				}
			} else {
				b1 = A[i];
				b2 = A[i-1];
				i = index;
				count = 1;
			}
		}
		
		return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = {1,2,1,3,4,3,5,1,2};
		//int[] A = {1,2,1,2,1,2,1};
		int[] A = {1};
		System.out.println(solution(A));
	}

}
