import java.util.*;

public class WoodCuttingMadeEasy {

  public static void main(String[] args) {
    int[] a = { 20, 15, 10, 17 };
    int b = 7;
    System.out.println(solve(a, b));
  }

  static int solve(int[] A, int B) {
    int start = 0;
    int end = Arrays.stream(A).max().getAsInt();

    int ans = -1;

    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (isPossibleToCut(A, B, mid)) {
        ans = mid;
        start = mid + 1;
      } else end = mid - 1;
    }
    return ans;
  }

  static boolean isPossibleToCut(int[] nums, int B, int currHeight) {
    long totalCur = 0;

    for (int num : nums) {
      int r = 0;
      if (num > currHeight) {
        r = num - currHeight;
      }
      totalCur = totalCur + r;
    }

    return totalCur >= B;
  }
}
