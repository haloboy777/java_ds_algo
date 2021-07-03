public class BinaryExponentiation {

  public static void main(String[] args) {
    // calculate a ^ n
    long startTime = System.currentTimeMillis();

    System.out.println(normalPower(2, 63));

    System.out.println(System.currentTimeMillis() - startTime);

    startTime = System.currentTimeMillis();

    System.out.println(power(71045970, 41535484, 64735492));

    System.out.println(System.currentTimeMillis() - startTime);
  }

  static long normalPower(int a, int n) {
    long result = 1;
    for (int i = 0; i < n; i++) {
      result *= a;
    }
    return result;
  }

  static int power(long a, long n, long d) {
    long res = 1;
    while (n > 0) {
      if (n % 2 == 1) {
        res = ((res % d) * (a % d)) % d;
        n--;
      } else {
        a = ((a % d) * (a % d)) % d;
        n = n / 2;
      }
    }
    return (int) ((res + d) % d);
  }


}
