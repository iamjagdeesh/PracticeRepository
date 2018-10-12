import java.util.Arrays;

public class MergeArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mergedCount = m+n;
        int[] c = new int[mergedCount];
        int i=0,j=0,k=0;
        while(i<m && j<n && k<mergedCount) {
            if(nums1[i] < nums2[i]) {
                c[k] = nums1[i];
                i++;
                k++;
            }else{
                c[k] = nums2[j];
                j++;
                k++;
            }
        }
        if(i<m) {
            while(i<m) {
                c[k] = nums1[i];
                i++;
                k++;
            }
        }else if(j<n) {
            while(j<n) {
                c[k] = nums2[j];
                j++;
                k++;
            }
        }
        for(int l=0; l<c.length; l++){
            System.out.println(c[l]);
        }
        nums1 = new int[mergedCount];
        nums1 = Arrays.copyOf(c, c.length);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeArray merge = new MergeArray();
		int[] nums1 = {1,3,5};
		int[] nums2 = {2,4,6};
		merge.merge(nums1, 3, nums2, 3);
	}

}
