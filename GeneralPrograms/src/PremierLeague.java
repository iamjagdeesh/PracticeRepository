
public class PremierLeague {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer n = 5;
		if(n % 2 != 0) {
			n = n+1;
		}
		Integer[] competitors = new Integer[n];
		for (int i = 1; i <= n; i++) {
			competitors[i-1] = i;
		}
		/*for (int i = 1; i <= n; i++) {
			System.out.println(competitors[i-1]);
		}*/
		for (int i = 0; i < n-1; i++) {
			System.out.println("Matchday "+(i+1));
			for (int j = 0; j < n/2; j++) {
				System.out.println(competitors[j]+"vs"+competitors[n-1-j]);
			}
			for (int j = n-1; j > 1; j--) {
				Integer temp = competitors[j];
				competitors[j] = competitors[j-1];
				competitors[j-1] = temp;
			}
			/*for (int k = 1; k <= n; k++) {
				System.out.println(competitors[k-1]);
			}*/
		}
	}

}
