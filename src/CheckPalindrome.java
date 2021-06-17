public class CheckPalindrome {

  public static void main(String[] args) {
    String s = "race a car";

    int n = s.length();
    int i = 0;
    int j = n - 1;

    while (i < j) {
      if (!Character.isLetterOrDigit(s.charAt(i))) {
        ++i;
        continue;
      }
      if (!Character.isLetterOrDigit(s.charAt(j))) {
        --j;
        continue;
      }

      char x = Character.toLowerCase(s.charAt(i));
      char y = Character.toLowerCase(s.charAt(j));
      if (!(x == y)) {
        System.out.println("Is not a palindrome");
        System.exit(0);
      } else {
        ++i;
        --j;
      }
    }
    System.out.println("Is a palindrome");
  }
}
