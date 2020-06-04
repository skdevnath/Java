import java.security.InvalidParameterException;

public class MergeApp {
    public Node mergeSort(Node s, Node e) {
        if (s == null || s == e) {
            return s;
        }
        Node mid = findMid(s, e);
        Node sortedListLeft = mergeSort(s, mid);
        if (mid != s && mid != e) {
            Node sortedListRight = mergeSort(mid.next, e);
            merge(sortedListLeft, sortedListRight);
        } else {
            return sortedListLeft;
        }
    }

    public Node findMid(Node s, Node e) {
        // TODO:
        return s;
    }

    public Node merge(Node left, Node right) {
        // TODO
        return left;
    }
}
