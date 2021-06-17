public class StrStr2 {

  // this code doesn't work.
  // don't bother.
  public static void main(String[] args) {
    String s =
      "bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba";
    String x = "babaaa";
    int i = 0;
    int j = 0;
    while (i < s.length() && j < x.length()) {
      if (s.charAt(i) == x.charAt(j)) {
        j++;
      } else {
        j = 0;
      }
      i++;
    }
    if (j == x.length()) {
      System.out.println((i - j) + " -> " + j);
    }
    System.out.println(-1);
  }
}
