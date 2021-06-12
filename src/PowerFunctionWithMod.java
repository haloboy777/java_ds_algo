public class PowerFunctionWithMod {

  public static void main(String[] args) {
    int a = 71045970;
    int b = 41535484;
    int c = 64735492;
    System.out.println(a + "^" + b + " % " + c);
    System.out.println(pow(a, b, c));
  }

  static int pow(int a, int b, int c) {
    long x = a;
    long z = c;
    long f = 1;
    if (x < 0) x = x + z;
    while (b > 0) {
      if (b % 2 == 1) {
        f = ((f % z) * (x % z)) % z;
        b--;
      }
      x = ((x % z) * (x % z)) % z;
      b = b / 2;
    }

    return (int) (f % z);
  }
}
