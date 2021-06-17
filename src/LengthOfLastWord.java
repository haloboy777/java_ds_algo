/**
 * LengthOfLastWord
 */
public class LengthOfLastWord {

  public static void main(String[] args) {
    String a = "Hello World  ";
    int i = 0;
    int count = 0;
    while (i < a.length()) {
      if (i > 0 && a.charAt(i - 1) == ' ' && a.charAt(i) != ' ') {
        count = 1;
      } else if (a.charAt(i) != ' ') {
        ++count;
      }
      ++i;
    }
    System.out.println(count);
  }
}
