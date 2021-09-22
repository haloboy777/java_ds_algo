import java.util.*;

public class QuesGulu {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    // {6, -3, -10, 0, 2} -2, -40, 0, -2, -3
    // arr.add(-1);
    // arr.add(-3);
    // arr.add(-10);
    // arr.add(0);
    // arr.add(60);
    // arr.add(6);
    // arr.add(-3);
    // arr.add(-10);
    // arr.add(0);
    // arr.add(2);
    // arr.add(-2);
    // arr.add(-40);
    // arr.add(0);
    // arr.add(-2);
    // arr.add(-3);
    // arr.add(-1);
    // arr.add(1);
    // arr.add(2);
    // arr.add(-3);
    // arr.add(4);
    // arr.add(5);
    // arr.add(3);
    // arr.add(-1);
    System.out.println(getMax(arr));
  }

  static int getMax(ArrayList<Integer> arr) {
    int res = 1;
    int local_max = 1, local_min = 1;
    // int start_idx = 0;
    for (int i = 0; i < arr.size(); i++) {
      int temp = local_max;
      local_max = Math.max(arr.get(i) * local_max, arr.get(i) * local_min);
      local_min = Math.min(arr.get(i) * temp, arr.get(i) * local_min);
      res = Math.max(res, local_max);
    }
    return res;
  }
}
