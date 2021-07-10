import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerElement {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(4);
    arr.add(5);
    arr.add(2);
    arr.add(10);
    arr.add(8);
    arr.add(1);
    System.out.println(prevSmaller(arr).toString());
  }

  static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
    ArrayList<Integer> result = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    stack.push(A.get(0));
    result.add(-1);
    for (int i = 1; i < A.size(); i++) {
      while (!stack.isEmpty() && stack.peek() >= A.get(i)) stack.pop();
      result.add(stack.isEmpty() ? -1 : stack.peek());
      stack.add(A.get(i));
    }
    return result;
  }
}
