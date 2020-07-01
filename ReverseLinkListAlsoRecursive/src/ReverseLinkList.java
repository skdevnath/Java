import sun.awt.image.ImageWatched;

public class ReverseLinkList {

    class LinkNode {
      LinkNode next;
      int data;
      public LinkNode(LinkNode next, int data) {
         this.next = next;
         this.data = data;
      }
    };
    public LinkNode reverseLinkList(LinkNode root) {
        LinkNode c = root;
        LinkNode n = root.next;
        c.next = null;
        LinkNode ret = null;
        while (c != null) {
            LinkNode nn = (n != null) ? n.next : null;
            if (n == null) {
                // This is the last element, we need to return this
                // We don't need to set n.next to current.
                ret = c;
            } else {
                n.next = c;
            }
            c = n;
            n = nn;
        }
        return ret;
    }
    public void printList(LinkNode root) {
       LinkNode c = root;
       while (c != null) {
          System.out.printf("%d->", c.data);
          c = c.next;
       }
       System.out.println("\n");
    }
    public void test() {
        // 4->1->8->2
        LinkNode l2 = new LinkNode(null, 2);
        LinkNode l8 = new LinkNode(l2, 8);
        LinkNode l1 = new LinkNode(l8, 1);
        LinkNode l4 = new LinkNode(l1, 4);
        printList(l4);

        LinkNode re = reverseLinkList(l4);
        printList(re);
    }
    public static void main(String[] args) {
        ReverseLinkList reverseLinkList = new ReverseLinkList();
        reverseLinkList.test();
    }

}
