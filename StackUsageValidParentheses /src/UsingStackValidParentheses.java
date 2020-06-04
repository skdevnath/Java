import java.util.Stack;
/*
https://leetcode.com/explore/interview/card/apple/344/array-and-strings/3117/

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
* */

public class UsingStackValidParentheses {
    class Brace {
        char typeOpen;
        char typeClose;
        Brace(char typeOpen, char typeClose){
            this.typeOpen = typeOpen; // Only open brace i.e. '{', '[', '('
            this.typeClose = typeClose; // Only close brace i.e. '}', ']', ')'
        }

    };
    public boolean isValid(String s) {
        Stack<Brace> trackStack = new Stack<Brace>();
        for(int i = 0; i < s.length(); i++) {
            char inChar = s.charAt(i);
            if (inChar == '{') {
                Brace curly = new Brace('{', '}');
                trackStack.push(curly);
            } else if (inChar == '}') {
                Brace brace = trackStack.pop();
                if (brace == null|| brace.typeClose != inChar) {
                    return false;
                }
            } else if (inChar == '[') {
                Brace curly = new Brace('[', ']');
                trackStack.push(curly);
            } else if (inChar == ']') {
                Brace brace = trackStack.pop();
                if (brace == null|| brace.typeClose != inChar) {
                    return false;
                }
            } else if (inChar == '(') {
                Brace curly = new Brace('(', ')');
                trackStack.push(curly);
            } else if (inChar == ')') {
                Brace brace = trackStack.pop();
                if (brace == null|| brace.typeClose != inChar) {
                    return false;
                }
            }
        }
        if (!trackStack.isEmpty()) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        UsingStackValidParentheses brace = new UsingStackValidParentheses();
        try {
            boolean isValid = brace.isValid("{}");
            System.out.println("Is valid:" + isValid);
        } catch (Exception e) {
            System.out.println("Is valid:" + false);
        }

        try {
            boolean isValid1 = brace.isValid("}");
            System.out.println("Is valid1:" + isValid1);
        } catch(Exception e) {
            System.out.println("Is valid1:" + false);
        }
    }
}
