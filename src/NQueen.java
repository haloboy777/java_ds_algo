import java.util.Arrays;

public class NQueen {

  public static void main(String[] args) {
    int N = 10;
    int[][] arr = new int[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        arr[i][j] = 0;
      }
    }

    long time = System.currentTimeMillis();
    if (nQueen(arr, 0, N)) {
      System.out.println(Arrays.deepToString(arr));
    }
    System.out.println(System.currentTimeMillis() - time);
  }

  static boolean isSafe(int[][] arr, int row, int column, int N) {
    // System.out.println(row + " " + column);
    for (int i = 0; i < column; i++) {
      if (arr[row][i] == 1) {
        return false;
      }
    }

    for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
      if (arr[i][j] == 1) {
        return false;
      }
    }
    for (int i = row, j = column; i >= 0 && j < N; i--, j++) {
      if (arr[i][j] == 1) {
        return false;
      }
    }

    return true;
  }

  static boolean nQueen(int[][] arr, int col, int N) {
    if (col >= N) return true;

    for (int i = 0; i < N; i++) {
      if (isSafe(arr, i, col, N)) {
        arr[i][col] = 1;
        if (nQueen(arr, col + 1, N)) {
          return true;
        }
        arr[i][col] = 0;
      }
    }
    return false;
  }
}
