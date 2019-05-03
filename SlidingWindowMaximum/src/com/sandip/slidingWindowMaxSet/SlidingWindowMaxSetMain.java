package com.sandip.slidingWindowMaxSet;

public class SlidingWindowMaxSetMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] nums = {1,3,-1,-3,5,3,6,7};
	    int[] nums = new int[0];
	    int k = 0;
		int[] ret;
		Solution sol = new Solution();
		ret = sol.maxSlidingWindow(nums, k);
		for (Integer i : ret) {
			System.out.println("Return set: " + i);
		}
	}

}
