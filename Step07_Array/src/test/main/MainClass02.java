package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		int[] nums = {0, 0, 0};
		for(int i=0; i<nums.length; i++) {
			nums[i] = 10;
		}
		
		int[] nums2 = new int[3];
		for(int i=0; i<nums2.length; i++) {
			nums2[i] = 100*(i+1);
		}
		
		System.out.println(nums[0] + "\n" + nums2[0]);
	}
}
