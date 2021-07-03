import java.util.ArrayList;

/**
 * Subsets
 */
public class Subsets {

  static int count;

  public static void main(String[] args) {
    ArrayList<Integer> ip = new ArrayList<>();
    ArrayList<Integer> op = new ArrayList<>();
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ip.add(1);
    ip.add(2);
    // ip.add(3);
    // ip.add(4);
    count = 0;
    generatList(ip, op, res);
    System.out.println(res.toString());
    System.out.println(count);
  }

  static void generatList(
    ArrayList<Integer> ip,
    ArrayList<Integer> op,
    ArrayList<ArrayList<Integer>> res
  ) {
    if (ip.isEmpty()) {
      ArrayList<Integer> x = new ArrayList<>(op);
      res.add(x);
      return;
    }

    ArrayList<Integer> op1 = new ArrayList<>(op);
    ArrayList<Integer> op2 = new ArrayList<>(op);
    ArrayList<Integer> ip1 = new ArrayList<>(ip);
    ArrayList<Integer> ip2 = new ArrayList<>(ip);

    op2.add(ip.get(0));
    ip1.remove(0);
    ip2.remove(0);

    generatList(ip1, op1, res);
    generatList(ip2, op2, res);
  }
}
