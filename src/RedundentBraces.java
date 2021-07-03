import java.util.Stack;

public class RedundentBraces {

  public static void main(String[] args) {
    String s = "((a+b)*((b+c)/d))";
    System.out.println(braces(s));
  }

  static int braces(String s) {
    int n = s.length();
    Stack<Character> st = new Stack<>();
    int i = 0;
    while (i < n) {
      char ch = s.charAt(i);
      if (ch == ')') {
        int count = 0;
        while (!st.isEmpty() && st.peek() != '(') {
          char temp = st.pop();

          if (temp == '+' || temp == '*' || temp == '-' || temp == '/') count++;
        }
        if (count == 0) return 1; else st.pop();
      } else st.push(ch);

      i++;
    }

    return 0;
  }
}
