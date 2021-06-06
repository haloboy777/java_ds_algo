// import java.util.*;

public class MaxConsecutiveGap {

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 62, 1, 5, 6, 89, 1, 2, 3, 6, 45, 2 };
    // int[] arr = { 1, 2, 3, 4 };
    if (arr.length < 2) {
      // return 0;
      return;
    }
    int prev = -1;
    int max = Integer.MIN_VALUE;
    int num;
    int flag = 0;
    for (int i = 0; i < arr.length; i++) {
      num = arr[i];
      if (flag == 0) {
        prev = num;
        flag = 1;
      } else {
        max = Math.max(max, num - prev);
        prev = num;
      }
    }
    // return max == Integer.MIN_VALUE ? 0 : max;
  }
}
