package com.sandip.Queue;
import java.util.LinkedList;

public class QueueTest {
	/* You can't do following as Queue is not implemented class. 
	 * static Queue<String> q = new Queue<String>(); 
	 * 
	 * Each Queue method exists in two forms: (1) one throws an exception if the operation fails, and (2) the other returns a special value if the operation fails (either null or false, depending on the operation). The regular structure of the interface is illustrated in the following table.
		Queue   Interface Structure
		Type of Operation |	Throws exception  |	Returns special value
		------------------|-------------------+----------------------
		Insert	          | add(e)	          | offer(e)
		Remove	          | remove()	      | poll()
		Examine			  | element()	      | peek()
	 */
	
	static LinkedList<String> q = new LinkedList<String>();
	
	static void test() {
		q.add("Sandip");
		q.add("Raj");
		q.add("Tiwari");
		q.add("Ashish");
		
		/* Print all elements */
		for (String e: q) {
			System.out.println(e + ", ");
		}
		
		/* remove top element */
		try {
			q.remove();
			q.remove();
			q.remove();
			q.remove();
			q.remove();
		} catch (Exception e) {
		   System.out.println(e);	
		} finally {
		   System.out.printf("This should execute, even if there is no exception\n");	
		}

		/* Print all elements after remove */
		System.out.println("Elements after remove:");
		for (String e: q) {
			System.out.println(e + ", ");
		}
		
	}
	
}
