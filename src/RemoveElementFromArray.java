import java.util.ArrayList;

public class RemoveElementFromArray {

  public static void main(String[] args) {}

  public int removeElement(ArrayList<Integer> a, int b) {
    a.removeIf(t -> t == b);
    return a.size();
  }
}
