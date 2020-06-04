import java.lang.reflect.Array;
import java.util.*;

/*
Question:
https://leetcode.com/problems/majority-element/

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Time Complexity: O(N)
Space Complexity:  O(N)

* */

class Solutions {
    public static void main(String[] args) {
        //int[] nums = {3,2,3};
        int[] nums = {1,1,1,3,3,2,2,2};
        int result = majorityElement(nums);
        System.out.println("Ans:" + result);
    }
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> countTrack = new HashMap<Integer, Integer>();
        int count = 0;
        int result = 0;
        for (int e: nums) {
            countTrack.put(e, countTrack.getOrDefault(e, 0) + 1);
            if (countTrack.get(e) > count) {
               count = countTrack.get(e);
               result = e;
            }
        }
        return result;
    }

}
