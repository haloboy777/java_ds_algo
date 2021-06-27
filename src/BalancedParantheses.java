import java.util.Stack;

public class BalancedParantheses {

  public static void main(String[] args) {
    String A = "()))((()";
    Stack<Character> s = new Stack<>();
    for (char a : A.toCharArray()) {
      if (a == '(') s.push(a); else if (a == ')') {
        if (!s.isEmpty()) s.pop(); else break;
      }
    }
    System.out.println(s.isEmpty());
  }
}
