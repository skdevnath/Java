import java.util.LinkedList;
import java.util.Queue;

public class TreeBreatFirstMinDepth {
    public static void main(String[] args) {
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n2 = new Node(2); n2.right = n5; n2.left = n4;
        Node n3 = new Node(3);
        Node n1 = new Node(1); n1.right = n3; n1.left = n2;
        Node top = n1;
        try {
            int minDepth = minDepth(top);
            System.out.println("Min Depth: " + minDepth);
            int minDepth1 = minDepth(null);
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    /* No recursion */
    public static int minDepth(Node tree) throws Exception{
        if (tree == null) {
            throw new IllegalArgumentException("argument is null");
        }
        int depth = 0;
        Queue<Node> q = new LinkedList<Node>();
        Queue<Node> qNextLevel = new LinkedList<Node>();
        Queue<Node> currentQ = null;


        q.add(tree);
        currentQ = q;
        do {
            if (!currentQ.isEmpty()) {
               depth += 1;
            }
            while (!currentQ.isEmpty()) {
                Node e = currentQ.poll();
                // put childrens in new Q
                if (e.left != null) {
                    qNextLevel.add(e.left);
                }
                if (e.right != null) {
                    qNextLevel.add(e.right);
                }
                if (e.left == null && e.right == null) {
                    // found leaf node
                    return depth;
                }
            }
            currentQ = qNextLevel;
            qNextLevel = q;
            System.out.println("");
        } while(!currentQ.isEmpty());


        return depth;
    }
}
