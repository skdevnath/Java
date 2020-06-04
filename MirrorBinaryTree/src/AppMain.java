import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
  What is the time complexity ?
   We end up checking every Node and swap their childs.
   O(n)

  What is the space complexity ?
    O(n) - since for each element we save one element in the stack.
 */

public class AppMain {
    public static void main(String[] args) {
        Node root ;
        /*
                              1

                        2            3
                   4       5      6      7
                  8 9    10 11  12 13  14 15
         */
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);
        Node n13 = new Node(13);
        Node n14 = new Node(14);
        Node n15 = new Node(15);

        root = n1;

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n4.left = n8;
        n4.right = n9;

        n5.left = n10;
        n5.right = n11;

        n6.left = n12;
        n6.right = n13;

        n7.left = n14;
        n7.right = n15;

        System.out.println("\nFirst round of Mirroring using recursion:");
        mirrorNode(root);
        printTree(root);

        System.out.println("\nSecond round of Mirroring without recursion:");
        mirrorNodeNoRecur(root);
        printTree(root);
    }

    /*
     Note so easy to print in nice binary format. Following just works for height of 1,
     but not for more than that.
     Another way will be to save height of the Node. So while printing in following
     order, we check if anytime Node height changes, we print newline character.
    * */
    static void printTree(Node root) {
        /*
        1. First define a queue.
        2. Put the root node into the queue.
        3. Print/process the first element from the queue i.e. in this case the root node.
        4. While processing a node from the queue, add it’s child into the queue.
           Continue this until queue is empty.
        * */
        Queue<Node> q = new LinkedList<>();

        Node newLineNode = new Node(-1);
        q.add(root);
        q.add(newLineNode);
        while(q.size() != 0) {
            Node elm = q.remove();
            if (elm.val != -1) {
                System.out.printf(" %d ", elm.val);
            } else {
                System.out.printf("\n");
            }
            if (elm.left != null) {
                q.add(elm.left);
            }
            if (elm.right != null) {
                q.add(elm.right);
            }
        }
        return;
    }
    static void mirrorNode(Node root) {
        if (root == null) {
            return;
        }
        Node tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        if (root.left != null) {
            mirrorNode(root.left);
        }
        if (root.right != null) {
            mirrorNode(root.right);
        }
        return;
    }

    static void mirrorNodeNoRecur(Node root) {
        // We better use Queue = new LinkedList()
        Node current = root;
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node elm = stack.pop();
            Node tmp = elm.right;
            elm.right = elm.left;
            elm.left = tmp;

            if (elm.right != null) {
                stack.push(elm.right);
            }
            if (elm.left != null) {
                stack.push(elm.left);
            }
        }
    }
}
