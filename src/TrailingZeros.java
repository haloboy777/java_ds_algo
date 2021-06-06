public class TrailingZeros {

  public static void main(String[] args) {
    // int count = 0;
    int A = 100000;
    // for (int i = A; i > 0; i--) {
    //   if (i % 5 == 0) {
    //     count += powerOfFive(i);
    //   }
    // }
    // System.out.println(count);
    System.out.println(numOfZeros(A));
  }

  static int powerOfFive(int i) {
    int count = 0;
    while (i % 5 == 0) {
      count++;
      i /= 5;
    }
    return count;
  }

  static int numOfZeros(int n) {
    int count = 0;
    while (n / 5 > 0) {
      n = n / 5;
      count += n;
    }
    return count;
  }
}
