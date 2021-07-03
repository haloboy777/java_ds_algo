import java.util.ArrayList;

public class MergeTwoSortedArray {

  public static void main(String[] args) {}

  static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
    if (a.size() == 0) {
      a.addAll(b);
      return;
    }
    if (b.size() == 0) return;
    ArrayList<Integer> arr = new ArrayList<>();
    int i = 0, j = 0;
    while (i < a.size() && j < b.size()) {
      if (a.get(i) > b.get(j)) {
        arr.add(b.get(j++));
      } else if (arr.get(i) < b.get(j)) {
        arr.add(a.get(i++));
      }
    }
    while (i < a.size()) {
      arr.add(a.get(i++));
    }
    while (j < b.size()) {
      arr.add(b.get(j++));
    }
    a = arr;
    System.out.println(a.toString());
  }
}
