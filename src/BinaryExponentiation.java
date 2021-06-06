public class BinaryExponentiation {

  public static void main(String[] args) {
    // calculate a ^ n
    long startTime = System.currentTimeMillis();

    System.out.println(normalPower(2, 63));

    System.out.println(System.currentTimeMillis() - startTime);
  }

  static long normalPower(int a, int n) {
    long result = 1;
    for (int i = 0; i < n; i++) {
      result *= a;
    }
    return result;
  }
}
