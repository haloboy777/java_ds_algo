import java.util.ArrayList;

public class Permutations {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(2);
    arr.add(3);
    ArrayList<ArrayList<Integer>> x = permute(arr);

    System.out.println(x.toString());
  }

  static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> arr) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> out = new ArrayList<>();
    solve(res, arr, out);
    return res;
  }

  static void solve(
    ArrayList<ArrayList<Integer>> res,
    ArrayList<Integer> arr,
    ArrayList<Integer> out
  ) {

    if (arr.isEmpty()) {
      res.add(out);
      return;
    }

    for (int i = 0; i < arr.size(); i++) {
      ArrayList<Integer> x = new ArrayList<>(arr);
      ArrayList<Integer> o = new ArrayList<>(out);
      o.add(x.get(i));
      x.remove(i);
      solve(res, x, o);
    }
  }
}
