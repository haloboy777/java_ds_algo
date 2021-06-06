import java.util.Arrays;

public class NthFibonacci {

  public static void main(String[] args) {
    // int[][] a = { { 1, 2 }, { 3, 4 } };
    // int[][] b = { { 0, 1 }, { 1, 1 } };
    // multiply(a, b);
    // System.out.println(Arrays.deepToString(a));
    System.out.println(Arrays.toString(nthElement(30)));
  }

  // figuring out transition matrix
  // binary expentiation
  // multiplication of array

  static int[] nthElement(int n) {
    // {f(n) = f(n-1) + f(n-2)}
    // el * binaryExponentiation(transitionMatrix) = ans
    // int ans = el * binaryExponentiation(3,5);
    int[][] transitionMatrix = { { 0, 1 }, { 1, 1 } };
    transitionMatrix = binaryExponentiation(transitionMatrix, n);
    int[] r = { 0, 1 };
    r[0] = r[0] * transitionMatrix[0][0] + r[1] * transitionMatrix[1][0];
    r[1] = r[1] * transitionMatrix[0][1] + r[1] * transitionMatrix[1][1];
    return r;
  }

  static int[][] binaryExponentiation(int[][] transitionMatrix, int n) {
    // calc -> a^n

    // Identity element
    int[][] id = { { 1, 0 }, { 0, 1 } };

    // int a -> int[][] a

    while (n > 0) {
      if (n % 2 == 1) {
        id = multiply(id, transitionMatrix); // Matrix multiplication
        n--;
      }
      transitionMatrix = multiply(transitionMatrix, transitionMatrix); // Matrix multiplication
      n = n / 2;
    }
    return id;
  }

  static int[][] multiply(int[][] a, int[][] b) {
    int[][] r = new int[2][2];
    r[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0];
    r[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1];
    r[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0];
    r[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1];
    return r;
  }
}
