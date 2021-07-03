import java.util.ArrayList;
import java.util.HashMap;

public class NByThreeRepeat {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    arr.add(1);
    arr.add(1);
    arr.add(2);
    arr.add(2);
    arr.add(2);
    arr.add(2);
    if (arr.size() < 3 && arr.size() > 0) {
      System.out.println(arr.get(0));
      System.exit(0);
    }
    int size = arr.size() / 3;
    for (int i : arr) {
      if (!map.containsKey(i)) {
        map.put(i, 1);
      } else {
        int t = map.get(i) + 1;
        if (t > size) {
          System.out.println(i);
          System.exit(0);
        }
        map.put(i, t);
      }
    }
    System.out.println("all are under size/3 = " + size);
  }
}
