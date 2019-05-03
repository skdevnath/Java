package com.sandip.LruG4G;

public class LruMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache lru = new LRUCache(4);
		
		lru.set(1, 101);
		lru.set(2, 102);
		lru.set(3, 103);
		lru.set(4, 104);
		lru.printList();

		lru.set(5,503); /* This should kickout 1=101 */
		lru.printList();
	}

}
