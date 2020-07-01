import java.util.Stack;

public class SolutionTest {
     public static class Node {
         String name;
         Node left;
         Node right;

         public Node(String name) {
             this.name = name;
         }
     }

     public static String printzigzag(Node root) {
         Stack<Node> leftStack = new Stack<Node>();
         Stack<Node>   rightStack = new Stack<Node>();
         StringBuffer  retBuffer = new StringBuffer();

         if (root == null) {
             return "";
         }

         leftStack.push(root);
         Stack<Node>  cStack = leftStack;
         boolean isLeft = true;
         do {
             while (!cStack.empty()) {
                 Node c = cStack.pop();
                 retBuffer.append(c.name);
                 retBuffer.append(",");
                 if (isLeft) {
                     if (c.left != null) {
                         rightStack.push(c.left);
                     }
                     if (c.right != null) {
                         rightStack.push(c.right);
                     }
                 } else {
                     if (c.right != null) {
                         leftStack.push(c.right);
                     }
                     if (c.left != null) {
                         leftStack.push(c.left);
                     }
                 }
             }
             if (cStack.empty()) {
                 if (!leftStack.isEmpty()) {
                     isLeft = true;
                     cStack = leftStack;
                 } else if (!rightStack.isEmpty()) {
                     cStack = rightStack;
                     isLeft = false;
                 }
             }
         } while (!cStack.empty());

         return retBuffer.toString();
     }

    private static Node buildTestTree() {
        Node na = new Node("a");
        Node nb = new Node("b");
        Node nc = new Node("c");
        Node nd = new Node("d");
        Node ne = new Node("e");
        Node nf = new Node("f");
        Node ng = new Node("g");
        Node nh = new Node("h");
        Node ni = new Node("i");
        Node nj = new Node("j");
        na.left = nb;
        na.right = ne;
        nb.left = nc;
        nb.right = nd;
        ne.left = nf;
        ne.right = ng;
        nc.right = nj;
        nd.left = ni;
        ng.left = nh;
        return na;
    }

     public static void main(String[] args) {
         Node root = buildTestTree();
         String result = printzigzag(root);
         System.out.println("Ret: " + result);
     }
}
