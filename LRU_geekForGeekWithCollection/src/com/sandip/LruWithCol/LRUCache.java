package com.sandip.LruWithCol;
import java.util.LinkedHashMap;
import java.util.Map;


public class LRUCache {
	int lruMaxSz = 0;
	int lruCurrentSz = 0;
	LinkedHashMap<Integer, Integer> linkMap = new LinkedHashMap<Integer, Integer>(); 

    /*Inititalize an LRU cache with size N */
    public LRUCache(int N) {
       //Your code here
       lruMaxSz = N;
    }
    
    /* Returns the value of the key x if 
     present else returns -1 */
    public int get(int key) {
    	Integer ret = null;
       //Your code here
    	if (lruMaxSz <= 0) {
    		return -1;
    	}
    	
    	/* Search for the entry */
    	ret = linkMap.get(key);
    	if (ret != null) {
    		/* If found then take the entry to front position.
    		 * Remove it and add back in Map. It will come at the front.
             * Return the entry value. */
    		linkMap.remove(key);
    		linkMap.put(key, ret);
    		return ret.intValue();
    	}
        /* Else return -1 */
    	return -1;
    }
    
    /* Sets the key x with value y in the LRU cache */
    public void set(int key, int val) {
    	Integer foundElm = null;
       //Your code here
       /* 
        * 1. If max size is 0 then return 
        * 2. Search the element in the list, make a note of last element.
	    * 3. If not found then check current size, if it is equal to Max allowed, 
		*    then remove first element in the list and add new element, which will 
		*    be added at the front.
    	* 4. We found element, just remove and add back with new val, this will add the element 
    	*    at the end.
        * 6. Return 
        * */
       if (lruMaxSz <= 0) {
    	   return;
       }
       foundElm = linkMap.get(key);
       if (foundElm == null) {
		  /* 3. If not found then check current size, if it is equal to Max allowed, 
		   *    then remove first element in the list and add new element, which will 
		   *    be added at the front.
		   * 4. If less, then create new entry, this will add the element at the end 
		   */
    	 if (linkMap.size() == lruMaxSz) {
		      /* Remove first element in the list (oldest, as ordering is done on insertion),
               * now add new element, which will add at the end. */
    		  Map.Entry<Integer, Integer> first = null;
    		  for (Map.Entry<Integer, Integer> e: linkMap.entrySet()) {
    			 first = e; 
    			 break;
    		  }
    		  linkMap.remove(first.getKey());
    	  }
   		  linkMap.put(key, val);
       } else {
    	   /* We found element, just remove and add back with new val, this will add the element 
    	    * at the end */
    	   linkMap.remove(key);
    	   linkMap.put(key, val);
       }
    }

    public void printList() {
    	if (lruMaxSz <= 0) {
    		return;
    	}
    	System.out.printf("LRU list:");
    	for (Map.Entry<Integer, Integer> e : linkMap.entrySet()) {
    		System.out.printf(" %d=%d,", e.getKey(), e.getValue());
    	}
    	System.out.printf("\n");
        return;	
    }
}
