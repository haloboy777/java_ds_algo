import java.util.ArrayList;

public class IntersectionOfTwoArrays {

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>() {
      {
        add(1);
        add(2);
        add(3);
        add(3);
        add(4);
        add(5);
        add(6);
      }
    };
    ArrayList<Integer> B = new ArrayList<>() {
      {
        add(3);
        add(3);
        add(5);
      }
    };
    ArrayList<Integer> arr = new ArrayList<>();

    int n = A.size();
    int m = B.size();

    int i = 0;
    int j = 0;

    while (i < n && j < m) {
      if (A.get(i) < B.get(j)) {
        i++;
      } else if (B.get(j) < A.get(i)) {
        j++;
      } else if (A.get(i) == B.get(j)) {
        arr.add(A.get(i));
        i++;
        j++;
      }
    }

    System.out.println(arr.toString());
  }
}
