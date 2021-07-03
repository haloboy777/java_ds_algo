public class RecusrionProbs {

  public static void main(String[] args) {
    // printN(7);
    // print1(7);
  }

  static void printN(int n) {
    if (n == 0) return;
    printN(n - 1);
    System.out.println(n);
  }

  static void print1(int n) {
    if (n == 0) return;
    System.out.println(n);
    print1(n - 1);
  }
}
