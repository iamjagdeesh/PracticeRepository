import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
	
	public static int kSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
		for(int j=0; j<n; j++) {
			pq.offer(new Tuple(0, j, matrix[0][j]));
		}
		for(int i=0; i<k-1; i++) {
			Tuple t = pq.poll();
			if(t.x != n-1) {
				pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
			}
		}
		return pq.poll().val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{ 1,  5,  9},{10, 11, 13},{12, 13, 15}};
		int k = 6;
		int element = kSmallest(matrix, k);
		System.out.println(element);
	}

}
