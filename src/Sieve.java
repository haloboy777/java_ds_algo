// import java.util.Arrays;

public class Sieve {

  static boolean[] arr;

  public static void main(String[] args) {
    final long startTime = System.currentTimeMillis();
    
    sieve(10000000);

    System.out.println("Total execution time: " + (System.currentTimeMillis() - startTime));
  }

  // static int[] sieveFast(int A) {
  //   int maxA = 9000000;
  //   arr = new boolean[maxA];

  // }
  static int[] sieve(int A) {
    int[] arr = new int[A + 1];
    if (A <= 1) return arr;
    int count = A;
    for (int i = 2; i <= A; i++) {
      arr[i] = i;
    }

    for (int i = 2; i * i <= A; i++) {
      for (int j = i * i; j <= A; j += i) {
        if (arr[j] != 0) if (arr[j] % i == 0) {
          arr[j] = 0;
          count--;
        }
      }
    }

    int[] a = new int[count - 1];
    int j = 0;
    for (int i = 0; i < A; i++) {
      if (arr[i] != 0) {
        a[j++] = (arr[i]);
      }
    }
    return arr;
  }
}
