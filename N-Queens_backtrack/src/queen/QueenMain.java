package queen;
import java.util.*;

/*
* https://www.hackerearth.com/practice/basic-programming/recursion/recursion-and-backtracking/tutorial/
   Nice explanation, the only issue I see that you pass N-1 row/column of chess board in recursion call, chess board size is not reducing right ? may be check in leetcoding ?

 I have my google doc on backtracking
 */
public class QueenMain {
    public static void main(String args[]) {
        int n = 4;
        List<List<String>> solutionBoard = solveNQueens(n);
        System.out.println("Queen placed boards:");
        printBoards(solutionBoard);
    }
    public static void printBoards(List<List<String>> solutionBoards) {
        System.out.println("Total number of solutions: " + solutionBoards.size());
        for (int s = 0; s < solutionBoards.size(); s++) {
            List<String> solution = solutionBoards.get(s);

            System.out.println("Solution #" + s + ":");
            for (int row = 0; row < solution.size(); row++) {
                System.out.println(solution.get(row));
            }
        }
    }

    public static void printBoard(List<List<String>> board) {
        for (int j = 0; j < board.size(); j++) {
            for(int i = 0; i < board.get(j).size(); i++) {
                System.out.printf("%s ", board.get(j).get(i));
            }
            System.out.printf("\n");
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        //System.out.println("Initial board:");
        //printBoard(board);

        // Start filling Q from first cell
        int totalCells = n*n;
        int lastStartCell = totalCells - n - 1;
        for (int startCell = 0; startCell < lastStartCell; startCell++) {
            int qToPlace = n;
            int x = startCell % n;
            int y = startCell / n;
            List<List<String>> board = new ArrayList<List<String>>();
            for (int j = 0; j < n; j++) {
                List<String> row = new ArrayList<String>();
                for (int i = 0; i < n; i++) {
                    row.add(i, ".");
                }
                board.add(j, row);
            }

            // Start putting Queens
           board.get(y).set(x, "Q");
           qToPlace--;
           while (qToPlace != 0) {
               if (putQIfFree(board)) {
                  qToPlace--;
               } else {
                  resetTheBoard(board); // Can't put any more Queen, start over from new position.
                  break;
               }
           }
           if (qToPlace == 0) {
               // We achieved our goal, add to the solutions.
               List<String> boardSolutionFormat = new ArrayList<String>();
               for (int row = 0; row < board.size(); row++) {
                   List<String> rowList = board.get(row);
                   String rowValue = "";
                   for (String col: rowList) {
                       rowValue += col;
                   }
                   boardSolutionFormat.add(rowValue);
               }
               solutions.add(boardSolutionFormat);
           }
        }
        return solutions;
    }

    static boolean putQIfFree(List<List<String>> board) {
        for (int j = 0; j < board.size(); j++) {
            for(int i = 0; i < board.get(j).size(); i++) {
                // System.out.printf("%s ", board.get(j).get(i));
                if (checkQPlace(board, i, j)) {
                    board.get(j).set(i, "Q");
                    return true;
                }
            }
            System.out.printf("\n");
        }
        return false;
    }

    static boolean checkQPlace(List<List<String>> board, int x, int y) {
        for (int j = 0; j < board.size(); j++) {
            for(int i = 0; i < board.get(j).size(); i++) {
                if (board.get(j).get(i) == "Q") {
                   if ((i + j) == (x + y) || (i - j) == (x - y))  {
                       return false;
                   }
                   if ((x == i) || (y == j)) {
                      return false;
                   }
                }
            }
        }
        return true;
    }

    static void resetTheBoard(List<List<String>> board) {
        for (int j = 0; j < board.size(); j++) {
            for(int i = 0; i < board.get(j).size(); i++) {
                board.get(j).set(i, ".");
            }
        }
        return;
    }
}
