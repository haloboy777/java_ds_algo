public class CountAndSay {

  public static void main(String[] args) {
    int n = 5;
    StringBuilder ans = new StringBuilder("1");
    for (int i = 1; i < n; i++) {
      ans = findNext(ans);
    }

    System.out.println(ans);
  }

  static StringBuilder findNext(StringBuilder sb) {
    StringBuilder result = new StringBuilder();
    int i = 0;
    while (i < sb.length()) {
      int j = i;
      int count = 1;
      while (j < sb.length() - 1 && sb.charAt(j) == sb.charAt(j + 1)) {
        count++;
        j++;
      }
      result.append(count + "" + sb.charAt(i));
      i = j + 1;
    }
    return result;
  }
}
