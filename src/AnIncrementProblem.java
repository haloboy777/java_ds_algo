import java.util.ArrayList;

public class AnIncrementProblem {

  public static void main(String[] args) {
    ArrayList<Integer> x = new ArrayList<>();
    x.add(1);
    x.add(2);
    x.add(3);
    x.add(2);
    x.add(3);
    x.add(1);
    x.add(4);
    x.add(2);
    x.add(1);
    x.add(3);
    System.out.println(solve(x).toString());
  }

  static ArrayList<Integer> solve(ArrayList<Integer> A) {
    for (int i = 0; i < A.size(); i++) {
      int index = A.indexOf(A.get(i));
      if (index > -1 && index < i) {
        A.set(index, A.get(index) + 1);
      }
    }
    return A;
  }
}
