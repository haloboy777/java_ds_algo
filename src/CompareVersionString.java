public class CompareVersionString {

  public static void main(String[] args) {
    String a = "13.0";
    String b = "13.0.0";

    System.out.println(whoIsBig(a, b));
  }

  static int whoIsBig(String a, String b) {
    int i = 0;
    int j = 0;

    int lastDotI = 0;
    int lastDotJ = 0;
    int dotCount = 0;

    while ((i < a.length() && j < b.length()) || dotCount < 3) {
      if ((a.charAt(i) == '.' && b.charAt(j) == '.') || dotCount < 3) {
        ++dotCount;
        int res = compareLevel(
          a.substring(lastDotI, i),
          b.substring(lastDotJ, j)
        );
        lastDotI = ++i;
        lastDotJ = ++j;
        if (res == 0) continue;
        if (res > 0) return 1; else return -1;
      }

      if (a.charAt(i) != '.') ++i;
      if (b.charAt(j) != '.') ++j;
    }
    return 0;
  }

  public static int compareLevel(String a, String b) {
    // if a > b return 1
    // else if b > a  return -1
    // else return 0
    if (a.length() > 0 && b.length() > 0) {
      long x = Long.parseLong(a);
      long y = Long.parseLong(b);
      if (x > y) return 1; else if (y > x) return -1; else return 0;
    } else {
      return -1;
    }
  }
}
