import java.util.ArrayList;
import java.util.PriorityQueue;

public class KLargestElements {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(11);
    arr.add(3);
    arr.add(4);
    // arr.add(6);

    System.out.println(solve(arr, 2).toString());
  }

  static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    for (Integer x : A) {
      q.add(x);
      if (q.size() > B) {
        q.poll();
      }
    }
    return new ArrayList<Integer>(q);
  }
}
