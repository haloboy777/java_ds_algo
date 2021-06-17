import java.util.Scanner;

public class ModularGCD {

  static int mod = 1000_000_007;

  public static void main(String[] args) {
    long A, B, n, t;
    Scanner sc = new Scanner(System.in);
    t = sc.nextLong();

    while (t-- > 0) {
      A = sc.nextLong();
      B = sc.nextLong();
      n = sc.nextLong();

      System.out.println(gcd(A, B, n));
    }
    sc.close();
  }

  static long gcd(long A, long B, long n) {
    if (A == B) {
      return (power(A, n, mod) + power(B, n, mod)) % mod;
    }

    long candidate = 1;
    long num = A - B;   

    for (long i = 1; i * i <= num; i++) {
      if (num % i == 0) {
        long tmp = (power(A, n, i) + power(B, n, i)) % i;
        if (tmp == 0) candidate = Math.max(candidate, i);
        tmp = (power(A, n, num / i) + power(B, n, num / i)) % i;

        if (tmp == 0) candidate = Math.max(candidate, num / i);
      }
    }
    return candidate % mod;
  }

  static long power(long a, long n, long d) {
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
    return res;
  }
}
