package com.sandip;
import java.util.*;
import java.util.LinkedList;

/*
 * http://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
 * * Given a list of transactions, How can we calculate the frequency counts of all possible item-sets?

For example,
Input:
ID Purchased Items
1 apple, banana, lemon
2 banana, berry, lemon, orange
3 banana, berry, lemon

Output:
Itemset Frequency
apple, banana 1
apple, lemon 1
banana, berry 2
banana, lemon 3
...
apple, banana, lemon 1
banana, berry, lemon 2
banana, berry, lemon, orange 1
 */

public class FruitCombinationAndTranMain {
	static LinkedList<LinkedHashSet<String>>   trans = new LinkedList<LinkedHashSet<String>>();
	
    public static void toFill(String[] fruits, int start, int r, String subSet[]) {
        int n = fruits.length;
        for (int i = start; i <= (n - r); i++) {
        	/* in my implementation I am filling data from last index(r-1) */
            subSet[r - 1] = fruits[i];
            if (r == 1) {
                /*
                 * 1. Print elements of this combination.
                 * 2. Check, which transation has this combination and count them.
                 * 3. Print count too.
                 */
            	int transCount = 0;
            	List<String> subSetAsList = Arrays.asList(subSet);
                // System.out.println("Combination is: " + Arrays.asList(subSet));
                for (LinkedHashSet<String> s: trans) {
                    if (s.containsAll(Arrays.asList(subSet))) {
                        transCount++;
                    } else {
                    	// System.out.println(subSetAsList + " is not in " + s + " transaction");
                    }
                }
                if (transCount > 0) {
                   System.out.println("Combination is: " + subSetAsList + " - " + transCount);
                }
            } else {
                toFill(fruits, i + 1, r - 1, subSet);
            }
        }
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		trans.add(new LinkedHashSet<String>(Arrays.asList("apple", "banana", "lemon")));
		trans.add(new LinkedHashSet<String>(Arrays.asList("banana", "berry", "lemon", "orange")));
		trans.add(new LinkedHashSet<String>(Arrays.asList("banana", "berry", "lemon")));
		
	      /* Create a set of all elements, i.e. unique elements */
	      LinkedHashSet<String> items = new LinkedHashSet<String>();
	      for (LinkedHashSet<String> tran:  trans) {
	        for (String item: tran) {
	            items.add(item);
	        }
	      }
	      System.out.println("Items:" + items.toString());
	      
	      /* Get number of transaction each combination of fruit has  
	       * 1. First get array of all unique elements. 
	       * 2. Then find all combination of different size i.e.
	       *    2 of all items, 3 of all items, ... n of all items (till whole
	       *    unique elements are included in one list).
	       */
	      String[] tmpFruits = new String[0]; 
	      String[] fruits = items.toArray(tmpFruits);
	      for (int r = 2; r <= fruits.length; r++) {
	    	  String subSet[] = new String[r];
	    	  toFill(fruits, 0, r, subSet);
	      }
	}

}
