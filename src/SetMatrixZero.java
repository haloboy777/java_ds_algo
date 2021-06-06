import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZero {

  public static void main(String[] args) {
    int[][] arr = {
      { 1, 0, 1, 1 },
      { 1, 1, 1, 1 },
      { 1, 1, 1, 1 },
      { 1, 1, 0, 1 },
    };
    setZero(arr, 4, 4);
  }

  static void setZero(int[][] arr, int m, int n) {
    ArrayList<Integer> idx = new ArrayList<>();
    ArrayList<Integer> jdx = new ArrayList<>();

    for (int i = 0; i <= m; i++) {
      for (int j = 0; j < n; j++) {
        // read the array
        if (i != m) {
          if (arr[i][j] == 0) {
            idx.add(i);
            jdx.add(j);
          }
        }
        // set the array
        if (i != 0) {
          if (idx.contains(i - 1) || jdx.contains(j)) {
            arr[i - 1][j] = 0;
          }
        }
      }
    }
    System.out.println(Arrays.deepToString(arr));
  }
}
