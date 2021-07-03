import java.util.ArrayList;

public class GenerateParentheses {

  public static void main(String[] args) {
    String out = "";
    ArrayList<String> res = new ArrayList<>();
    int n = 3;
    solve(res, out, n, n);
    System.out.println(res.toString());
  }

  public static void solve(ArrayList<String> res, String out, int o, int c) {
    if (o == 0 && c == 0) {
      res.add(out);
      return;
    }
    if (o != 0) {
      String out1 = out + '(';
      solve(res, out1, o - 1, c);
    }
    if (c != 0 && o < c) {
      String out2 = out + ')';
      solve(res, out2, o, c - 1);
    }
  }
}
