public class ModNthFibonacci {

  static int mod = 1000000007;

  public static void main(String[] args) {
    // {f(n) = f(n-1) + f(n-2)}
    // el * binaryExponentiation(transitionMatrix) = ans
    // int ans = el * binaryExponentiation(3,5);
    long[][] transitionMatrix = { { 0, 1 }, { 1, 1 } };
    int pos = 47;
    transitionMatrix = binaryExponentiation(transitionMatrix, pos);
    // int[] r = { 0, 1 };
    // r[0] = r[0] * transitionMatrix[0][0] + r[1] * transitionMatrix[1][0];
    // r[1] = r[1] * transitionMatrix[0][1] + r[1] * transitionMatrix[1][1];
    System.out.println((int) (transitionMatrix[1][0] % mod));
    // System.out.println(list[pos]);
  }

  static long[][] binaryExponentiation(long[][] transitionMatrix, int n) {
    // calc -> a^n

    // Identity element
    long[][] id = { { 1, 0 }, { 0, 1 } };

    // int a -> int[][] a

    while (n > 0) {
      if (n % 2 == 1) {
        id = multiply(id, transitionMatrix); // Matrix multiplication
        n--;
      } else {
        transitionMatrix = multiply(transitionMatrix, transitionMatrix); // Matrix multiplication
        n = n / 2;
      }
    }
    return id;
  }

  static long[][] multiply(long[][] a, long[][] b) {
    long[][] r = new long[2][2];
    r[0][0] = (((a[0][0] * b[0][0]) % mod) + ((a[0][1] * b[1][0]) % mod)) % mod;
    r[0][1] = (((a[0][0] * b[0][1]) % mod) + ((a[0][1] * b[1][1]) % mod)) % mod;
    r[1][0] = (((a[1][0] * b[0][0]) % mod) + ((a[1][1] * b[1][0]) % mod)) % mod;
    r[1][1] = (((a[1][0] * b[0][1]) % mod) + ((a[1][1] * b[1][1]) % mod)) % mod;
    return r;
  }
}
