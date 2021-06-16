public class CountTotalSetBits {

  public static void main(String[] args) {
    int a = 1;
    int n, count, sum = 0;
    while (a > 0) {
      n = a;
      count = 0;
      while (n > 0) {
        ++count;
        n = n & (n - 1);
      }
      // System.out.print(a + " : " + count + "\n");
      sum += count;
      --a;
    }
    System.out.println(sum);
  }
}
