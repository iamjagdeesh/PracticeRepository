import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation {
	
	public static void main(String[] args) {
		Permutation sol = new Permutation();
		int[] nums = {5,4,6,2};
		sol.permute(nums);
	}

	public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = nums.length;
        int fact = 1;
        for(int i = n; i > 1; i--) {
            fact *= i;
        }
        // left : 0; right : 1;
        int[] arrows = new int[n];
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        result.add(list);
        int largest = nums[0];
        for(int i=0; i<n; i++) {
            if(largest < nums[i]) {
                largest = nums[i];
            }
        }
        while(result.size() < fact) {
            int largestMobileIndex = this.largestMobile(nums, arrows);
            List<Integer> largeIndexes = this.getIndexesGreaterThan(nums, largestMobileIndex);
            if(!largeIndexes.isEmpty()) {
                for(int i=0; i<largeIndexes.size(); i++) {
                	if(arrows[largeIndexes.get(i)] == 0) {
                        arrows[largeIndexes.get(i)] = 1;
                    } else {
                        arrows[largeIndexes.get(i)] = 0;
                    }
                }
            }
            if(arrows[largestMobileIndex] == 1) {
                int temp = nums[largestMobileIndex];
                nums[largestMobileIndex] = nums[largestMobileIndex+1];
                nums[largestMobileIndex+1] = temp;
                temp = arrows[largestMobileIndex];
                arrows[largestMobileIndex] = arrows[largestMobileIndex+1];
                arrows[largestMobileIndex+1] = temp;
            } else {
                int temp = nums[largestMobileIndex];
                nums[largestMobileIndex] = nums[largestMobileIndex-1];
                nums[largestMobileIndex-1] = temp;
                temp = arrows[largestMobileIndex];
                arrows[largestMobileIndex] = arrows[largestMobileIndex-1];
                arrows[largestMobileIndex-1] = temp;
            }
            list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(list);
        }
        return result;
        
    }
    
    public List<Integer> getIndexesGreaterThan(int[] nums, int largestMobileIndex) {
        List<Integer> l = new ArrayList<Integer>();
    	for(int i=0; i<nums.length; i++) {
            if(nums[i] > nums[largestMobileIndex]) {
                l.add(i);
            }
        }
        return l;
    }
    
    public int largestMobile(int[] nums, int[] arrows) {
        int largeIndex = -1;
        for(int i=0; i<nums.length; i++) {
            if(arrows[i] == 0) {
            	if(largeIndex == -1) {
            		if(i!=0 && nums[i-1]<nums[i]) {
            			largeIndex = i;
            		}
            	}else {
            		if(i!=0 && nums[i-1]<nums[i] && nums[i]>nums[largeIndex]) {
            			largeIndex = i;
            		}
            	}
            }else {
            	if(largeIndex == -1) {
            		if(i!=nums.length-1 && nums[i+1]<nums[i]) {
            			largeIndex = i;
            		}
            	}else {
            		if(i!=nums.length-1 && nums[i+1]<nums[i] && nums[i]>nums[largeIndex]) {
            			largeIndex = i;
            		}
            	}
            }
        }
        return largeIndex;
    }

}
