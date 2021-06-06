import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArray {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4, 0, 2, 1, 3));
    rearrangeArray(arr);
    System.out.println(arr.toString());
  }

  static void rearrangeArray(ArrayList<Integer> arr) {
    int[] a = new int[arr.size()];
    for (int i = 0; i < arr.size(); i++) {
      a[i] = arr.get(arr.get(i));
    }
    for (int i = 0; i < a.length; i++) {
      arr.set(i, (Integer) a[i]);
    }
  }
}
