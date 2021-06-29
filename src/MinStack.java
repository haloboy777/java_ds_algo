import java.util.Stack;

public class MinStack {

  public static void main(String[] args) {
    MStack s = new MStack();

    s.push(10);
    s.push(11);
    s.push(12);
    s.push(13);
    s.push(2);
    s.push(20);
    s.push(3);

    System.out.println(s.getMin());
  }

  static class MStack {

    Stack<Integer> minStack;
    Stack<Integer> s;

    public MStack() {
      s = new Stack<>();
      minStack = new Stack<>();
    }

    public void push(int x) {
      if (s.isEmpty()) {
        s.push(x);
        minStack.push(x);
      } else {
        s.push(x);
        int y = minStack.peek();
        if (x < y) {
          minStack.push(x);
        } else {
          minStack.push(y);
        }
      }
    }

    public int pop() {
      minStack.pop();
      return s.isEmpty() ? -1 : s.remove(0);
    }

    public int top() {
      return s.isEmpty() ? -1 : s.peek();
    }

    public int getMin() {
      return s.isEmpty() ? -1 : minStack.peek();
    }
  }
}
