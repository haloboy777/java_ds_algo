import java.util.Arrays;

public class FirstMissingInteger {

  public static void main(String[] args) {
    int[] A = { 3, 4, -1, 1 };
    Arrays.sort(A);
    int m = 1;

    for (int i = 0; i < A.length; i++) {
      if (A[i] > 0) {
        if (A[i] == m) m++; else {
          System.out.println(m);
          System.exit(0);
        }
      }
    }
    System.out.println(m);
  }
}
