public class FirstMissingInteger {

  public static void main(String[] args) {
    int[] arr = { -8, -7, -6 };
    int lowest = Integer.MAX_VALUE;
    int highest = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < lowest) lowest = arr[i];
      if (arr[i] > highest) highest = arr[i];
      sum += arr[i];
    }
    if (sum > 0) {} else {}
    // System.out.println(num);
  }

  public String findDigitsInBinary(int A) {
    int BASE = 2;
    StringBuilder s = new StringBuilder();
    int n = A, rem;
    while (n > 0) {
      rem = n % BASE;
      s.append(String.valueOf(rem));
      n = (int) n / BASE;
    }
    return s.toString();
  }
}
