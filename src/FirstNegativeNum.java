import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

// sliding window problem

public class FirstNegativeNum {

  public static void main(String[] args) {
    Integer[] arr = { 12, -1, -7, 8, -15, 30, 16, 28 };
    int k = 3;

    System.out.println(findNIntegers(arr, k).toString());
  }

  static ArrayList<Integer> findNIntegers(Integer[] arr, int k) {
    ArrayList<Integer> a = new ArrayList<>();
    Deque<Integer> x = new ArrayDeque<>();

    int i = 0, j = 0;

    while (j < arr.length) {
      if (arr[j] < 0) x.add(arr[j]);

      if (j - i + 1 < k) {
        j++;
      } else if (j - i + 1 == k) {
        if (x.isEmpty()) {
          a.add(0);
        } else {
          a.add(x.getFirst());
          if (arr[i] == x.getFirst()) {
            x.removeFirst();
          }
        }
        i++;
        j++;
      }
    }

    return a;
  }
}
