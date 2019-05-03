package MergeKLists;

public class Solution {
	private static ListNode putNodeToListSorted(ListNode list, ListNode newNode) {
		ListNode retNode = list;
		ListNode prevNode = null;
		ListNode currNode = list;
		if (newNode == null) {
			return retNode;
		}
		while ((currNode != null) && (newNode.val > currNode.val)) {
			prevNode = currNode;
			currNode = currNode.next;
		}
		if (prevNode != null) {
			prevNode.next = newNode;
			newNode.next = currNode;
		} else {
			retNode = newNode;
			newNode.next = list;
		}
		return retNode;
	}
	
	private static ListNode insertL2ToL1(ListNode l1, ListNode l2) {
		ListNode elemToAdd = l2;
		ListNode oldElemToAdd = null;
		ListNode l1StartPt = l1;
		ListNode newL1StartPt = null;
		while (elemToAdd != null) {
			ListNode nextElemToAdd = elemToAdd.next; 
			newL1StartPt = putNodeToListSorted(l1StartPt, elemToAdd);
			if (newL1StartPt != l1StartPt) {
			   if (l1StartPt == l1) {
				  l1 = newL1StartPt;
			   } else {
				   if (oldElemToAdd != null) {
					   oldElemToAdd.next = newL1StartPt;
				   }
			   }
			}
			l1StartPt = elemToAdd.next; 
			if (l1StartPt == null) {
				/* Came to the end of the l1 list, just add all remaining elements of l2 */
				elemToAdd.next = nextElemToAdd;
				/* We are done */
				elemToAdd = null;
				break;
			}
			oldElemToAdd = elemToAdd;
			elemToAdd = nextElemToAdd;
		}
		return l1;
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		ListNode retList = null;
		if (lists.length > 0) {
			retList = lists[0];
			ListNode l1 = lists[0];
			for (int i = 1; i < lists.length; i++) {
				retList = insertL2ToL1(l1, lists[i]);
				l1 = retList;
			}
		}
		return retList;
	}
}