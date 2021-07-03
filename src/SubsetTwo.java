import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class SubsetTwo {

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> op = new ArrayList<Integer>();
    HashSet<ArrayList<Integer>> set = new HashSet<>();
    ArrayList<Integer> arr = new ArrayList<Integer>();
    arr.add(1);
    arr.add(2);
    arr.add(2);
    // arr.add(4);
    Collections.sort(arr);

    solve(res, arr, op, set);
    Collections.sort(
      res,
      new Comparator<ArrayList<Integer>>() {
        @Override
        public int compare(
          ArrayList<Integer> first,
          ArrayList<Integer> second
        ) {
          int comp = 0;
          for (int i = 0; i < Math.min(first.size(), second.size()); i++) {
            comp = Integer.compare(first.get(i), second.get(i));
            if (comp != 0) {
              return comp;
            }
          }
          return Integer.compare(first.size(), second.size());
        }
      }
    );
    System.out.println(res.toString());
  }

  public static void solve(
    ArrayList<ArrayList<Integer>> res,
    ArrayList<Integer> ip,
    ArrayList<Integer> op,
    HashSet<ArrayList<Integer>> set
  ) {
    if (ip.isEmpty()) {
      if (!set.contains(op)) {
        res.add(op);
        set.add(op);
      }
      return;
    }
    ArrayList<Integer> op1 = new ArrayList<Integer>(op);
    ArrayList<Integer> op2 = new ArrayList<Integer>(op);
    op1.add(ip.get(0));
    ArrayList<Integer> ip1 = new ArrayList<Integer>(ip);
    ArrayList<Integer> ip2 = new ArrayList<Integer>(ip);

    ip1.remove(0);
    ip2.remove(0);
    solve(res, ip1, op1, set);
    solve(res, ip2, op2, set);

    return;
  }
}
