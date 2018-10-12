
public class MovingZeroes {
	
	public void moveZeroes(int[] nums) {
        int i=0;
        int count = 0;
        while(i < nums.length){
            if(nums[i] != 0) {
                i++;
                continue;
            }
            int zerothI = i;
            int j = i+1;
            while(j < nums.length) {
                if(nums[j] != 0) {
                    nums[zerothI] = nums[j];
                    nums[j] = 0;
                    zerothI++;
                    count++;
                }
                j++;
            }
            i = j;
        }
        System.out.println(count);
        System.out.println("Printing array!");
        for (int k=0; k<nums.length; k++) {
        	System.out.println(nums[k]);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0, 1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 3, 0, 1, 0};
		MovingZeroes movingZeroes = new MovingZeroes();
		movingZeroes.moveZeroes(a);

	}

}
