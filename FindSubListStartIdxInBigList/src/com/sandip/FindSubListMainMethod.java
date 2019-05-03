package com.sandip;
import java.util.*;

public class FindSubListMainMethod {
	/*
	 * Implement a method 'find' that will find the starting index  (zero based)
	 * where the second list occurs as a sub-list in the first list. It should
	 * return -1 if the sub-list cannot be found. Arguments are always given,
	 * not empty. Sample Input 1 list1 = (1, 2, 3) list2 = (2, 3) Sample Output
	 * 1 1 Explanation As second list (2, 3) is sub-list in first list (1, 2, 3)
	 * at index 1 Sample Input 2 list1 = (1, 2, 3) list2 = (3, 2) Sample Output
	 * 2 -1Implement a method 'find' that will find the starting index  (zero
	 * based) where the second list occurs as a sub-list in the first list. It
	 * should return -1 if the sub-list cannot be found. Arguments are always
	 * given, not empty. Sample Input 1 list1 = (1, 2, 3) list2 = (2, 3) Sample
	 * Output 1 1 Explanation As second list (2, 3) is sub-list in first list
	 * (1, 2, 3) at index 1 Sample Input 2 list1 = (1, 2, 3) list2 = (3, 2)
	 * Sample Output 2 -1.
	 * 
	 * 	Checkout this link:
	 * https://stackoverflow.com/questions/32884901/given-two-linked-lists-find-the-index-where-one-list-is-sublist-of-another
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindSubListMainMethod.test(new ArrayList<Integer>(Arrays.asList(1, 2, 3)),
				new ArrayList<Integer>(Arrays.asList(2, 3)));
		FindSubListMainMethod.test(new ArrayList<Integer>(Arrays.asList(1, 2, 3)),
				new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
		FindSubListMainMethod.test(new ArrayList<Integer>(Arrays.asList(1, 2, 3)),
				new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)));
		FindSubListMainMethod.test(new ArrayList<Integer>(Arrays.asList(1, 2, 3)),
				new ArrayList<Integer>(Arrays.asList()));
	}
	
	public static void test(ArrayList<Integer> l1, ArrayList<Integer> l2) {
		int ret = -1;
		ret = FindSubListMainMethod.findSubListStartIdx(l1, l2);
		System.out.printf(" L2"+ l2 +" is %ssub-set of L1" + l1 +"%s\n", 
				(ret == -1) ? "not ": "", 
			    (ret != -1) ? "start index " + ret : "");
	}
	public static int findSubListStartIdx(ArrayList<Integer> l1, ArrayList<Integer> l2) {
		if (l1 == null || l2 == null) {
			return -1;
		}
		if (l1.size() < l2.size()) {
			return -1;
		}
		if (l2.size() == 0) {
			return -1;
		}
		
		int i = 0, j = 0;
		while (i < l1.size()) {
			if (l1.get(i) == l2.get(0)) {
				/* Check rest of the chars */
				j = 0;
				int old_i = i;
				while((i < l1.size()) && (j < l2.size()) && (l1.get(i) == l2.get(j))) {
					i++; j++;
				}
				if (j == l2.size()) {
					/* All chars of sub strings are found in l1 */
					return(old_i);
				} else {
					i = old_i;
					j = 0;
				}
			}
			i++;
		}
		return -1;
	}
}
