import java.util.ArrayList;
import java.util.HashMap;

public class TwoSum {

  public static void main(String[] args) {
    ArrayList<Integer> x = new ArrayList<>();
    x.add(2);
    x.add(7);
    x.add(11);
    x.add(15);

    System.out.println(twoSum(x, 9).toString());
  }

  static ArrayList<Integer> twoSum(ArrayList<Integer> A, int B) {
    ArrayList<Integer> x = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < A.size(); i++) {
      int a = A.get(i);
      if (map.containsKey(a)) {
        x.add(map.get(a));
        x.add(i);
        return x;
      } else {
        map.put(B - a, i);
      }
    }
    return x;
  }
}
