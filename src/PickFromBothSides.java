public class PickFromBothSides {

  public static void main(String[] args) {
    int[] arr = { 5, -2, 3, 1, 2 };

    System.out.println(solve(arr, 3));
  }

  static int solve(int[] arr, int B) {
    int n = arr.length;
    int sum = 0;
    int res = 0;
    for (int i = 0; i < B; i++) res += arr[i];

    sum = res;
    for (int i = 0; i < B; i++) {
      sum -= arr[B - 1 - i];
      sum += arr[n - 1 - i];

      res = Math.max(res, sum);
    }
    return res;
  }
}
