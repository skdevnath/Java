import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Solution {
    class Node {
        public String word;
        public ArrayList<String> genNbrStr = new ArrayList<String>();
        public List<Node> nbrs = new ArrayList<Node>();
        public Node(String word) {
            this.word = word;
            for (int i = 0; i < word.length(); i++) {
                StringBuffer strBuffer = new StringBuffer(word);
                strBuffer.setCharAt(i, '*');
                genNbrStr.add(strBuffer.toString());
            }
        }
    };
    class DestNode implements Comparable<DestNode> {
        public Node dest;
        public int cost;
        public Node nextHop;

        public DestNode(Node dest, Node nextHop, int cost) {
            this.dest = dest;
            this.cost = cost;
            this.nextHop = nextHop;
        }


        @Override
        public int compareTo(DestNode dn) {
            return (cost - dn.cost);
        }
    };
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        List<Node> nodeList = wordList.stream().map(word -> new Node(word)).collect(Collectors.toList());
        Node beginNode = null;
        Node endNode = null;
        for (Node node: nodeList) {
            if (node.word.contentEquals(beginWord)) {
                beginNode = node;
            }
            if (node.word.contentEquals(endWord)) {
                endNode = node;
            }
            if (beginNode != null && endNode != null) {
                break;
            }
        }
        if (endNode == null) {
            return 0;
        }

        // Find neighbors
        for (Node node: nodeList) {
            for (Node potNbr: nodeList) {
                if (potNbr != node) {
                    for (String curNodeGenStr: node.genNbrStr) {
                        if (potNbr.genNbrStr.contains(curNodeGenStr)) {
                            node.nbrs.add(potNbr);
                        }
                    }
                }
            }
        }

        if (endNode.nbrs.isEmpty()) {
            return 0;
        }
        // Build candidate Q, put beginNode first
        PriorityQueue<DestNode> candidate = new PriorityQueue<DestNode>();
        candidate.add(new DestNode(beginNode, beginNode, 1));

        // Take the first element out and put into path list. That will be shorted one.
        // Check if we found endNode or not.
        PriorityQueue<DestNode> pathList = new PriorityQueue<DestNode>();
        while(!candidate.isEmpty()) {
            DestNode toPath = candidate.remove();
            if (toPath.dest == endNode) {
                return toPath.cost;
            }
            // Put neighbors of path to candidate list
            for (Node nbr: toPath.dest.nbrs) {
                candidate.add(new DestNode(nbr, toPath.nextHop, toPath.cost + 1));
            }
            pathList.add(toPath);
        }
        return 0;
    }

    public static void main(String arg[]) {
        Solution solution = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> dic = new ArrayList<String>();
        dic.add("hot");
        dic.add("dot");
        dic.add("tog");
        dic.add("cog");
        int distance = solution.ladderLength(beginWord, endWord, dic);
    }
}
