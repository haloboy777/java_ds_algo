public class TowerOfHanoi {

  static long count;

  public static void main(String[] args) {
    count = 0;
    solve(1, 2, 3, 5);
    System.out.println("No. of steps: " + count);
  }

  static void solve(int s, int d, int h, int n) {
    ++count;
    if (n == 1) {
      System.out.println( s + " -> " + d + " <");
      return;
    }
    solve(s, h, d, n - 1);
    System.out.println( s + " -> " + d);
    solve(h, d, s, n - 1);
  }
}
