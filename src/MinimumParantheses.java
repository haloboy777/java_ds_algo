public class MinimumParantheses {

  public static void main(String[] args) {
    String a = "(()))((";
    int i = 0;
    int count = 0;
    int k = 0;

    do {
      if (a.charAt(i) == '(') {
        ++count;
      } else if (a.charAt(i) == ')') {
        if (count == k) {
          k++;
          count = k;
        } else {
          count--;
        }
      }
    } while (++i < a.length());
    System.out.println(count);
  }
}
