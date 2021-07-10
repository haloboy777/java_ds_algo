import java.util.ArrayList;
import java.util.Stack;

public class NearestGreaterToLeft {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(3);
    arr.add(2);
    arr.add(4);
    System.out.println(greaterLeft(arr).toString());
  }

  static ArrayList<Integer> greaterLeft(ArrayList<Integer> arr) {
    ArrayList<Integer> res = new ArrayList<>();
    Stack<Integer> s = new Stack<>();
    s.add(arr.get(0));
    res.add(-1);
    for (int i = 1; i < arr.size(); i++) {
      if (s.isEmpty()) {
        res.add(-1);
      } else {
        while (!s.isEmpty() && s.peek() <= arr.get(i)) {
          s.pop();
        }
      }
      res.add(s.isEmpty() ? -1 : s.peek());
      s.push(arr.get(i));
    }

    return res;
  }
}
