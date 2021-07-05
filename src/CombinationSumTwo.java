import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;

public class CombinationSumTwo {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(10);
    arr.add(1);
    arr.add(2);
    arr.add(7);
    arr.add(6);
    arr.add(1);
    arr.add(5);

    ArrayList<ArrayList<Integer>> r = sum(arr, 8);
    System.out.println(r.toString());
  }

  static ArrayList<ArrayList<Integer>> sum(
    ArrayList<Integer> list,
    int target
  ) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    Stack<Integer> out = new Stack<>();
    HashSet<ArrayList<Integer>> set = new HashSet<>();
    Collections.sort(list);
    solve(out, list, set, res, target, 0);
    return res;
  }

  static void solve(
    Stack<Integer> out,
    ArrayList<Integer> arr,
    HashSet<ArrayList<Integer>> set,
    ArrayList<ArrayList<Integer>> res,
    int target,
    int index
  ) {
    int sum = out.stream().mapToInt(i -> i).sum();
    // System.out.println(sum + " " + out.toString());
    if (sum >= target) {
      if (sum == target) {
        ArrayList<Integer> l = new ArrayList<>(out);
        Collections.sort(l);
        if (!set.contains(l)) {
          set.add(l);
          res.add(l);
        }
      }
      return;
    }
    ArrayList<Integer> x = new ArrayList<>(arr);
    for (int i = index; i < x.size(); i++) {
      // System.out.print(i + " -> ");
      out.push(x.get(i));
      solve(out, x, set, res, target, i + 1);
      out.pop();
    }
  }
}
