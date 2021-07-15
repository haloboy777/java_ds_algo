import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class ProfitMaximisation {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(2);
    arr.add(3);

    System.out.println(solve(arr, 3));
  }

  static int solve(ArrayList<Integer> arr, int b) {
    int ans = 0;

    PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    q.addAll(arr);

    while (b != 0) {
      int k = q.poll();
      ans += k;
      q.add(k - 1);
      b--;
    }

    return ans;
  }
}
