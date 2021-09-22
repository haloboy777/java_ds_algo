import java.util.*;

public class KCLosestNum {

  public static void main(String[] args) {}

  static ArrayList<Integer> kClosest(ArrayList<Integer> arr, int num, int k) {
    ArrayList<Integer> res = new ArrayList<>();
    PriorityQueue<Pair> q = new PriorityQueue<>(
      k + 1,
      Collections.reverseOrder()
    );

    for (int i = 0; i < arr.size(); i++) {
      int l = Math.abs(arr.get(i) - num);
      q.add(new Pair(l, arr.get(i)));
      if (q.size() > k) q.poll();
    }
    for (Pair x : q) {
      res.add(x.num);
    }
    return res;
  }

  static class Pair implements Comparable<Pair> {

    int index;
    int num;

    public Pair(int i, int n) {
      this.index = i;
      this.num = n;
    }

    @Override
    public int compareTo(KCLosestNum.Pair o) {
      return index - o.index;
    }
  }
}
