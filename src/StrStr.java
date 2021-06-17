import java.util.Arrays;

public class StrStr {

  static int mod = 1000_000_007;
  static long[] inv;
  static double[] arr;

  public static void main(String[] args) {
    String a =
      "aabaaaababaabbbabbabbbaabababaaaaaababaaabbabbabbabbaaaabbbbbbaabbabbbbbabababbaaabbaabbbababbb";
    String match = "bba";
    // I need to solve this problem with string hashing
    initalize(a);
    
    int L, R;
    for (L = 0, R = match.size() - 1; R < a.size(); L++, R++) {
      if (needleHash == substringHash(L, R)) ;
    }

    System.out.println(stringHash(match));
    System.out.println(power(12, 2));
  }

  static long stringHash(String a) {
    long hash = 0;
    int i = 0;
    int p = 31;
    long p_power = 1;
    while (i < a.length()) {
      hash = (hash + (a.charAt(i) - 'a' + 1) * p_power) % mod;
      p_power = (p_power * p) % mod;
      ++i;
    }
    return hash;
  }

  static void initalize(String a) {
    arr = new double[a.length()];
    int p = 31;
    long p_power = 1;
    inv[0] = 1;
    arr[0] = a.charAt(0) - 'a' + 1;
    int i = 1;
    while (i < a.length()) {
      p_power = (p_power * p) % mod;
      inv[i] = power(p_power, mod - 2);

      arr[i] = (arr[i - 1] + (a.charAt(i) - 'a' + 1) * p_power) % mod;
      ++i;
    }
    System.out.println(Arrays.toString(arr));
  }

  static long power(long a, int b) {
    long res = 1;
    while (b > 0) {
      if ((b & 1) == 1) res = ((res % mod) * (a % mod)) % mod;
      a = ((a % mod) * (a % mod)) % mod;
      b >>= 1;
    }
    return res;
  }
}
