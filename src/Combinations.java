import java.util.ArrayList;
import java.util.Stack;

public class Combinations {

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> r = combine(3, 2);
    System.out.println(r.toString());
  }

  static ArrayList<ArrayList<Integer>> combine(int a, int b) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    solve(res, stack, a, b, 1);
    return res;
  }

  static void solve(
    ArrayList<ArrayList<Integer>> res,
    Stack<Integer> out,
    int a,
    int b,
    int index
  ) {
    if (out.size() == b) {
      res.add(new ArrayList<>(out));
      return;
    }

    for (int i = index; i <= a; i++) {
      out.push(i);
      solve(res, out, a, b, i + 1);
      out.pop();
    }
  }
}
