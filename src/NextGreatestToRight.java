import java.util.ArrayList;
import java.util.Stack;

public class NextGreatestToRight {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(3);
    arr.add(2);
    arr.add(4);
    // arr.add(2);
    // arr.add(5);
    // arr.add(7);
    // arr.add(6);
    // arr.add(1);
    // arr.add(4);
    // arr.add(3);
    System.out.println(nextGreatest(arr).toString());
  }

  static ArrayList<Integer> nextGreatest(ArrayList<Integer> arr) {
    ArrayList<Integer> res = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    stack.push(arr.get(arr.size() - 1));
    for (int i = arr.size() - 1; i >= 0; i--) {
      if (stack.isEmpty()) {
        res.add(-1);
      } else {
        while (!stack.isEmpty() && stack.peek() <= arr.get(i)) {
          stack.pop();
        }
      }
      res.add(stack.isEmpty() ? -1 : stack.peek());
      stack.push(arr.get(i));
    }
    return res;
  }
}
