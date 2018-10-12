
public class Test {

	public static void main(String args[]) {
		int[] a = {1,2,5,9,9};
		int k = 5;
		
		System.out.println(check(a, k));
	}
	
	public static int check(int[] a, int k) {
		
		int n = a.length;
		if (n == 0) {
			return -1;
		}
		
		int l = 0, r = n-1;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (a[mid] >= k) {
				r = mid;
			} else {
				l = mid+1;
			}
		}
		
		if (a[l] == k) {
			return l;
		}
		
		return -1;
	}
}
