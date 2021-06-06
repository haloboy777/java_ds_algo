import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortLexicographically {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(9);
    arr.add(100);
    arr.add(1);
    arr.add(8);
    arr.add(8000);
    arr.add(8001);
    arr.add(3);
    arr.add(3000);
    arr.add(3001);
    arr.add(2);
    arr.add(9999);
    Comparator<Integer> lexCompare = new Comparator<Integer>() {
      public int compare(Integer x, Integer y) {
        String a = x.toString();
        String b = y.toString();
        if ((a + b).compareTo(b + a) > 0) {
          return -1;
        }
        return 1;
      }
    };
    arr.sort(lexCompare);
    System.out.println(arr);
  }

  public String largestNumber(final List<Integer> A) {
    ArrayList<Integer> arr = new ArrayList<>(A);
    Comparator<Integer> lexCompare = new Comparator<Integer>() {
      public int compare(Integer x, Integer y) {
        String a = x.toString();
        String b = y.toString();
        if ((a + b).compareTo(b + a) > 0) {
          return -1;
        }
        return 1;
      }
    };
    arr.sort(lexCompare);
    StringBuilder sb = new StringBuilder("");
    for (int i = 0; i < arr.size(); i++) {
      if (sb.isEmpty() && arr.get(i) == 0) continue;
      sb.append(arr.get(i));
    }
    if (sb.isEmpty()) sb.append("0");
    return sb.toString();
  }
}
