package com.sandip.slidingWindowMaxSet;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	
	public static Comparator<Integer> idComparator = new Comparator<Integer>(){
		
		@Override
		public int compare(Integer i1, Integer i2) {
            return (int) (i2.intValue() - i1.intValue());
        }
	};
	
    public int[] maxSlidingWindow(int[] nums, int k) {
    	int length = nums.length;
    	List<Integer> ret = new ArrayList<Integer>();
    	if (k > length || k == 0) {
    		return new int[0];
    	}
    	Queue<Integer>	subSetQ = new PriorityQueue<>(k, idComparator);
    	for (int i = 0; i < k; i++) {
    		subSetQ.add(nums[i]);
    	}
    	
    	// Take the head element of the reverse sorted Q and put into ret 
    	ret.add(subSetQ.peek());
    	
    	// Now take care of k to length elements
    	for (int old = 0, n = k; n < length; n++, old++) {
    		subSetQ.remove(nums[old]);
    		subSetQ.add(nums[n]);
    		ret.add(subSetQ.peek());
    	}
    	
    	Integer[] retArray = new Integer[ret.size()];
    	ret.toArray(retArray);
		return Arrays.stream(retArray).mapToInt(Integer::intValue).toArray();
    }
}
