/*
Given a string S. The task is to print all permutations of a given string.


 */

public class PermutationMainApp {
    public static void main(String[] args) {
        String str = "123";
        char[] strArray = str.toCharArray();
        printPermutations(0, strArray);
    }
    public static  void printPermutations(int s, char[] strArray) {
        if (s == strArray.length - 1) {
            System.out.print(new String(strArray) + ", ");
        }
        for (int i = s; i < strArray.length; i++) {
            if (s == 0) {
               System.out.println("i=" + i + " str[i]:" + strArray[i]);
            }
            char tmpChar = strArray[s];
            strArray[s] = strArray[i];
            if (s == 0) {
                System.out.println("str[s]:" + strArray[s]);
            }
            strArray[i] = tmpChar;
            printPermutations(s + 1, strArray);
        }
    }
}
