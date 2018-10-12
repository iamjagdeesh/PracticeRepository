import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayIntersection a = new ArrayIntersection();
		int[] nums1 = {4,7,9,7,6,7};
		int[] nums2 = {5,0,0,6,1,6,2,2,4};
		a.intersect(nums1, nums2);

	}
	
	public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> l = new ArrayList<Integer>();
        int count = 0;
        for(int i=0; i<nums1.length; i++) {
            if(map1.containsKey(nums1[i])) {
                map1.put(nums1[i], map1.get(nums1[i]) + 1);
            }else{
                map1.put(nums1[i], 1);
            }
        }
        for(int i=0; i<nums2.length; i++) {
            if(map2.containsKey(nums2[i])) {
                map2.put(nums2[i], map2.get(nums2[i]) + 1);
            }else{
                map2.put(nums2[i], 1);
            }
        }
        if(map1.size() > map2.size()){
            for(Integer key : map2.keySet()) {
                if(map1.containsKey(key)){
                    count = Math.min(map1.get(key),map2.get(key));
                    for(int i=0; i<count; i++){
                        l.add(key);
                    }
                }
            }
        }else{
            for(Integer key : map1.keySet()) {
                if(map2.containsKey(key)){
                    count = Math.min(map1.get(key),map2.get(key));
                    for(int i=0; i<count; i++){
                        l.add(key);
                    }
                }
            }
        }
        int[] res = new int[l.size()];
        for(int i=0; i<l.size(); i++){
            res[i] = l.get(i).intValue();
        }
        return res;
    }

}
