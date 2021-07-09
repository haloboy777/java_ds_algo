import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {

  public static void main(String[] args) {
    System.out.println(solveNQueens(4));
  }

  static List<List<String>> solveNQueens(int n) {
    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) board[i][j] = '.';
    List<List<String>> res = new ArrayList<List<String>>();
    boolean leftRow[] = new boolean[n];
    boolean upperDiagonal[] = new boolean[2 * n - 1];
    boolean lowerDiagonal[] = new boolean[2 * n - 1];
    solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
    return res;
  }

  static void solve(
    int col,
    char[][] board,
    List<List<String>> res,
    boolean leftRow[],
    boolean lowerDiagonal[],
    boolean upperDiagonal[]
  ) {
    if (col == board.length) {
      res.add(construct(board));
      return;
    }

    for (int row = 0; row < board.length; row++) {
      if (
        !leftRow[row] &&
        !lowerDiagonal[row + col] &&
        !upperDiagonal[board.length - 1 + col - row]
      ) {
        board[row][col] = 'Q';
        leftRow[row] = true;
        lowerDiagonal[row + col] = true;
        upperDiagonal[board.length - 1 + col - row] = true;
        solve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);
        board[row][col] = '.';
        leftRow[row] = false;
        lowerDiagonal[row + col] = false;
        upperDiagonal[board.length - 1 + col - row] = false;
      }
    }
  }

  static List<String> construct(char[][] board) {
    List<String> res = new LinkedList<String>();
    for (int i = 0; i < board.length; i++) {
      String s = new String(board[i]);
      res.add(s);
    }
    return res;
  }
}
