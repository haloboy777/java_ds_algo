import java.util.ArrayList;
import java.util.HashSet;

public class PairWithXOR {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(3);
    arr.add(8);
    arr.add(10);
    arr.add(15);
    arr.add(50);
    arr.add(6);

    System.out.println(solve(arr, 5));
  }

  static int solve(ArrayList<Integer> A, int B) {
    int count = 0;
    HashSet<Integer> map = new HashSet<>();

    for (int i = 0; i < A.size(); i++) {
      int a = A.get(i);
      if (map.contains(a)) {
        ++count;
      } else {
        map.add(B ^ a);
      }
    }

    return count;
  }
}
