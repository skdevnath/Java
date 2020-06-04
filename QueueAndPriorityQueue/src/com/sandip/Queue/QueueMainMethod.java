package com.sandip.Queue;
import java.util.*;

public class QueueMainMethod {

	public static void main(String[] args) {
		/* You can't do following as Queue is not implemented class.
		 * static Queue<String> q = new Queue<String>();
		 *
		 * PriorityQueue(): Elements are ordered as per the lowest value towards the Head. I.e. lowest value
		 *                  is considered high priority.
		 * Each Queue method exists in two forms: (1) one throws an exception if the operation fails,
		 * and (2) the other returns a special value if the operation fails (either null or false,
		 * depending on the operation). The regular structure of the interface is illustrated in the
		 * following table.
			Queue   Interface Structure
			Type of Operation |	Throws exception  |	Returns special value
			------------------|-------------------+----------------------
			Insert	          | add(e)	          | offer(e)
			Remove	          | remove()	      | poll()
			Examine			  | element()	      | peek()
			*
		o/p
		* Traversing the queue elements, Note: ordering is not ensured:
			101 Data Communications & Networking Forouzan Mc Graw Hill 4
			233 Operating System Galvin Wiley 6
			121 Let us C Yashwant Kanetkar BPB 8

			After removing one book record, Note: head of the element (lowest value) removed. Lowest value is consider high priority:
			121 Let us C Yashwant Kanetkar BPB 8
			233 Operating System Galvin Wiley 6

			After removing one book record:, Note: head of the element (lowest value) removed. Lowest value is consider high priority
			233 Operating System Galvin Wiley 6

		 */
		QueueTest.test();


		// Now check priorityQueue
		Queue<Book> queue=new PriorityQueue<Book>();
		//Creating Books
		Book b1=new Book(121,"Let us C","Yashwant Kanetkar","BPB",8);
		Book b2=new Book(233,"Operating System","Galvin","Wiley",6);
		Book b3=new Book(101,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
		//Adding Books to the queue
		queue.add(b1);
		queue.add(b2);
		queue.add(b3);
		System.out.println("\nTraversing the queue elements, Note: ordering is not ensured:");
		//Traversing queue elements
		for(Book b:queue){
			System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
		}
		queue.remove();
		System.out.println("\nAfter removing one book record, Note: head of the element (lowest value) removed. Lowest value is consider high priority:");
		for(Book b:queue){
			System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
		}

		queue.remove();
		System.out.println("\nAfter removing one book record:, Note: head of the element (lowest value) removed. Lowest value is consider high priority");
		for(Book b:queue){
			System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
		}

	}

}
