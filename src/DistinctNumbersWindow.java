import java.util.ArrayList;
import java.util.HashMap;

public class DistinctNumbersWindow {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(2);
    arr.add(3);
    arr.add(4);
    arr.add(5);
    arr.add(6);
    // arr.add(3);
    // arr.add(4);
    // arr.add(3);
    System.out.println(dNums(arr, 3).toString());
  }

  static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
    ArrayList<Integer> res = new ArrayList<>();
    if (A.size() < B) return res;
    int x;
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < A.size(); i++) {
      x = A.get(i);
      if (map.containsKey(x)) {
        map.put(x, map.get(x) + 1);
      } else {
        map.put(x, 1);
      }

      if (i + 1 >= B) {
        res.add(map.size());
        x = A.get(i - B + 1);
        if (map.get(x) == 1) {
          map.remove(x);
        } else {
          map.put(x, map.get(x) - 1);
        }
      }
    }

    return res;
  }
}
