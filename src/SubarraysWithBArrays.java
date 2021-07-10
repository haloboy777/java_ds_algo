import java.util.ArrayList;

public class SubarraysWithBArrays {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    // arr.add(4);
    // arr.add(3);
    // arr.add(2);
    // arr.add(3);
    // arr.add(4);
    arr.add(5);
    arr.add(5);
    arr.add(1);
    arr.add(3);
    arr.add(1);
    System.out.println(solve(arr, 2));
  }

  static int solve(ArrayList<Integer> arr, int b) {
    int n = arr.size();
    int count = 0;
    int[] prefix = new int[n + 1];
    int odd = 0;

    // Traverse in the array
    for (int i = 0; i < n; i++) {
      prefix[odd]++;

      // If array element is odd
      if ((arr.get(i) & 1) == 1) odd++;

      // When number of odd
      // elements >= M
      if (odd >= b) count += prefix[odd - b];
    }

    return count;
  }
}
