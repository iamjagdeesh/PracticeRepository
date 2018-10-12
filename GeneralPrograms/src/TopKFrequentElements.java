import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
		int k = 10;
		TopKFrequentElements top = new TopKFrequentElements();
		List<Integer> result = top.topKFrequent(nums, k);
		System.out.println(result);
		

	}
	
	public List<Integer> topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        int[] keys = new int[k];
        int[] counts = new int[k];
        for(int i=0; i<n; i++) {
            int count;
            if(countMap.containsKey(nums[i])) {
                count = countMap.get(nums[i]) + 1;
                countMap.put(nums[i], count);
            }else{
                count = 1;
                countMap.put(nums[i], count);
            }
            for(int j=0; j<k; j++) {
                if(count > counts[j]) {
                    int l = k-1;
                    if(keys[j] != nums[i]) {
                    	while(l != j && keys[l] != nums[i]) {
                    		l--;
                    	}
                        while(l != j) {
                            keys[l] = keys[l-1];
                            counts[l] = counts[l-1];
                            l--;
                        }   
                    }
                    counts[j] = count;
                    keys[j] = nums[i];
                    break;
                }
            }
        }
        List<Integer> intList = new ArrayList<Integer>();
        for (int index = 0; index < keys.length; index++) {
            intList.add(keys[index]);
        }
        return intList;
    }

}
