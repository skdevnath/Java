/**
 * 
 */
package MergeKLists;

/**
 * @author sandip
 *
 */
public class MainMethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("Merged List: ");
		
		/* l1 = 1->5->9 */
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(5);
		// l1.next.next = new ListNode(9);
		
		/* l2 = 2->4->6 */
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(4);
		// l2.next.next = new ListNode(6);
		
		/* l3 = 3->7->8 */
		// ListNode l3 = new ListNode(3);
		// l3.next = new ListNode(7);
		// l3.next.next = new ListNode(8);
	    ListNode l3 = new ListNode(7);
	    l3.next = new ListNode(8);
		
	    ListNode[] lists = {l2, l1, l3};
	    ListNode mergedSList = Solution.mergeKLists(lists);
	    for (ListNode l = mergedSList; l != null; l = l.next) {
	    	System.out.printf(" %d ", l.val);
	    }
	    
	    /* [[1,2,2],[1,1,2]] */
	    ListNode ll1 = new ListNode(1);
	    ll1.next = new ListNode(2);
	    ll1.next.next = new ListNode(2);

	    ListNode ll2 = new ListNode(1);
	    ll2.next = new ListNode(1);
	    ll2.next.next = new ListNode(2);
	    
	    ListNode[] lists1 = {ll1, ll2};
	    ListNode mergedSList1 = Solution.mergeKLists(lists1);
	    System.out.printf("\n Merged list1:");
	    for (ListNode l = mergedSList1; l != null; l = l.next) {
	    	System.out.printf(" %d ", l.val);
	    }
	}
}
