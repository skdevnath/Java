import java.util.HashMap;
import java.util.TreeMap;

public class Test {
    class Result {
        String term;
        int count;

        @Override
        boolean isEqual(Object right) {
            // term
        }

        compareTo(Object right) {

        }
    }

    // ["error", "warn", "failed", "", ""] //1000
    // Top k search terms sorted by decreasing order
    // ["error", "warn"]
    String[] search = new String[]{"error", "error", "warn", "error"};
    int K;
    TreeMap<Result> retTree = new TreeMap<>();

    HashMap<String, Integer> searchHash = new HashMap<>();
    for (int i = 0; i < search.length; i ++) {
        int count = searchHash.getOrDefault(search[i], 0);
        searchHash.put(search[i], count + 1);

        Result result = retTree.get(search[i]);
        if (result == null) {
            renTree.add(new Result(search[i], count));
        } else {
            retTree.remove(result);
            retTree.put(result);
        }
    }


}
