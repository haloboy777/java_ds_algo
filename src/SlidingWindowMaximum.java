import java.util.ArrayDeque;
import java.util.ArrayList;
public class SlidingWindowMaximum {

  public static void main(String[] args) {
    // int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
    int k = 3;
    // System.out.println(Arrays.toString(brute(arr, B)));
    ArrayList<Integer> arr = new ArrayList<>() {
      {
        add(1);
        add(3);
        add(-1);
        add(-3);
        add(5);
        add(3);
        add(6);
        add(7);
      }
    };
    System.out.println(optimized(arr, k).toString());
  }

  static ArrayList<Integer> optimized(ArrayList<Integer> arr, int k) {
    int n = arr.size();

    if (k <= 0 || arr == null || n == 0) {
      return new ArrayList<>();
    }

    ArrayList<Integer> ans = new ArrayList<>();

    int i = 0;
    int j = 0;
    ArrayDeque<Integer> q = new ArrayDeque<>();

    while (j < n) {
      while (!q.isEmpty() && arr.get(q.peekLast()) <= arr.get(j)) {
        q.removeLast();
      }
      q.addLast(j);

      if (j - i + 1 < k) {
        j++;
      } else if (j - i + 1 == k) {
        if (!q.isEmpty() && q.peekFirst() < i) q.removeFirst();
        ans.add(arr.get(q.peekFirst()));
        j++;
        i++;
      }
    }
    return ans;
  }

  static Integer[] brute(int[] arr, int n) {
    int max;
    Integer[] maxArr = new Integer[arr.length - n + 1];
    for (int i = 0; i < arr.length - n + 1; i++) {
      max = Integer.MIN_VALUE;
      for (int j = 0; j < n; j++) {
        if (arr[i + j] > max) max = arr[i + j];
      }
      maxArr[i] = max;
    }
    return maxArr;
  }
}
