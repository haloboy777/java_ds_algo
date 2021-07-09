import java.util.HashMap;

public class CanItBeAPalindrome {

  public static void main(String[] args) {
    System.out.println(solve("abcde"));
  }

  static int solve(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    int n = s.length();
    for (char c : s.toCharArray()) {
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }

    if (n % 2 == 0) {
      for (int x : map.values()) {
        if (x % 2 != 0) return 0;
      }
      return 1;
    } else {
      int flag = 0;
      for (int x : map.values()) {
        if (x % 2 == 1 && flag == 1) {
          return 0;
        } else if (x % 2 == 1 && flag == 0) {
          flag = 1;
        }
      }
      return 1;
    }
  }
}
