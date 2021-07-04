import java.util.ArrayList;

public class CombinationSum {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(2);
    arr.add(3);
    arr.add(6);
    arr.add(7);
    arr.add(8);

    ArrayList<ArrayList<Integer>> r = sum(arr, 7);
    System.out.println(r.toString());
  }

  static ArrayList<ArrayList<Integer>> sum(
    ArrayList<Integer> list,
    int target
  ) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> out = new ArrayList<>();

    solve(out, list, res, target);

    return res;
  }

  static void solve(
    ArrayList<Integer> out,
    ArrayList<Integer> arr,
    ArrayList<ArrayList<Integer>> res,
    int target
  ) {
    int sum = out.stream().mapToInt(i -> i).sum();
    if (sum >= target) {
      if (sum == target) res.add(out);
      return;
    }
    ArrayList<Integer> x = new ArrayList<>(arr);
    for (int i = 0; i < x.size(); i++) {
      System.out.println("arr: " + arr.toString());
      System.out.println("out: " + out.toString());
      ArrayList<Integer> o = new ArrayList<>(out);
      o.add(x.get(i));
      x.remove(i);
      solve(o, x, res, target);
    }
  }
}
