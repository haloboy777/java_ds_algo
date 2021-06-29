import java.util.Stack;

public class ReversePolishNotation {

  public static void main(String[] args) {
    // String[] s = {
    //   "10",
    //   "6",
    //   "9",
    //   "3",
    //   "+",
    //   "-11",
    //   "*",
    //   "/",
    //   "*",
    //   "17",
    //   "+",
    //   "5",
    //   "+",
    // };

    String[] s = { "3", "-500", "-100", "/" };

    System.out.println(evalRPN(s));
  }

  static int evalRPN(String[] exp) {
    Stack<String> s = new Stack<>();
    int a, b;
    for (String x : exp) {
      if (!(x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/"))) {
        s.push(x);
        continue;
      } else {
        b = Integer.parseInt(s.pop());
        a = Integer.parseInt(s.pop());
        switch (x) {
          case "+":
            s.push(String.valueOf(a + b));
            break;
          case "-":
            s.push(String.valueOf(a - b));
            break;
          case "*":
            s.push(String.valueOf(a * b));
            break;
          case "/":
            s.push(String.valueOf(a / b));
            break;
        }
      }
    }
    return Integer.parseInt(s.pop());
  }
}
