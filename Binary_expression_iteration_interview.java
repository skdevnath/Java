import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Write down a tree data structure to represent Boolean expressions such as:

((true && false) || !(false || false)) && (true && !false)

Can be represented as a tree that looks like:

                     &&

                 /        \

            ||                &&
       
        /        \         /      \

      &&           ||    true    false

   /     \       /    \

 true  false  false  false

These expressions can contain:

literals (true and false)
logical operators && and ||, which have their usual meaning
We won't be asking you to write a parser, but we will be asking you to write some functions over the tree. For this exercise we only ask to support literals as leaf nodes, but in principle one should be able to support more complicated predicates.

It's safe to assume the logical AND and OR operators are binary operators. That is, they accept two operands.

Part II
Write down a function to evaluate your tree to a Boolean value.

Part III
Add a negation operation to your tree. Unlike the other operators, this operator will be unary.

Part IV
There is a well-known rule - DeMorgan's rules - for transforming negations over logical AND and OR:

!(p && q) === (!p || !q)
!(p || q) === (!p && !q)

org:((true && false) || !(false || false)) && (true && !false)

!(((!(true && false) && (false || false)) || !(true && !false)))

The effect of these rules is to push the negation "down the tree".

Write a procedure that, given a tree containing negation operators, transforms it into a tree where the negation operators have been eliminated. This exercise is related to database query optimizations that push down predicates and other operators.

You can choose whether to generate a new tree or modify the existing tree in-place. We recommend generating a new tree for simplicity.

If it's not obvious, you can eliminate negations by pushing them down to the lowest level and then finally negating the literals.
*/

public class Solution {
    public static void main(String args[] ) throws Exception {
        System.out.println("Hello World");
        
         Node n1 = new Node("&&", new Node("true", null, null), new Node("false", null,null));
    
         Node n2 = new Node("||", new Node("false",null, null), new Node("false", null, null));
         Node n22 = new Node("!", n2, null);

    
        Node n3 = new Node("||", n1, n22);
        Node n4 = new Node("&&", new Node("true", null, null), new Node("!", new Node("false", null, null), null));
        Node n5 = new Node("&&", n3, n4);
    
        Node root = n5;
        System.out.println("Output of ev: " + evalute(root));
    }
    
    public static  boolean evalute(Node op) {
        if (op == null) {
            System.out.println("Error: null node");
            return false; // TODO
        }
        if (op.op == "true") {
            return true;
        }
        
        if (op.op == "false") {
            return false;
        }
        
        if (op.left != null) {
           boolean leftEv = evalute(op.left);
           if (op.op == "!") {
               return !leftEv;
           }
           if (op.right != null) {
               boolean rightEv = evalute(op.right);
               if (op.op == "&&") {
                   return leftEv && rightEv;
               } else if (op.op == "||") {
                   return leftEv || rightEv;
               }

           }
        }
        System.out.println("Error: unknown operator");
        return false; // we should not reach here
    }
    
    public static changeOp(Node top) {
        if (top.op == "!") {
            if (top.left.op == "||") {
                top.op = "&&";
                Node left = top.left;
                top.left = new Node("!",left.right, right);
                top.right = new Node("!", left.left, right)
            }
        }
    }
}

 class Node {
    String  op = null;
    public Node(String op, Node left, Node right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }
   public Node left = null;
   public Node right = null;
}    
    
    
    
