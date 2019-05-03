package com.sandip.LruG4G;

public class LRUCache {
	int lruMaxSz = 0;
	int lruCurrentSz = 0;
	ListNode  list = null; 

    /*Inititalize an LRU cache with size N */
    public LRUCache(int N) {
       //Your code here
       lruMaxSz = N;
    }
    
    /*Returns the value of the key x if 
     present else returns -1 */
    public int get(int key) {
       ListNode entry = this.list;
       ListNode last = null;
       //Your code here
    	if (lruMaxSz <= 0) {
    		return -1;
    	}
        /* take the entry to front position */
    	while (entry != null) {
    		if (entry.key == key) {
    			break; 
    		}
    		last = entry;
    		entry = entry.next;
    	}
    	
    	if (entry != null) {
      	    /* move entry to the front */
    		if (last != null) {
    			last.next = entry.next;
    		}
    		entry.next = this.list;
    		this.list = entry;
    		return entry.val;
    	}
    	return -1;
    }
    
    /*Sets the key x with value y in the LRU cache */
    public void set(int key, int val) {
       ListNode entry = this.list;
       ListNode last = null;
       ListNode lastPrev = null;
       //Your code here
       /* 
        * 1. If max size is 0 then return 
        * 2. Search the element in the list, make a note of last element.
        * 3. If not found then check current size, if it is equal to Max 
        *    allowed, then overwrite last element in the list and put that at front. 
        * 4. If less, then create new entry and add at the front, increase lruCurrentSz 
        * 4. If found in the list, then move that element at front (As recently used),
        *    then overwrite with new value.
        * 5. Return 
        * */
       if (lruMaxSz <= 0) {
    	   return;
       }
       while (entry != null) {
    	  if (entry.key == key) {
    		 break; 
    	  }
    	  lastPrev = last;
    	  last = entry;
    	  entry = entry.next;
       }
       if (entry == null) {
    	  if (lruCurrentSz < lruMaxSz) {
    		 ListNode  newEntry = new ListNode(key, val); 
    		 newEntry.next = this.list;
    		 this.list = newEntry;
    		 lruCurrentSz++;
    	  } else {
    		 /* move last one to front, overwrite with new value */ 
    		  if (last != null) {
    		      last.key = key;
    		      last.val = val;
    		      if (lastPrev != null) {
    		    	  lastPrev.next = null;
    		      }
    		      last.next = this.list;
    		      this.list = last;
    		  }
    	  }
       } else {
    	   /* We found element, overritde */
    	   entry.val = val; 
    	   
    	   /* put at front */
    	   if (last != null)  {
    		   last.next = entry.next; 
    	   }
    	   entry.next = this.list;
    	   this.list = entry;
       }
    }

    public void printList() {
       ListNode entry = this.list;
    	if (lruMaxSz <= 0) {
    		return;
    	}
    	System.out.printf("LRU list:");
        /* take the entry to front position */
    	while (entry != null) {
    		System.out.printf(" %d=%d,", entry.key, entry.val);
    		entry = entry.next;
    	}
    	System.out.printf("\n");
        return;	
    }
}
